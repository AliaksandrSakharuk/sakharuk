package by.ita.je.dao.api;

import by.ita.je.model.Car;
import java.time.ZonedDateTime;
import java.util.List;

public interface SearcherCriteriaDao {
    List<Car> findCarByWorkerCriteria(String nameCar, ZonedDateTime fromDataTimeStartWork
            , ZonedDateTime toDataTimeStartWork);
}
