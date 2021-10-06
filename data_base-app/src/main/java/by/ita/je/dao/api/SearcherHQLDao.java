package by.ita.je.dao.api;

import by.ita.je.model.Car;
import java.time.ZonedDateTime;
import java.util.List;

public interface SearcherHQLDao {
    List<Car> findCarByWorkerHQL(String nameCar, ZonedDateTime fromDataTimeStartWork
            , ZonedDateTime toDataTimeStartWork);
}
