package by.ita.je.service;

import by.ita.je.exception.NotCorrectData;
import by.ita.je.exception.NotFoundData;
import by.ita.je.model.*;
import by.ita.je.model.enums.Status;
import by.ita.je.service.api.ServiceBusiness;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestBusinessServiceImpl {

    @Autowired
    ServiceBusiness service;

    @Test
    public void whenCreate_returnCar_IfNoRelationship(){
        Car expected=getCar();
        Car actual=service.create(expected);
        Assertions.assertNotNull(actual);
        Assertions.assertEquals(expected.getNameCar(),actual.getNameCar());
        Assertions.assertEquals(expected.getNameOwner(),actual.getNameOwner());
        Assertions.assertEquals(expected.getMileage(),actual.getMileage());
        Assertions.assertTrue(actual.getId()>1);
        actual.getDetails().forEach(detail -> Assertions.assertTrue(detail.getId()>0 && detail.getName()!=null));
        Assertions.assertTrue(actual.getOrder().getId()>0 && actual.getOrder().getFirstNameClient()!=null);
        actual.getOrder().getListWorker().forEach(worker ->
                Assertions.assertTrue(worker.getId()>0 && worker.getFirstName()!=null && worker.getPosition()!=null));
    }

    @Test
    public void whenCreate_returnCar_IfRelationship() {
        Car expected=getCar();
        expected.setOrder(getOrder());
        expected.setDetails(List.of(getDetail(),getDetail()));
        expected.getOrder().setListWorker(List.of(getWorker(), getWorker()));
        Car actual=service.create(expected);
        Assertions.assertNotNull(actual);
        Assertions.assertEquals(expected.getNameCar(),actual.getNameCar());
        Assertions.assertEquals(expected.getNameOwner(),actual.getNameOwner());
        Assertions.assertEquals(expected.getMileage(),actual.getMileage());
        Assertions.assertTrue(actual.getId()>1);
        actual.getDetails().forEach(detail -> Assertions.assertTrue(detail.getId()>0
                && detail.getName()=="Key" && detail.getNotes()=="best"));

        Assertions.assertTrue(actual.getOrder().getId()>0 && actual.getOrder().getFirstNameClient()=="MILE");

        actual.getOrder().getListWorker().forEach(worker ->
                Assertions.assertTrue(worker.getId()>0
                        && worker.getFirstName()=="Vova" && worker.getSecondName()== "Timati"
                        && worker.getPosition().getStatus()==Status.MASTER));
    }

    @Test
    public void whenCreate_returnInCorrectData(){
        final Car car=new Car();
        NotCorrectData inCorrectData=Assertions.assertThrows(NotCorrectData.class, () -> service.create(car));
        Assertions.assertEquals(inCorrectData.getMessage(), "Not correct data NAME_CAR");
    }

    @Test
    public void whenRead_returnCar(){
        final Car actual=service.read(1L);
        Assertions.assertEquals("ZAZ",actual.getNameCar());
        Assertions.assertEquals("KOSTISHKO", actual.getNameOwner());
        Assertions.assertEquals("HR", actual.getOrder().getLastNameClient());
    }

    @Test
    public void whenRead_throwsNotFoundData() {
        Long id=5L;
        NotFoundData notFoundData= Assertions.assertThrows(NotFoundData.class, () -> service.read(id));
        Assertions.assertEquals(notFoundData.getMessage(), "The notice with id= " + id + " not found");
    }

    @Test
    public void whenUpdate_returnCar(){
        Car expected=getCar();
        Detail detail=getDetail();
        detail.setId(1L);
        expected.setDetails(List.of(detail));
        Order order=getOrder();
        order.setId(1L);
        expected.setOrder(order);
        Worker master=getWorker();
        master.setId(1L);
        expected.getOrder().setListWorker(List.of(master));
        Car actual=service.update(1L, expected);

        Assertions.assertEquals("Opel", actual.getNameCar());
        Assertions.assertTrue(actual.getId()>0);
        Assertions.assertEquals("MILE", actual.getOrder().getFirstNameClient());
        Assertions.assertTrue(actual.getOrder().getId()>0);
    }

    @Test
    public  void whenUpdate_throwNotFoundData(){
        Long id=15L;
        Car car=getCar();
        NotFoundData notFoundData=Assertions.assertThrows(NotFoundData.class, () -> service.update(id, car));
        Assertions.assertEquals(notFoundData.getMessage(), "The notice with id= " + id + " not found");
    }

    @Test
    public void whenDelete_thenOk(){
        Long id=3L;
        service.delete(id);
        NotFoundData notFoundData= Assertions.assertThrows(NotFoundData.class, () -> service.read(id));
        Assertions.assertEquals(notFoundData.getMessage(), "The notice with id= " + id + " not found");
    }

    @Test
    public void whenDelete_throwNotFoundData(){
        Long id=7L;
        NotFoundData notFoundData= Assertions.assertThrows(NotFoundData.class, () -> service.delete(id));
        Assertions.assertEquals(notFoundData.getMessage(), "The notice with id= " + id + " not found");
    }

    private Car getCar(){
        return new Car.Builder()
                .withNameCar("Opel")
                .withNameOwner("IT")
                .withMileage(202123)
                .build();
    }

    private Detail getDetail(){
        return new Detail.Builder()
                .withName("Key")
                .withNotes("best")
                .build();
    }

    private Order getOrder(){
        return new Order.Builder()
                .withFirstName("MILE")
                .withLastName("sales")
                .build();
    }

    private Worker getWorker(){
        Worker worker=new Worker.Builder()
                .withFirstName("Vova")
                .withSecondName("Timati")
                .build();
        worker.setPosition(Position.builder().status(Status.MASTER).build());
        return worker;
    }
}
