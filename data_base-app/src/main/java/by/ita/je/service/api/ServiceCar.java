package by.ita.je.service.api;

import by.ita.je.exception.NotCorrectData;
import by.ita.je.exception.NotFoundData;
import by.ita.je.model.Car;
import by.ita.je.model.Detail;

import java.util.List;

public interface ServiceCar {
    Car create(Car car)  throws NotCorrectData;

    Car findById(Long id)throws NotFoundData;

    List<Car> readByIDs(List <Long> listIds);

    List<Car> readAll();

    Car update(Long id, Car car);

    void deleteById(Long id)throws NotFoundData;

    void deleteList(List <Long> listIds);

}
