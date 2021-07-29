package by.ita.je.controllers;
import by.ita.je.dto.CarDto;
import by.ita.je.model.Car;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.web.bind.annotation.*;

import java.util.*;


@RestController
public class CarControllers {

    private final static ObjectMapper objectMapper = new ObjectMapper();

    @ResponseBody
    @PostMapping("/car")
    public CarDto create(@RequestBody CarDto carDto) {
        final Car car1 = objectMapper.convertValue(carDto, Car.class);

       return carDto;
            }

    @GetMapping("/car/{name}")
    public CarDto findByName(@PathVariable("name") String name)

    {   CarDto carDto=new CarDto();
    carDto.setNameCar(name);
        return carDto;
    }

    @ResponseBody
    @PutMapping(value = "/car")
    public CarDto update( @RequestParam(value = "name", required = false) String nameCar){
        CarDto carDto=new CarDto();
        carDto.setNameCar(nameCar);

        return carDto;
    }

    @ResponseBody
    @DeleteMapping("/car/{id}")
    public void delleteById(@PathVariable("id") String id){

    }

    @ResponseBody
    @GetMapping("/cars/list")
    public List<CarDto> findListByNames(@RequestBody List<String> listName){
        Iterator<String> iterator=listName.iterator();
        List<CarDto> listCarDto=new ArrayList<CarDto>();
        String name;
        while(iterator.hasNext()){
            name=iterator.next();
            CarDto carDto=new CarDto();
            carDto.setNameCar(name);
            listCarDto.add(carDto);
            }

        return listCarDto;
    }

    @ResponseBody
    @GetMapping("/cars")
    public  List<CarDto> findAll(){
        List<CarDto> listCarDto=new ArrayList<CarDto>();

        return listCarDto;
    }

    @ResponseBody
    @DeleteMapping("/cars")
    public void delleteList(@RequestBody List<CarDto> listCarDto){


    }


}

        


