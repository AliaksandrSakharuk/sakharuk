package by.ita.je.service;

import by.ita.je.dao.DetailDao;
import by.ita.je.exception.NotCorrectData;
import by.ita.je.exception.NotFoundData;
import by.ita.je.model.Detail;
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
public class TestDetailsServiceImpl {

    @Mock
    private DetailDao detailDao;

    @InjectMocks
    private DetailServiceImpl detailService;

    @Test
    public void whenGetAll_emptyList(){
        final List<Detail> actual=detailService.readAll();
        final List<Detail> expected= Collections.emptyList();
        Assertions.assertEquals(expected ,actual);
    }

    @Test
    public  void whenGetAll_returnDetails(){
        final ArrayList<Detail> givenDetailList=new ArrayList<Detail>();
        givenDetailList.add(getDetail());
        givenDetailList.add(getDetail());
        givenDetailList.add(getDetail());
        Mockito.when(detailDao.findAll()).thenReturn(givenDetailList);
        final List<Detail> actual=detailService.readAll();
        final  List<Detail> expected=new ArrayList<Detail>();
        expected.add(getDetail());
        expected.add(getDetail());
        expected.add(getDetail());
        Assertions.assertEquals(expected ,actual);
        Mockito.verify(detailDao, Mockito.times(1)).findAll();
    }

    @Test
    public void whenCreate_returnDetail(){
        final Detail detail=getDetail();
        detail.setName("key");
        Mockito.when(detailDao.save(detail)).thenReturn(detail);
        final Detail actual=detailService.create(detail);
        Detail expected=getDetail();
        expected.setName("key");
        expected.setNotes(actual.getNotes());
        expected.setSellingPrice(actual.getSellingPrice());
        expected.setDataTimeDelivery(actual.getDataTimeDelivery());
        Assertions.assertEquals(expected ,actual);
        Mockito.verify(detailDao, Mockito.times(1)).save(detail);
    }

    @Test
    public void whenCreate_returnInCorrectData(){
        final Detail detail=getDetail();
        NotCorrectData inCorrectData=Assertions.assertThrows(NotCorrectData.class, () -> detailService.create(detail));
        Assertions.assertEquals(inCorrectData.getMessage(), "Not correct data NAME_DETAIL");
        Mockito.verify(detailDao, Mockito.times(0)).save(detail);
    }

    @Test
    public void whenFindById_returnDetail() {
        Mockito.when(detailDao.findById(1L)).thenReturn(Optional.ofNullable(getDetail()));
        final Detail actual = detailService.findById(1L);
        final Detail expected = getDetail();
        Assertions.assertEquals(expected, actual);
        Mockito.verify(detailDao, Mockito.times(1)).findById(1L);
    }

    @Test
    public void whenFindById_throwsNotFoundData() {
        Long id=1L;
        Mockito.when(detailDao.findById(id)).thenReturn(Optional.empty());
        NotFoundData notFoundData = Assertions.assertThrows(NotFoundData.class, () -> detailService.findById(id));
        Assertions.assertEquals(notFoundData.getMessage(), "The notice with id= " + id + " not found");
        Mockito.verify(detailDao, Mockito.times(1)).findById(id);
    }

    @Test
    public void whenUpdate_returnDetail(){
        Long id=1L;
        final Detail detail=getDetail();
        Mockito.when(detailDao.findById(1L)).thenReturn(Optional.ofNullable(getDetail()));
        Mockito.when(detailDao.save(detail)).thenReturn(detail);
        final  Detail actual=detailService.update(id, detail);
        final Detail expected=getDetail();
        Assertions.assertEquals(expected, actual);
        Mockito.verify(detailDao, Mockito.times(1)).findById(id);
        Mockito.verify(detailDao, Mockito.times(1)).save(detail);
    }

    @Test
    public  void whenUpdate_throwNotFoundData(){
        Long id=2L;
        Mockito.when(detailDao.findById(id)).thenReturn(Optional.empty());
        NotFoundData notFoundData= Assertions.assertThrows(NotFoundData.class, () -> detailService.findById(id));
        Assertions.assertEquals(notFoundData.getMessage(), "The notice with id= " + id + " not found");
        Mockito.verify(detailDao, Mockito.times(1)).findById(id);
    }

    @Test
    public void whenReadByIds_returnList(){
        List<Long> listIds=new ArrayList<Long>();
        listIds.add(1L);
        listIds.add(5L);
        listIds.add(10L);
        List<Detail> givenDetailList=new ArrayList<Detail>();
        givenDetailList.add(getDetail());
        givenDetailList.add(getDetail());
        givenDetailList.add(getDetail());
        Mockito.when(detailDao.findAllById(listIds)).thenReturn( givenDetailList);
        List<Detail> actual=detailService.readByIDs(listIds);
        List<Detail> excpected=new ArrayList<Detail>();
        excpected.add( getDetail());
        excpected.add(getDetail());
        excpected.add(getDetail());
        Assertions.assertEquals(excpected, actual);
        Mockito.verify(detailDao, Mockito.times(1)).findAllById(listIds);
    }

    @Test
    void deleteById() {
        detailService.deleteById(2L);
        Mockito.verify(detailDao, Mockito.times(1)).deleteById(2L);
    }

    @Test
    void deleteById_throwException() {
        Long id=2L;
        doThrow(new NotFoundData("The notice with id= " + id + " not found")).when(detailDao).deleteById(id);
        NotFoundData notFoundData = Assertions.assertThrows(NotFoundData.class,()->detailService.deleteById(id));
        Assertions.assertEquals(notFoundData.getMessage(),"The notice with id= " + id + " not found");
    }

    @Test
    void deleteByIDs() {
        List<Long> listIds = new ArrayList<Long>();
        listIds.add(1L);
        listIds.add(5L);
        listIds.add(10L);
        detailService.deleteList(listIds);
        Mockito.verify(detailDao, Mockito.times(1)).deleteAllById(listIds);
    }


    public Detail getDetail(){ return new Detail();}
}
