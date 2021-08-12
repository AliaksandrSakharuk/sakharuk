package by.ita.je.service;

import by.ita.je.dao.CarDao;
import by.ita.je.exception.NotCorrectData;
import by.ita.je.exception.NotFoundData;
import by.ita.je.model.Car;
import by.ita.je.service.api.ServiceCar;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Spliterator;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Component
@RequiredArgsConstructor
public class CarServiceImpl implements ServiceCar {

    private final CarDao carDao;

    @Override
    public Car create(Car car) throws NotCorrectData {
        if(car.getNameCar()==null) throw new NotCorrectData("Not correct data NAME_CAR");
        if(car.getNameCar().equalsIgnoreCase("tesla"))
            car.setElectro(true);
        car.setDataTimeStartFix(ZonedDateTime.now());
        return carDao.save(car);
    }

    @Override
    public Car findById(Long id) throws NotFoundData {
        final Car car = carDao.findById(id)
                .orElseThrow(() -> new NotFoundData(id + " not found"));
        return car;
    }

    @Override
    public List<Car> readByIDs(List<Long> listIds) {
        final Spliterator<Car> result=carDao.findAllById(listIds).spliterator();
        return StreamSupport.stream(result, false)
                .collect(Collectors.toList());
    }

    @Override
    public List<Car> readAll() {
        final Spliterator<Car> result = carDao.findAll().spliterator();
        return StreamSupport
                .stream(result, false)
                .collect(Collectors.toList());
    }

    @Override
    public Car update(Long id, Car carNew) {
        final Car car = carDao.findById(id)
                .orElseThrow(() -> new NotFoundData(id + " not found"));
        if(carNew.getNameCar()!="") car.setNameCar(carNew.getNameCar());
        if(carNew.getNameOwner()!="") car.setNameOwner(carNew.getNameOwner());
        if(carNew.getMileage()>0) car.setMileage(carNew.getMileage());
        if(carNew.getPower()>0) car.setPower(carNew.getPower());
        return carDao.save(car);
    }

    @Override
    public void deleteById(Long id) throws NotFoundData {
        try {
            carDao.deleteById(id);
        }catch (Exception e){
            throw new NotFoundData(id + " not found");
        }
    }

    @Override
    public void deleteList(List<Long> listIds) {
        carDao.deleteAllById(listIds);
    }
}
