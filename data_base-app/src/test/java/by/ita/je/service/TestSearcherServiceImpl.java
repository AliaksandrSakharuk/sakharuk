package by.ita.je.service;

import by.ita.je.dao.api.SearcherCriteriaDao;
import by.ita.je.dao.api.SearcherHQLDao;
import by.ita.je.dao.api.SearcherJPQLDao;
import by.ita.je.dto.FieldDto;
import by.ita.je.model.Car;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@ExtendWith(MockitoExtension.class)
public class TestSearcherServiceImpl {
    @Mock
    private SearcherJPQLDao jpqlDao;

    @Mock
    private SearcherHQLDao hqlDao;

    @Mock
    private SearcherCriteriaDao criteriaDao;

    @InjectMocks
    private SearcherServiceImpl service;

    String nameCar="ZAZ";
    ZonedDateTime from=ZonedDateTime.now().minusYears(2);
    ZonedDateTime to=ZonedDateTime.now();


    @Test
    public void when_getCarByJPQL(){
        final List<Car> givenCarList= Stream
                .generate(()->new Car())
                .limit(3)
                .collect(Collectors.toList());
        Mockito.when(service.findCarToWorkerByJPQL(getFieldDto())).thenReturn(givenCarList);
        List<Car> actual=service.findCarToWorkerByJPQL(getFieldDto());
        final List<Car> expected= Stream
                .generate(()->new Car())
                .limit(3)
                .collect(Collectors.toList());
        Assertions.assertEquals(expected ,actual);
        Mockito.verify(jpqlDao, Mockito.times(1)).findCarTWorkByPeriod(nameCar, from, to);
    }

    @Test
    public void when_getCarByHQL(){
        final List<Car> givenCarList= Stream
                .generate(()->new Car())
                .limit(3)
                .collect(Collectors.toList());
        Mockito.when(service.findCarToWorkerByHQL(getFieldDto())).thenReturn(givenCarList);
        List<Car> actual=service.findCarToWorkerByHQL(getFieldDto());
        final List<Car> expected= Stream
                .generate(()->new Car())
                .limit(3)
                .collect(Collectors.toList());
        Assertions.assertEquals(expected ,actual);
        Mockito.verify(hqlDao, Mockito.times(1)).findCarByWorkerHQL(nameCar, from, to);
    }

    @Test
    public void when_getCarByCriteria(){
        final List<Car> givenCarList= Stream
                .generate(()->new Car())
                .limit(3)
                .collect(Collectors.toList());
        Mockito.when(service.findCarToWorkerByCriteria(getFieldDto())).thenReturn(givenCarList);
        List<Car> actual=service.findCarToWorkerByCriteria(getFieldDto());
        final List<Car> expected= Stream
                .generate(()->new Car())
                .limit(3)
                .collect(Collectors.toList());
        Assertions.assertEquals(expected ,actual);
        Mockito.verify(criteriaDao, Mockito.times(1)).findCarByWorkerCriteria(nameCar, from, to);
    }


    private FieldDto getFieldDto(){
        return new FieldDto(nameCar,from,to);
    }

}
