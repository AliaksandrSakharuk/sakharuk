package by.ita.je.controllers;

import by.ita.je.dto.CarDto;
import by.ita.je.model.Car;
import by.ita.je.service.api.ServiceBusiness;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
public class BusinessController {

    private final ObjectMapper objectMapper;
    private final ServiceBusiness businessService;

    @PostMapping("/business")
    public CarDto create(@RequestBody CarDto carDto){
        final Car carNew = objectMapper.convertValue(carDto, Car.class);
        final Car car=businessService.create(carNew);
        return objectMapper.convertValue(car,CarDto.class);
    }

    @PutMapping("/business/{car_id}")
    public CarDto updateCar(@PathVariable("car_id") String id, @RequestBody CarDto carDto){
        final Car carNew=objectMapper.convertValue(carDto, Car.class);
        final Car car=businessService.update(Long.valueOf(id),carNew);
        return objectMapper.convertValue(car, CarDto.class);
    }

    @DeleteMapping("/business/{id}")
    public void delleteById(@PathVariable("id") String id){
        businessService.delete(Long.valueOf(id));
    }

    @GetMapping("/business/{id}")
    public CarDto findCar(@PathVariable("id") String id){
        final Car car=businessService.read(Long.valueOf(id));
        return objectMapper.convertValue(car, CarDto.class);
    }
}
