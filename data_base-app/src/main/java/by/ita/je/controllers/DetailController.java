package by.ita.je.controllers;

import by.ita.je.dto.DetailDto;
import by.ita.je.model.Detail;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
public class DetailController {
    private final static ObjectMapper objectMapper=new ObjectMapper();

    @PostMapping("/detail")
    public DetailDto create(@RequestBody DetailDto detailDto) {
        final Detail detailNew = objectMapper.convertValue(detailDto, Detail.class);
        return detailDto;
    }

    @GetMapping("/detail/{id}")
    public DetailDto findById(@PathVariable("id") String id) {
        DetailDto detailDto=new DetailDto();
        return detailDto;
    }

    @PutMapping(value = "/detail")
    public DetailDto update( @RequestParam(value = "id", required = false) String id,
                             @RequestBody DetailDto detailDto){
        return detailDto;
    }

    @GetMapping("/details/list")
    public List<DetailDto> findListByIds(@RequestBody List<Long> listIds){
        List<DetailDto> listDetailDto=new ArrayList<DetailDto>();
        return listDetailDto;
    }

    @GetMapping("/details")
    public List<DetailDto> findAll(){
        List<DetailDto> listDetailDto=new ArrayList<DetailDto>();
        return listDetailDto;
    }

    @DeleteMapping("/details")
    public void delleteList(@RequestBody List<Long> listIds){

    }

    @DeleteMapping("/detail/{id}")
    public void delleteById(@PathVariable("id") String id){

    }
}
