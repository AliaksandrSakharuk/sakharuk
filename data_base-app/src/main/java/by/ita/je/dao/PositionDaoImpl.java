package by.ita.je.dao;

import by.ita.je.dao.api.PositionDao;
import by.ita.je.model.Position;
import by.ita.je.model.enums.Status;
import org.springframework.stereotype.Repository;
import javax.persistence.*;
import java.util.List;

@Repository
public class PositionDaoImpl implements PositionDao {

    @PersistenceUnit
    private EntityManagerFactory emf;
    private EntityManager entityManager;

    @Override
    public Position save(Position position) {
        entityManager=emf.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(position);
        entityManager.getTransaction().commit();
        return  position;
    }

    @Override
    public void deletePosition(long id) {
        entityManager=emf.createEntityManager();
        entityManager.getTransaction().begin();
        Position position=entityManager.find(Position.class, id);
        entityManager.remove(position);
        entityManager.getTransaction().commit();
    }

    @Override
    public Position updatePosition(long id,Position position) {
        entityManager=emf.createEntityManager();
        position.setId(id);
        entityManager.getTransaction().begin();
        entityManager.merge(position);
        entityManager.getTransaction().commit();
        return position;
    }

    @Override
    public List<Position> findByPosition(String positionName) {
        entityManager=emf.createEntityManager();
        Status position= Status.of(positionName);
        Query query=entityManager.createQuery(
                "SELECT position FROM Position position WHERE position.status=:position");
        query.setParameter("position", position);
        List<Position> listPosition=query.getResultList();
        return listPosition;
    }

    @Override
    public Position findPositionById(long id) {
        entityManager=emf.createEntityManager();
        entityManager.getTransaction().begin();
        Position position=entityManager.find(Position.class, id);
        entityManager.getTransaction().commit();
        return position;
    }

    @Override
    public List<Position> findAll() {
        entityManager=emf.createEntityManager();
        Query query = entityManager.createQuery("SELECT position FROM Position position");
        List<Position> listPosition=query.getResultList();
        return listPosition;
    }
}
