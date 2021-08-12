package by.ita.je.service;

import by.ita.je.dao.WorkerDao;
import by.ita.je.exception.NotCorrectData;
import by.ita.je.exception.NotFoundData;
import by.ita.je.model.Worker;
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
public class TestWorkerServiceImpl {

    @Mock
    private WorkerDao workerDao;

    @InjectMocks
    private WorkerServiceImpl workerService;

    @Test
    public void whenGetAll_emptyList(){
        final List<Worker> actual=workerService.readAll();
        final List<Worker> expected= Collections.emptyList();
        Assertions.assertEquals(expected ,actual);
    }

    @Test
    public  void whenGetAll_returnDetails(){
        final ArrayList<Worker> givenWorkerlList=new ArrayList<Worker>();
        givenWorkerlList.add(getWorker());
        givenWorkerlList.add(getWorker());
        givenWorkerlList.add(getWorker());
        Mockito.when(workerDao.findAll()).thenReturn(givenWorkerlList);
        final List<Worker> actual=workerService.readAll();
        final  List<Worker> expected=new ArrayList<Worker>();
        expected.add(getWorker());
        expected.add(getWorker());
        expected.add(getWorker());
        Assertions.assertEquals(expected ,actual);
        Mockito.verify(workerDao, Mockito.times(1)).findAll();
    }

    @Test
    public void whenCreate_returnWorker(){
        final Worker worker=new Worker();
        worker.setSecondName("Sakharuk");
        Mockito.when(workerDao.save(worker)).thenReturn(worker);
        final Worker actual=workerService.create(worker);
        Worker expected=new Worker();
        expected.setSalary(actual.getSalary());
        expected.setSecondName("Sakharuk");
        expected.setDataTimeStartWork(actual.getDataTimeStartWork());
        Assertions.assertEquals(expected ,actual);
        Mockito.verify(workerDao, Mockito.times(1)).save(worker);
    }

    @Test
    public void whenCreate_returnInCorrectData(){
        final Worker worker=getWorker();
        NotCorrectData inCorrectData=Assertions.assertThrows(NotCorrectData.class, () -> workerService.create(worker));
        Assertions.assertEquals(inCorrectData.getMessage(), "Not correct data NAME_WORKER");
        Mockito.verify(workerDao, Mockito.times(0)).save(worker);
    }

    @Test
    public void whenFindById_returnWorker() {
        Mockito.when(workerDao.findById(1L)).thenReturn(Optional.ofNullable(getWorker()));
        final Worker actual = workerService.findById(1L);
        final Worker expected = getWorker();
        Assertions.assertEquals(expected, actual);
        Mockito.verify(workerDao, Mockito.times(1)).findById(1L);
    }

    @Test
    public void whenFindById_throwsNotFoundData() {
        Long id=1L;
        Mockito.when(workerDao.findById(id)).thenReturn(Optional.empty());
        NotFoundData notFoundData = Assertions.assertThrows(NotFoundData.class, () -> workerService.findById(id));
        Assertions.assertEquals(notFoundData.getMessage(), "The notice with id= " + id + " not found");
        Mockito.verify(workerDao, Mockito.times(1)).findById(id);
    }

    @Test
    public void whenUpdate_returnWorker(){
        Long id=1L;
        final Worker worker=getWorker();
        Mockito.when(workerDao.findById(1L)).thenReturn(Optional.ofNullable(getWorker()));
        Mockito.when(workerDao.save(worker)).thenReturn(worker);

        final  Worker actual=workerService.update(id, worker);
        final Worker expected=getWorker();

        Assertions.assertEquals(expected, actual);
        Mockito.verify(workerDao, Mockito.times(1)).findById(id);
        Mockito.verify(workerDao, Mockito.times(1)).save(worker);
    }

    @Test
    public  void whenUpdate_throwNotFoundData(){
        Long id=2L;
        Mockito.when(workerDao.findById(id)).thenReturn(Optional.empty());
        NotFoundData notFoundData= Assertions.assertThrows(NotFoundData.class, () -> workerService.findById(id));
        Assertions.assertEquals(notFoundData.getMessage(), "The notice with id= " + id + " not found");
        Mockito.verify(workerDao, Mockito.times(1)).findById(id);
    }

    @Test
    public void whenReadByIds_returnList(){
        List<Long> listIds=new ArrayList<Long>();
        listIds.add(1L);
        listIds.add(5L);
        listIds.add(10L);
        List<Worker> givenWorkerList=new ArrayList<Worker>();
        givenWorkerList.add(getWorker());
        givenWorkerList.add(getWorker());
        givenWorkerList.add(getWorker());
        Mockito.when(workerDao.findAllById(listIds)).thenReturn( givenWorkerList);
        List<Worker> actual=workerService.readByIDs(listIds);
        List<Worker> excpected=new ArrayList<Worker>();
        excpected.add(getWorker());
        excpected.add(getWorker());
        excpected.add(getWorker());
        Assertions.assertEquals(excpected, actual);
        Mockito.verify(workerDao, Mockito.times(1)).findAllById(listIds);
    }

    @Test
    void deleteById() {
        workerService.deleteById(2L);
        Mockito.verify(workerDao, Mockito.times(1)).deleteById(2L);
    }

    @Test
    void deleteById_throwException() {
        Long id=2L;
        doThrow(new NotFoundData("The notice with id= " + id + " not found")).when(workerDao).deleteById(id);
        NotFoundData notFoundData = Assertions.assertThrows(NotFoundData.class,()->workerService.deleteById(id));
        Assertions.assertEquals(notFoundData.getMessage(),"The notice with id= " + id + " not found");
    }

    @Test
    void deleteByIDs() {
        List<Long> listIds = new ArrayList<Long>();
        listIds.add(1L);
        listIds.add(5L);
        listIds.add(10L);
        workerService.deleteList(listIds);
        Mockito.verify(workerDao, Mockito.times(1)).deleteAllById(listIds);
    }

    public Worker getWorker(){ return new Worker();}
}
