package by.ita.je.dao.api;

import by.ita.je.model.Car;
import org.springframework.data.repository.CrudRepository;

public interface CarDao extends CrudRepository<Car, Long> {
}
