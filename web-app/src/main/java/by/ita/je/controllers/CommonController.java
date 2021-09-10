package by.ita.je.controllers;

import by.ita.je.dto.CarDto;
import by.ita.je.dto.WorkerDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Controller
public class CommonController {

    @GetMapping(value = "/sto")
    public String home() {
        return "sto";
    }

    @GetMapping(value = "/car")
    public String createCar(Model model) {
        model.addAttribute("card", new CarDto());
        return "formCar";
    }
    @PostMapping(value = "/newcar")
    public String resultCreateCar(@ModelAttribute CarDto carDto, Model model) {
        RestTemplate restTemplate = new RestTemplate();
        String fooResourceUrl="http://localhost:8003/data_base-app/business";
        CarDto responce=restTemplate.postForObject(fooResourceUrl, carDto, CarDto.class);
        model.addAttribute("card", responce);
        return "newCar";
    }
    @GetMapping(value = "/car/list")
    public String getCardList(Model model){
        RestTemplate restTemplate = new RestTemplate();
        String fooResourceUrl= "http://localhost:8003/data_base-app/cars";
        ResponseEntity<CarDto[]> responseEntity = restTemplate.getForEntity(fooResourceUrl, CarDto[].class);
        List<CarDto> list = Arrays.asList(responseEntity.getBody());
        model.addAttribute("cards", list);
        return "listcar";
    }
    @GetMapping(value = "/result")
    public  String findById(@RequestParam(value = "id", required = false) String id, Model model){
        RestTemplate restTemplate = new RestTemplate();
        String fooResourceUrl= "http://localhost:8003/data_base-app/business/"+id;
        ResponseEntity responseEntity=restTemplate.getForEntity(fooResourceUrl, CarDto.class);
        model.addAttribute("card", responseEntity.getBody());
        return "found_car";
    }

}
