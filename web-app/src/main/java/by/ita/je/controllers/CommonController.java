package by.ita.je.controllers;

import by.ita.je.dto.CarDto;
import by.ita.je.dto.FieldDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import java.time.ZonedDateTime;
import java.util.Arrays;
import java.util.List;

@RequiredArgsConstructor
@Controller
public class CommonController {

    private final RestTemplate restTemplate;
    private String urlBusiness="http://localhost:8003/data_base-app/business/";
    private String urlSearcher= "http://localhost:8003/data_base-app/";
    private String formTime="T00:00:00.000000+03:00";

    @GetMapping(value = "/")
    public String home() {
        return "sto";
    }

    @GetMapping(value = "/car")
    public String createCar(Model model) {
        model.addAttribute("card", new CarDto());
        return "formCar";
    }
    @PostMapping(value = "/car/save")
    public String resultCreateCar(@ModelAttribute CarDto carDto, Model model) {
        CarDto responce=restTemplate.postForObject(urlBusiness, carDto, CarDto.class);
        model.addAttribute("card", responce);
        return "car";
    }
    @GetMapping(value = "/car/list")
    public String getCardList(Model model){
        String fooResourceUrl= "http://localhost:8003/data_base-app/cars";
        ResponseEntity<CarDto[]> responseEntity = restTemplate.getForEntity(fooResourceUrl, CarDto[].class);
        List<CarDto> list = Arrays.asList(responseEntity.getBody());
        model.addAttribute("cards", list);
        return "listcar";
    }
    @GetMapping(value = "/car/result")
    public  String findById(@RequestParam(value = "id", required = false) String id, Model model){
        ResponseEntity responseEntity=restTemplate.getForEntity(urlBusiness+id, CarDto.class);
        model.addAttribute("card", responseEntity.getBody());
        return "car";
    }

    @GetMapping(value = "/car/delete")
    public  String deleteById(@RequestParam(value = "id", required = false) String id, Model model){
        model.addAttribute("id", id);
        restTemplate.delete(urlBusiness+id);
        return "delete_car";
    }

    @GetMapping(value = "/car/update_form")
    public String getFormUpdate(@RequestParam(value = "id", required = false) String id, Model model){
        CarDto carDto= restTemplate.getForObject(urlBusiness+id, CarDto.class);
        model.addAttribute("card",carDto );
        return "form_update";
    }

    @PostMapping(value = "/car/update")
    public String updateCar(@ModelAttribute CarDto carDto, Model model){
        model.addAttribute("card", carDto);
        restTemplate.put(urlBusiness+carDto.getId(), carDto, CarDto.class);
        return "car";
    }

    @GetMapping(value = "/searcher/hql")
    public String findByHQL(@RequestParam(value = "date_from", required = false) String dateFrom
                            ,@RequestParam(value = "date_to", required = false) String dateTo
                            ,@RequestParam(value = "name_car", required = false) String nameCar
            , Model model) {
        FieldDto fieldDto= new FieldDto(nameCar, ZonedDateTime.parse(dateFrom + formTime)
                                        , ZonedDateTime.parse(dateTo + formTime));
        ResponseEntity<CarDto[]> responseEntity = restTemplate.postForEntity(urlSearcher+"search_HQL", fieldDto, CarDto[].class);
        List<CarDto> list = Arrays.asList(responseEntity.getBody());
        model.addAttribute("cards", list);
        return "listcar";
    }

    @GetMapping(value = "/searcher/jpql")
    public String findByJPQL(@RequestParam(value = "date_from", required = false) String dateFrom
            ,@RequestParam(value = "date_to", required = false) String dateTo
            ,@RequestParam(value = "name_car", required = false) String nameCar
            , Model model) {
        FieldDto fieldDto= new FieldDto(nameCar, ZonedDateTime.parse(dateFrom + formTime)
                                        , ZonedDateTime.parse(dateTo + formTime));
        ResponseEntity<CarDto[]> responseEntity = restTemplate.postForEntity(urlSearcher+"search_JPQL", fieldDto, CarDto[].class);
        List<CarDto> list = Arrays.asList(responseEntity.getBody());
        model.addAttribute("cards", list);
        return "listcar";
    }

    @GetMapping(value = "/searcher/criteria")
    public String findByCriteria(@RequestParam(value = "date_from", required = false) String dateFrom
            ,@RequestParam(value = "date_to", required = false) String dateTo
            ,@RequestParam(value = "name_car", required = false) String nameCar
            , Model model) {
        FieldDto fieldDto= new FieldDto(nameCar, ZonedDateTime.parse(dateFrom + formTime)
                                 , ZonedDateTime.parse(dateTo + formTime));
        ResponseEntity<CarDto[]> responseEntity = restTemplate.postForEntity(urlSearcher+"search_criteria", fieldDto, CarDto[].class);
        List<CarDto> list = Arrays.asList(responseEntity.getBody());
        model.addAttribute("cards", list);
        return "listcar";
    }

    @GetMapping("/403")
    public String error403() {
        return "403";
    }

    @ModelAttribute("card")
    private CarDto createCarDto(){
        return new CarDto();
    }

}
