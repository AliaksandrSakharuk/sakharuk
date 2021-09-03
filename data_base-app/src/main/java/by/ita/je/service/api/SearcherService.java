package by.ita.je.service.api;

import by.ita.je.dto.FieldDto;
import by.ita.je.model.Car;

import java.util.List;

public interface SearcherService {
    List<Car> findCarToWorkerByTimePeriod(FieldDto fieldDto);
}
