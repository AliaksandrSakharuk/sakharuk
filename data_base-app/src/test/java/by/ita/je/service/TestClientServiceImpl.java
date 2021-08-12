package by.ita.je.service;

import by.ita.je.dao.ClientDao;
import by.ita.je.exception.NotCorrectData;
import by.ita.je.exception.NotFoundData;
import by.ita.je.model.Client;
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
public class TestClientServiceImpl {

    @Mock
    private ClientDao clientDao;

    @InjectMocks
    private ClientServiceImpl clientService;

    @Test
    public void whenGetAll_emptyList(){
        final List<Client> actual=clientService.readAll();
        final List<Client> expected= Collections.emptyList();
        Assertions.assertEquals(expected ,actual);
    }

    @Test
    public  void whenGetAll_returnClients(){
        final ArrayList<Client> givenClientList=new ArrayList<Client>();
        givenClientList.add(new Client());
        givenClientList.add(new Client());
        givenClientList.add(new Client());
        Mockito.when(clientDao.findAll()).thenReturn(givenClientList);
        final List<Client> actual=clientService.readAll();
        final  List<Client> expected=new ArrayList<Client>();
        expected.add(new Client());
        expected.add(new Client());
        expected.add(new Client());
        Assertions.assertEquals(expected ,actual);
        Mockito.verify(clientDao, Mockito.times(1)).findAll();
    }

    @Test
    public void whenCreate_returnClient(){
        final Client client=new Client();
        client.setFirstName("Petia");
        Mockito.when(clientDao.save(client)).thenReturn(client);
        final Client actual=clientService.create(client);
        Client expected=getClient();
        expected.setDataTimeRequest(actual.getDataTimeRequest());
        expected.setFirstName("Petia");
        expected.setLastName("Неизвестно");
        Assertions.assertEquals(expected ,actual);
        Mockito.verify(clientDao, Mockito.times(1)).save(client);
    }

    @Test
    public void whenCreate_returnInCorrectData(){
        final Client client=new Client();
        NotCorrectData inCorrectData=Assertions.assertThrows(NotCorrectData.class, () -> clientService.create(client));
        Assertions.assertEquals(inCorrectData.getMessage(), "Not correct data FIRST_NAME_CLIENT");
        Mockito.verify(clientDao, Mockito.times(0)).save(client);
    }

    @Test
    public void whenFindById_returnClient() {
        Mockito.when(clientDao.findById(1L)).thenReturn(Optional.ofNullable(new Client()));
        final Client actual = clientService.findById(1L);
        final Client expected = getClient();
        Assertions.assertEquals(expected, actual);
        Mockito.verify(clientDao, Mockito.times(1)).findById(1L);
    }

    @Test
    public void whenFindById_throwsNotFoundData() {
        Long id=1L;
        Mockito.when(clientDao.findById(id)).thenReturn(Optional.empty());
        NotFoundData notFoundData = Assertions.assertThrows(NotFoundData.class, () -> clientService.findById(id));
        Assertions.assertEquals(notFoundData.getMessage(), "The notice with id= " + id + " not found");
        Mockito.verify(clientDao, Mockito.times(1)).findById(id);
    }

    @Test
    public void whenUpdate_returnClient(){
        final Client client=getClient();
        Mockito.when(clientDao.findById(1L)).thenReturn(Optional.ofNullable(getClient()));
        Mockito.when(clientDao.save(client)).thenReturn(client);

        final  Client actual=clientService.update(1L, client);
        final Client expected=getClient();

        Assertions.assertEquals(expected, actual);
        Mockito.verify(clientDao, Mockito.times(1)).findById(1L);
        Mockito.verify(clientDao, Mockito.times(1)).save(client);
    }

    @Test
    public  void whenUpdate_throwNotFoundData(){
        Long id=1L;
        Mockito.when(clientDao.findById(id)).thenReturn(Optional.empty());
        NotFoundData notFoundData= Assertions.assertThrows(NotFoundData.class, () -> clientService.findById(id));
        Assertions.assertEquals(notFoundData.getMessage(), "The notice with id= " + id + " not found");
        Mockito.verify(clientDao, Mockito.times(1)).findById(id);
    }

    @Test
    public void whenReadByIds_returnList(){
        List<Long> listIds=new ArrayList<Long>();
        listIds.add(1L);
        listIds.add(5L);
        listIds.add(10L);
        List<Client> givenClientList=new ArrayList<Client>();
        givenClientList.add(getClient());
        givenClientList.add(getClient());
        givenClientList.add(getClient());
        Mockito.when(clientDao.findAllById(listIds)).thenReturn(givenClientList);
        List<Client> actual=clientService.readByIDs(listIds);
        List<Client> excpected=new ArrayList<Client>();
        excpected.add(getClient());
        excpected.add(getClient());
        excpected.add(getClient());
        Assertions.assertEquals(excpected, actual);
        Mockito.verify(clientDao, Mockito.times(1)).findAllById(listIds);
    }

    @Test
    void deleteById() {
        clientService.deleteById(1L);
        Mockito.verify(clientDao, Mockito.times(1)).deleteById(1L);
    }

    @Test
    void deleteById_throwException() {
        Long id=2L;
        doThrow(new NotFoundData("The notice with id= " + id + " not found")).when(clientDao).deleteById(id);
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
        Mockito.verify(clientDao, Mockito.times(1)).deleteAllById(listIds);
    }

    public Client getClient () {
        return new Client();
    }
}

