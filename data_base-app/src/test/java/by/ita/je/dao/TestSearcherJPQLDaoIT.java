package by.ita.je.dao;

import by.ita.je.dao.api.SearcherJPQLDao;
import by.ita.je.model.Car;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import java.time.ZonedDateTime;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestSearcherJPQLDaoIT {
    @Autowired
    private SearcherJPQLDao searcherJPQLDao;

    String nameCar="ZAZ";
    ZonedDateTime from=ZonedDateTime.parse("2015-05-12T00:00:00.000000+03:00");
    ZonedDateTime to=ZonedDateTime.parse("2015-10-01T00:00:00.000000+03:00");

    @Test
    public void givenSearcherJPQLDao_findCar_thenOk(){
        List<Car> listCar=searcherJPQLDao.findCarTWorkByPeriod(nameCar, from, to);
        Assertions.assertNotNull(listCar);
        Assertions.assertEquals(1,listCar.size());
    }
}
