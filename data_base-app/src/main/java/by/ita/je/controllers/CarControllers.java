package by.ita.je.controllers;

import by.ita.je.dto.CarDto;
import by.ita.je.model.Car;
import by.ita.je.service.api.ServiceCar;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class CarControllers {

    private final ObjectMapper objectMapper;
    private final ServiceCar carService;

    @PostMapping("/car")
    public CarDto create(@RequestBody CarDto carDto){
        final Car carNew = objectMapper.convertValue(carDto, Car.class);
        final Car car=carService.create(carNew);
        return objectMapper.convertValue(car,CarDto.class);
    }

    @GetMapping("/car/{id}")
    public CarDto findById(@PathVariable("id") String id){
        final Car car=carService.findById(Long.valueOf(id));
        return objectMapper.convertValue(car, CarDto.class);
    }

    @PutMapping(value = "/car")
    public CarDto update( @RequestParam(value = "id", required = false) String id,
                          @RequestBody CarDto carDto){
        final Car carNew=objectMapper.convertValue(carDto, Car.class);
        Car car=carService.update(Long.valueOf(id), carNew);
        return objectMapper.convertValue(carNew, CarDto.class);
    }

    @GetMapping("/cars/list")
    public List<CarDto> findListByIds(@RequestBody List<Long> listIds){
        List<Car> listCar=carService.readByIDs(listIds);
        List<CarDto> listCarDto=listCar.stream()
                .map(car -> objectMapper.convertValue(car, CarDto.class))
                .collect(Collectors.toList());
        return listCarDto;
    }

    @GetMapping("/cars")
    public  List<CarDto> findAll(){
        List <Car> listCar=carService.readAll();
        List<CarDto> listCarDto=listCar.stream()
                .map(car -> objectMapper.convertValue(car, CarDto.class))
                .collect(Collectors.toList());
        return listCarDto;
    }

    @DeleteMapping("/cars")
    public void delleteList(@RequestBody List<Long> listIds){
        carService.deleteList(listIds);
    }

    @DeleteMapping("/car/{id}")
    public void delleteById(@PathVariable("id") String id){
        carService.deleteById(Long.valueOf(id));
    }

}