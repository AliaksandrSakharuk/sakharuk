package by.ita.je.controllers;

import by.ita.je.dao.api.BusinessDao;
import by.ita.je.dto.CarDto;
import by.ita.je.model.Car;
import by.ita.je.model.Detail;
import by.ita.je.service.api.ServiceBusiness;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class BusinessController {

    private final ObjectMapper objectMapper;
    private final ServiceBusiness businessService;

    @PutMapping("/details_for_car/{car_id}")
    public CarDto addDetailToCar(@RequestBody List<Detail> listIds, @PathVariable("car_id") String id){
    final Car car=businessService.addDetailToCar(Long.valueOf(id), listIds);
    return objectMapper.convertValue(car, CarDto.class);
    }

    @PutMapping("/car_inject_order/{car_id}")
    public CarDto addCarToOrder(@PathVariable("car_id") String id){
        final Car car=businessService.addCarToOrder(Long.valueOf(id));
        return objectMapper.convertValue(car, CarDto.class);
    }

    @PutMapping("/updated_car/{car_id}")
    public CarDto updateCar(@PathVariable("car_id") String id, @RequestBody CarDto carDto){
        final Car carNew=objectMapper.convertValue(carDto, Car.class);

        final Car car=businessService.update(Long.valueOf(id),carNew);

        return objectMapper.convertValue(car, CarDto.class);
    }

    @DeleteMapping("/delete_car/{id}")
    public void delleteById(@PathVariable("id") String id){

        businessService.delete(Long.valueOf(id));
    }
}
