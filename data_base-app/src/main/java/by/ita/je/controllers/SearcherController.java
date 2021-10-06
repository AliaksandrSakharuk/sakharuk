package by.ita.je.controllers;

import by.ita.je.dto.CarDto;
import by.ita.je.dto.FieldDto;
import by.ita.je.model.Car;
import by.ita.je.service.api.SearcherService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class SearcherController {

    private final ObjectMapper objectMapper;
    private final SearcherService searcherService;

    @PostMapping("/search_JPQL")
    public List<CarDto> findCarByJPQL(@RequestBody FieldDto fieldDto){
        final List<Car> listCar= (List<Car>) searcherService.findCarToWorkerByJPQL(fieldDto);
        List<CarDto> listCarDto=listCar.stream()
                .map(car -> objectMapper.convertValue(car, CarDto.class))
                .collect(Collectors.toList());
        return listCarDto;
    }

    @PostMapping("/search_HQL")
    public List<CarDto> findCarByHQL(@RequestBody FieldDto fieldDto){
        final List<Car> listCar=searcherService.findCarToWorkerByJPQL(fieldDto);
        List<CarDto> listCarDto=listCar.stream()
                .map(car -> objectMapper.convertValue(car, CarDto.class))
                .collect(Collectors.toList());
        return listCarDto;
    }
    @PostMapping("/search_criteria")
    public List<CarDto> findCarByCriteria(@RequestBody FieldDto fieldDto){
        final List<Car> listCar=searcherService.findCarToWorkerByJPQL(fieldDto);
        List<CarDto> listCarDto=listCar.stream()
                .map(car -> objectMapper.convertValue(car, CarDto.class))
                .collect(Collectors.toList());
        return listCarDto;
    }

}
