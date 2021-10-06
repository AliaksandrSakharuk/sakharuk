package by.ita.je.service.api;

import by.ita.je.model.Position;
import java.util.List;

public interface ServicePosition {
    Position create(Position position);

    void delete(long id);

    Position update(long id,Position positionNew);

    List<Position> findPosition(String positionName);

    public Position findPositionById(long id);

    public List<Position> findAll();

}
