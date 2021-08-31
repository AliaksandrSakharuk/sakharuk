package by.ita.je.service;

import by.ita.je.dao.api.PositionDao;
import by.ita.je.model.Position;
import by.ita.je.service.api.ServicePosition;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PositionServiceImpl implements ServicePosition {

    private final PositionDao positionDao;

    @Override
    @Transactional
    public Position create(Position position) {
        return positionDao.save(position);
    }

    @Override
    public void delete(long id) {
        positionDao.deletePosition(id);
    }

    @Override
    @Transactional
    public Position update(long id, Position positionNew) {
        return positionDao.updatePosition(id, positionNew);
    }

    @Override
    public List<Position> findPosition(String positionName) {
        return positionDao.findByPosition(positionName);
    }

    @Override
    public Position findPositionById(long id) {
        return positionDao.findPositionById(id);
    }

    @Override
    @Transactional
    public List<Position> findAll() {
        List<Position> result=positionDao.findAll();
        return  result;
    }


}
