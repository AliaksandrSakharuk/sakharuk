package by.ita.je.service;

import by.ita.je.dao.OrderDao;
import by.ita.je.exception.NotCorrectData;
import by.ita.je.exception.NotFoundData;
import by.ita.je.model.Order;
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
public class TestOrderServiceImpl {

    @Mock
    private OrderDao orderDao;

    @InjectMocks
    private OrderServiceImpl clientService;

    @Test
    public void whenGetAll_emptyList(){
        final List<Order> actual=clientService.readAll();
        final List<Order> expected= Collections.emptyList();
        Assertions.assertEquals(expected ,actual);
    }

    @Test
    public  void whenGetAll_returnClients(){
        final ArrayList<Order> givenOrderList =new ArrayList<Order>();
        givenOrderList.add(new Order());
        givenOrderList.add(new Order());
        givenOrderList.add(new Order());
        Mockito.when(orderDao.findAll()).thenReturn(givenOrderList);
        final List<Order> actual=clientService.readAll();
        final  List<Order> expected=new ArrayList<Order>();
        expected.add(new Order());
        expected.add(new Order());
        expected.add(new Order());
        Assertions.assertEquals(expected ,actual);
        Mockito.verify(orderDao, Mockito.times(1)).findAll();
    }

    @Test
    public void whenCreate_returnClient(){
        final Order order =new Order();
        order.setFirstNameClient("Petia");
        Mockito.when(orderDao.save(order)).thenReturn(order);
        final Order actual=clientService.create(order);
        Order expected=getClient();
        expected.setDataTimeRequest(actual.getDataTimeRequest());
        expected.setFirstNameClient("Petia");
        expected.setLastNameClient("Неизвестно");
        Assertions.assertEquals(expected ,actual);
        Mockito.verify(orderDao, Mockito.times(1)).save(order);
    }

    @Test
    public void whenCreate_returnInCorrectData(){
        final Order order =new Order();
        NotCorrectData inCorrectData=Assertions.assertThrows(NotCorrectData.class, () -> clientService.create(order));
        Assertions.assertEquals(inCorrectData.getMessage(), "Not correct data FIRST_NAME_CLIENT");
        Mockito.verify(orderDao, Mockito.times(0)).save(order);
    }

    @Test
    public void whenFindById_returnClient() {
        Mockito.when(orderDao.findById(1L)).thenReturn(Optional.ofNullable(new Order()));
        final Order actual = clientService.findById(1L);
        final Order expected = getClient();
        Assertions.assertEquals(expected, actual);
        Mockito.verify(orderDao, Mockito.times(1)).findById(1L);
    }

    @Test
    public void whenFindById_throwsNotFoundData() {
        Long id=1L;
        Mockito.when(orderDao.findById(id)).thenReturn(Optional.empty());
        NotFoundData notFoundData = Assertions.assertThrows(NotFoundData.class, () -> clientService.findById(id));
        Assertions.assertEquals(notFoundData.getMessage(), "The notice with id= " + id + " not found");
        Mockito.verify(orderDao, Mockito.times(1)).findById(id);
    }

    @Test
    public void whenUpdate_returnClient(){
        final Order order =getClient();
        Mockito.when(orderDao.findById(1L)).thenReturn(Optional.ofNullable(getClient()));
        Mockito.when(orderDao.save(order)).thenReturn(order);

        final Order actual=clientService.update(1L, order);
        final Order expected=getClient();

        Assertions.assertEquals(expected, actual);
        Mockito.verify(orderDao, Mockito.times(1)).findById(1L);
        Mockito.verify(orderDao, Mockito.times(1)).save(order);
    }

    @Test
    public  void whenUpdate_throwNotFoundData(){
        Long id=1L;
        Mockito.when(orderDao.findById(id)).thenReturn(Optional.empty());
        NotFoundData notFoundData= Assertions.assertThrows(NotFoundData.class, () -> clientService.findById(id));
        Assertions.assertEquals(notFoundData.getMessage(), "The notice with id= " + id + " not found");
        Mockito.verify(orderDao, Mockito.times(1)).findById(id);
    }

    @Test
    public void whenReadByIds_returnList(){
        List<Long> listIds=new ArrayList<Long>();
        listIds.add(1L);
        listIds.add(5L);
        listIds.add(10L);
        List<Order> givenOrderList =new ArrayList<Order>();
        givenOrderList.add(getClient());
        givenOrderList.add(getClient());
        givenOrderList.add(getClient());
        Mockito.when(orderDao.findAllById(listIds)).thenReturn(givenOrderList);
        List<Order> actual=clientService.readByIDs(listIds);
        List<Order> excpected=new ArrayList<Order>();
        excpected.add(getClient());
        excpected.add(getClient());
        excpected.add(getClient());
        Assertions.assertEquals(excpected, actual);
        Mockito.verify(orderDao, Mockito.times(1)).findAllById(listIds);
    }

    @Test
    void deleteById() {
        clientService.deleteById(1L);
        Mockito.verify(orderDao, Mockito.times(1)).deleteById(1L);
    }

    @Test
    void deleteById_throwException() {
        Long id=2L;
        doThrow(new NotFoundData("The notice with id= " + id + " not found")).when(orderDao).deleteById(id);
        NotFoundData notFoundData = Assertions.assertThrows(NotFoundData.class,()->clientService.deleteById(id));
        Assertions.assertEquals(notFoundData.getMessage(),"The notice with id= " + id + " not found");
    }

    @Test
    void deleteByIDs() {
        List<Long> listIds = new ArrayList<Long>();
        listIds.add(1L);
        listIds.add(5L);
        listIds.add(10L);
        clientService.deleteList(listIds);
        Mockito.verify(orderDao, Mockito.times(1)).deleteAllById(listIds);
    }

    public Order getClient () {
        return new Order();
    }
}

