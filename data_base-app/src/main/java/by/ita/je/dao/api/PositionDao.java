package by.ita.je.dao.api;

import by.ita.je.model.Position;
import java.util.List;

public interface PositionDao {
    public Position save(Position position);

    public void deletePosition(long id);

    public Position updatePosition(long id, Position position);

    public List<Position> findByPosition(String positionName);

    public Position findPositionById(long id);

    public List<Position> findAll();
}
