package by.ita.je.dao;

import by.ita.je.dao.api.SearcherCriteriaDao;
import by.ita.je.model.Car;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import java.time.ZonedDateTime;
import java.util.List;

public class SearcherCriteriaDaoImpl implements SearcherCriteriaDao {

    @PersistenceUnit
    private EntityManagerFactory emf;
    private EntityManager entityManager;
    @Override
    public List<Car> findCarByWorkerCriteria(String nameCar, ZonedDateTime fromDataTimeStartWork
            , ZonedDateTime toDataTimeStartWork) {
        entityManager=emf.createEntityManager();

        return null;
    }
}
