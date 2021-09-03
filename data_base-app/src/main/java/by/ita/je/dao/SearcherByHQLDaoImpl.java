package by.ita.je.dao;

import by.ita.je.dao.api.SearcherByHQLDao;
import by.ita.je.model.Car;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;
import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.List;
@Repository
public class SearcherByHQLDaoImpl implements SearcherByHQLDao {

    @PersistenceUnit
    private EntityManagerFactory emf;
    private EntityManager entityManager;

    @Override
    public List<Car> findCarByWorkerHQL(String nameCar, ZonedDateTime fromDataTimeStartWork
            , ZonedDateTime toDataTimeStartWork) {
        entityManager=emf.createEntityManager();
        Query query= entityManager.createQuery("CarFindByOrdersBill", Car.class);
        query.setParameter("from_data", fromDataTimeStartWork);
        query.setParameter("to_data",toDataTimeStartWork);
        query.setParameter("name", nameCar);
        List<Car> carList=query.getResultList();
        return carList;
    }
}
