package by.ita.je.dao;

import by.ita.je.dao.api.BusinessDao;
import by.ita.je.dao.api.CarDao;
import by.ita.je.model.Car;
import by.ita.je.model.Worker;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import javax.persistence.*;
import javax.transaction.Transactional;
import java.util.List;

@Component
@AllArgsConstructor
public class BusinessDaoImpl implements BusinessDao {

    @PersistenceContext
    EntityManager entityManager;
    final public CarDao carDao;

    @Override
    public Car save(Car car) {
        return carDao.save(car);
    }

    @Override
    @Transactional
    public void create(Car car) {
        entityManager.persist(car);
    }

    @Override
    public void delete(long id) {
    }

    @Override
    @Transactional
    public List<Worker> findByName(String name) {
        Query query=entityManager.createQuery("SELECT worker FROM Worker worker WHERE worker.firstName=:name");
        query.setParameter("name", name);
        return query.getResultList();
    }

}
