package by.ita.je.service;

import by.ita.je.dao.api.SearcherByHQLDao;
import by.ita.je.dao.api.SearcherDao;
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
    private final SearcherDao searcherDao;
    private final SearcherByHQLDao searcherByHQLDao;

    @Override
    public List<Car> findCarToWorkerByJPQL(FieldDto fieldDto) {
        String nameCar=fieldDto.getNameCar();
        ZonedDateTime fromDataTimeStartWork = fieldDto.getFromDataTimeStartWork();
        ZonedDateTime toDataTimeStartWork = fieldDto.getToDataTimeStartWork();
        return searcherDao.findCarTWorkByPeriod(nameCar, fromDataTimeStartWork, toDataTimeStartWork);
    }

    @Override
    public List<Car> findCarToWorkerByHQL(FieldDto fieldDto) {
        String nameCar=fieldDto.getNameCar();
        ZonedDateTime fromDataTimeStartWork = fieldDto.getFromDataTimeStartWork();
        ZonedDateTime toDataTimeStartWork = fieldDto.getToDataTimeStartWork();
        return searcherByHQLDao.findCarByWorkerHQL(nameCar, fromDataTimeStartWork, toDataTimeStartWork);
    }
}
