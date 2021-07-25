package by.ita.je.controllers;
import by.ita.je.dto.CarDto;
import by.ita.je.model.Car;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
public class CarControllers {

    private final static ObjectMapper objectMapper = new ObjectMapper();

    @ResponseBody
    @PostMapping("/car")
    public Car create(@RequestBody CarDto carDto) {
        final Car car1 = objectMapper.convertValue(carDto, Car.class);
       return car1;
            }
    @GetMapping("/car/{id}")
    public String findById(@PathVariable("id") String id)
    {        return "found " + id ;
    }

    @ResponseBody
    @PutMapping(value = "/car")
    public String update( @RequestParam(value = "id",required = false) String id,
                          @RequestParam(value = "name", required = false) String nameCar){
        return "update " + id +" " + nameCar;
    }

    @ResponseBody
    @DeleteMapping("/car/{id}")
    public String delleteById(@PathVariable("id") String id){ return "Delleted" +" " + id;}

    @ResponseBody
    @GetMapping("/cars/list")
    public String findByListIds(@RequestBody String list){
        return "Found all list by" + list;
    }

    @ResponseBody
    @GetMapping("/cars")
    public  String findAll(){
        return "I'm found everything";
    }

    @ResponseBody
    @DeleteMapping("/cars")
    public String delleteList(@RequestBody String id){
        return "Delleted list by " + id;
    }


}

        


