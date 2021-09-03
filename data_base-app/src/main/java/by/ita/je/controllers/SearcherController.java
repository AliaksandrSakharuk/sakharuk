package by.ita.je.controllers;

import by.ita.je.dto.CarDto;
import by.ita.je.dto.FieldDto;
import by.ita.je.model.Car;
import by.ita.je.service.api.SearcherService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class SearcherController {

    private final ObjectMapper objectMapper;
    private final SearcherService searcherService;

    @GetMapping("/search_JPQL")
    public List<CarDto> findByName(@RequestBody FieldDto fieldDto){
        final List<Car> listCar= (List<Car>) searcherService.findCarToWorkerByTimePeriod(fieldDto);
        List<CarDto> listCarDto=listCar.stream()
                .map(car -> objectMapper.convertValue(car, CarDto.class))
                .collect(Collectors.toList());

        return listCarDto;
    }
}
