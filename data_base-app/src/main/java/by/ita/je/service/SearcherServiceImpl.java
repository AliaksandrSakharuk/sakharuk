package by.ita.je.service;

import by.ita.je.dao.api.SearcherDao;
import by.ita.je.dto.FieldDto;
import by.ita.je.model.Car;
import by.ita.je.service.api.SearcherService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.time.ZonedDateTime;
@Service
@RequiredArgsConstructor
public class SearcherServiceImpl implements SearcherService {
    private final SearcherDao searcherDao;

    @Override
    public Car findCarToWorkerByTimePeriod(FieldDto fieldDto) {
        String nameCar=fieldDto.getNameCar();
        ZonedDateTime fromDataTimeStartWork = fieldDto.getFromDataTimeStartWork();
        ZonedDateTime toDataTimeStartWork = fieldDto.getToDataTimeStartWork();
        return searcherDao.findCarTWorkByPeriod(nameCar, fromDataTimeStartWork, toDataTimeStartWork);
    }
}
