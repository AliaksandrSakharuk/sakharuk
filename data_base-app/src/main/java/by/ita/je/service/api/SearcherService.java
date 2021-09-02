package by.ita.je.service.api;

import by.ita.je.dto.FieldDto;
import by.ita.je.model.Car;

public interface SearcherService {
    Car findCarToWorkerByTimePeriod(FieldDto fieldDto);
}
