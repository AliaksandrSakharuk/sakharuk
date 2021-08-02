package by.ita.je.controllers;

import by.ita.je.dto.CarDto;
import by.ita.je.dto.ClientDto;
import by.ita.je.dto.DetailDto;
import by.ita.je.model.Client;
import by.ita.je.model.Detail;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

@RestController
public class DetailController {
    private final static ObjectMapper objectMapper=new ObjectMapper();

    @ResponseBody
    @PostMapping("/detail")
    public DetailDto create(@RequestBody DetailDto detailDto) {
        final Detail detail1 = objectMapper.convertValue(detailDto, Detail.class);
        return detailDto;
    }

    @GetMapping("/detail/{id}")
    public DetailDto findById(@PathVariable("id") String id)
    {   DetailDto detailDto=new DetailDto();
        return detailDto;
    }

    @ResponseBody
    @PutMapping(value = "/detail")
    public DetailDto update( @RequestParam(value = "name", required = false) String name,
                             @RequestBody DetailDto detailDto){
        return detailDto;
    }

    @ResponseBody
    @DeleteMapping("/detail/{id}")
    public void delleteById(@PathVariable("id") String id){ }

    @ResponseBody
    @GetMapping("/details/list")
    public List<DetailDto> findListByIds(@RequestBody List<String> listIds){
        List<DetailDto> listDetailDto=new ArrayList<DetailDto>();

        return listDetailDto;
    }

    @ResponseBody
    @GetMapping("/details")
    public List<DetailDto> findAll(){
        List<DetailDto> listDetailDto=new ArrayList<DetailDto>();

        return listDetailDto;

    }

    @ResponseBody
    @DeleteMapping("/details")
    public void delleteList(@RequestBody List<DetailDto> listDetailDto){

    }
}
