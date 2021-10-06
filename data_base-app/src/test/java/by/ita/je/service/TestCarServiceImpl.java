package by.ita.je.service;

import by.ita.je.dao.api.CarDao;
import by.ita.je.exception.NotCorrectData;
import by.ita.je.exception.NotFoundData;
import by.ita.je.model.Car;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import static org.mockito.Mockito.doThrow;

@ExtendWith(MockitoExtension.class)
public class TestCarServiceImpl {

    @Mock
    private CarDao carDao;

    @InjectMocks
    private CarServiceImpl carService;

    @Test
    public void whenGetAll_emptyList(){
        final List<Car> actual=carService.readAll();
        final List<Car> expected=Collections.emptyList();
        Assertions.assertEquals(expected ,actual);
    }

    @Test
    public  void whenGetAll_returnCars(){
        final ArrayList<Car> givenCarsList=new ArrayList<Car>();
        givenCarsList.add(new Car());
        givenCarsList.add(new Car());
        givenCarsList.add(new Car());
        Mockito.when(carDao.findAll()).thenReturn(givenCarsList);
        final List<Car> actual=carService.readAll();
        final  List<Car> expected=new ArrayList<Car>();
        expected.add(new Car());
        expected.add(new Car());
        expected.add(new Car());
        Assertions.assertEquals(expected ,actual);
        Mockito.verify(carDao, Mockito.times(1)).findAll();
    }

    @Test
    public void whenCreate_returnCar(){
        final Car car=new Car();
        car.setNameCar("BMW");
        Mockito.when(carDao.save(car)).thenReturn(car);
        final Car actual=carService.create(car);
        Car expected=getCar();
        expected.setDataTimeStartFix(actual.getDataTimeStartFix());
        expected.setNameCar("BMW");
        Assertions.assertEquals(expected ,actual);
        Mockito.verify(carDao, Mockito.times(1)).save(car);
    }

    @Test
    public void whenCreate_returnCarTesla(){
        final Car car=new Car();
        car.setNameCar("TESLA");
        Mockito.when(carDao.save(car)).thenReturn(car);
        final Car actual=carService.create(car);

        Car expected=getCar();
        expected.setDataTimeStartFix(actual.getDataTimeStartFix());
        expected.setNameCar("TESLA");
        expected.setElectro(true);
        Assertions.assertEquals(expected ,actual);
        Mockito.verify(carDao, Mockito.times(1)).save(car);
    }

    @Test
    public void whenCreate_returnInCorrectData(){
        final Car car=new Car();
        NotCorrectData inCorrectData=Assertions.assertThrows(NotCorrectData.class, () -> carService.create(car));
        Assertions.assertEquals(inCorrectData.getMessage(), "Not correct data NAME_CAR");
        Mockito.verify(carDao, Mockito.times(0)).save(car);
    }

    @Test
    public void whenFindById_returnCar(){
        Mockito.when(carDao.findById(1L)).thenReturn(Optional.ofNullable(new Car()));
        final Car actual=carService.findById(1L);
        final Car expected=getCar();
        Assertions.assertEquals(expected,actual);
        Mockito.verify(carDao, Mockito.times(1)).findById(1L);
    }

    @Test
    public void whenFindById_throwsNotFoundData(){
        Long id=2L;
        Mockito.when(carDao.findById(id)).thenReturn(Optional.empty());
        NotFoundData notFoundData= Assertions.assertThrows(NotFoundData.class, () -> carService.findById(id));
        Assertions.assertEquals(notFoundData.getMessage(), "The notice with id= " + id + " not found");
        Mockito.verify(carDao, Mockito.times(1)).findById(id);
    }
    @Test
    public void whenUpdate_returnCar(){
        final Car car=new Car();
        Mockito.when(carDao.findById(1L)).thenReturn(Optional.ofNullable(new Car()));
        Mockito.when(carDao.save(car)).thenReturn(car);

        final  Car actual=carService.update(1L, car);
        final Car expected=new Car();

        Assertions.assertEquals(expected, actual);
        Mockito.verify(carDao, Mockito.times(1)).findById(1L);
        Mockito.verify(carDao, Mockito.times(1)).save(car);
    }

    @Test
    public  void whenUpdate_throwNotFoundData(){
        Long id=2L;
        Mockito.when(carDao.findById(id)).thenReturn(Optional.empty());
        NotFoundData notFoundData= Assertions.assertThrows(NotFoundData.class, () -> carService.findById(id));
        Assertions.assertEquals(notFoundData.getMessage(), "The notice with id= " + id + " not found");
        Mockito.verify(carDao, Mockito.times(1)).findById(id);
    }

    @Test
    public void whenReadByIds_returnList(){
        List<Long> listIds=new ArrayList<Long>();
        listIds.add(1L);
        listIds.add(5L);
        listIds.add(10L);
        List<Car> givenCarList=new ArrayList<Car>();
        givenCarList.add(new Car());
        givenCarList.add(new Car());
        givenCarList.add(new Car());

        Mockito.when(carDao.findAllById(listIds)).thenReturn(givenCarList);

        List<Car> actual=carService.readByIDs(listIds);
        List<Car> excpected=new ArrayList<Car>();
        excpected.add(new Car());
        excpected.add(new Car());
        excpected.add(new Car());
        Assertions.assertEquals(excpected, actual);
        Mockito.verify(carDao, Mockito.times(1)).findAllById(listIds);
    }

    @Test
    void deleteById() {
        carService.deleteById(1L);
        Mockito.verify(carDao, Mockito.times(1)).deleteById(1L);

    }
    @Test
    void deleteById_throwException() {
        Long id=2L;
        doThrow(new NotFoundData("The notice with id= " + id + " not found")).when(carDao).deleteById(id);
        NotFoundData notFoundData = Assertions.assertThrows(NotFoundData.class,()->carService.deleteById(id));
        Assertions.assertEquals(notFoundData.getMessage(),"The notice with id= " + id + " not found");
    }

    @Test
    void deleteByIDs() {
        List <Long> listIds = new ArrayList<Long>();
        listIds.add(1L);
        listIds.add(5L);
        listIds.add(10L);
        carService.deleteList(listIds);
        Mockito.verify(carDao, Mockito.times(1)).deleteAllById(listIds);
    }

    private Car getCar(){ return new Car();}
}
