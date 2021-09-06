package by.ita.je.dao;

import by.ita.je.dao.api.SearcherCriteriaDao;
import by.ita.je.model.*;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Root;
import java.time.ZonedDateTime;
import java.util.List;
@Repository
public class SearcherCriteriaDaoImpl implements SearcherCriteriaDao {

    @PersistenceUnit
    private EntityManagerFactory emf;
    private EntityManager entityManager;

    @Override
    public List<Car> findCarByWorkerCriteria(String nameCar, ZonedDateTime fromDataTimeStartWork
            , ZonedDateTime toDataTimeStartWork) {
        entityManager=emf.createEntityManager();
        CriteriaBuilder criteriaBuilder=entityManager.getCriteriaBuilder();
        CriteriaQuery<Car> query=criteriaBuilder.createQuery(Car.class);
        Root<Car> root=query.from(Car.class);
        Join<Car, Order> orderJoin=root.join(Car_.ORDER);
        Join<Order, Worker> workerJoin=root.join(Order_.LIST_WORKER);
        query.select(root);
        query.where(criteriaBuilder.and(criteriaBuilder.between(workerJoin.get(Worker_.DATA_TIME_START_WORK)
                ,fromDataTimeStartWork,toDataTimeStartWork)),
                criteriaBuilder.equal(root.get(Car_.nameCar),nameCar));
        TypedQuery<Car> typedQuery = entityManager.createQuery(query);
        List<Car> list = typedQuery.getResultList();

        return list;
    }
}
