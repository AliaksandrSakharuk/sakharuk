package by.ita.je.dao.api;

import by.ita.je.model.Car;
import by.ita.je.model.Worker;
import java.util.List;

public interface BusinessDao {

   public Car save(Car car);

    public void create(Car car);

    public void delete(long id);

    public List<Worker> findByName(String name);

}
