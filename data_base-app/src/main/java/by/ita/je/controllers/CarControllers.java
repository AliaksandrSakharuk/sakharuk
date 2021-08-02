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

    @GetMapping("/car/{id}")
    public CarDto findById(@PathVariable("id") String id)
    {   CarDto carDto=new CarDto();

        return carDto;
    }

    @ResponseBody
    @PutMapping(value = "/car")
    public CarDto update( @RequestParam(value = "id", required = false) String id,
                          @RequestBody CarDto carDto){


        return carDto;
    }

    @ResponseBody
    @DeleteMapping("/car/{id}")
    public void delleteById(@PathVariable("id") String id){

    }

    @ResponseBody
    @GetMapping("/cars/list")
    public List<CarDto> findListByIds(@RequestBody List<Long> listIDs){
        List<CarDto> listCarDto=new ArrayList<CarDto>();
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
    public void delleteList(@RequestBody List<Long> listIds){


    }


}

        


