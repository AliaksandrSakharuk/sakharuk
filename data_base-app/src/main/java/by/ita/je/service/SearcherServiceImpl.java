package by.ita.je.service;

import by.ita.je.dao.api.SearcherHQLDao;
import by.ita.je.dao.api.SearcherJPQLDao;
import by.ita.je.dto.FieldDto;
import by.ita.je.model.Car;
import by.ita.je.service.api.SearcherService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.time.ZonedDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SearcherServiceImpl implements SearcherService {
    private final SearcherJPQLDao searcherJPQLDao;
    private final SearcherHQLDao searcherHQLDao;

    @Override
    public List<Car> findCarToWorkerByJPQL(FieldDto fieldDto) {
        String nameCar=fieldDto.getNameCar();
        ZonedDateTime fromDataTimeStartWork = fieldDto.getFromDataTimeStartWork();
        ZonedDateTime toDataTimeStartWork = fieldDto.getToDataTimeStartWork();
        return searcherJPQLDao.findCarTWorkByPeriod(nameCar, fromDataTimeStartWork, toDataTimeStartWork);
    }

    @Override
    public List<Car> findCarToWorkerByHQL(FieldDto fieldDto) {
        String nameCar=fieldDto.getNameCar();
        ZonedDateTime fromDataTimeStartWork = fieldDto.getFromDataTimeStartWork();
        ZonedDateTime toDataTimeStartWork = fieldDto.getToDataTimeStartWork();
        return searcherHQLDao.findCarByWorkerHQL(nameCar, fromDataTimeStartWork, toDataTimeStartWork);
    }
}
