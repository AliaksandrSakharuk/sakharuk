package by.ita.je.dao;

import by.ita.je.dao.api.PositionDao;
import by.ita.je.model.Position;
import by.ita.je.model.enums.Status;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Component
@RequiredArgsConstructor
public class PositionDaoImpl implements PositionDao {

    @PersistenceContext
    private final EntityManager entityManager;

    @Override
    @Transactional
    public Position save(Position position) {
        entityManager.persist(position);
        return  position;
    }

    @Override
    @Transactional
    public void deletePosition(Position position) {
        entityManager.remove(position);
    }

    @Override
    @Transactional
    public Position updatePosition(long id,Position position) {
        position.setId(id);
        entityManager.detach(position);
        entityManager.merge(position);
        return position;
    }

    @Override
    @Transactional
    public List<Position> findByPosition(String positionName) {
        Status position= Status.of(positionName);
        Query query=entityManager.createQuery(
                "SELECT position FROM Position position WHERE position.status=:position");
        query.setParameter("position", position);
        List<Position> listPosition=query.getResultList();
        return listPosition;
    }

    @Override
    @Transactional
    public Position findPositionById(long id) {
        return entityManager.find(Position.class, id);
    }

    @Override
    public List<Position> findAll() {
        Query query = entityManager.createQuery("SELECT position FROM Position position");
        List<Position> listPosition=query.getResultList();
        return listPosition;
    }
}
