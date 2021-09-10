package by.ita.je.controllers;

import by.ita.je.dto.CarDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

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
        model.addAttribute("card", carDto);
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

}
