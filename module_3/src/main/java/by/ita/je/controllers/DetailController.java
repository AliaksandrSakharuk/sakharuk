package by.ita.je.controllers;

import by.ita.je.dto.ClientDto;
import by.ita.je.dto.DetailDto;
import by.ita.je.model.Client;
import by.ita.je.model.Detail;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.*;

@RestController
public class DetailController {
    ObjectMapper objectMapper=new ObjectMapper();

    @ResponseBody
    @PostMapping("/detail")
    public Detail create(@RequestBody DetailDto detailDto) {
        final Detail detail1 = objectMapper.convertValue(detailDto, Detail.class);
        return detail1;
    }
    @GetMapping("/detail/{id}")
    public String findById(@PathVariable("id") String id)
    {        return "found " + id ;
    }

    @ResponseBody
    @PutMapping(value = "/detail")
    public String update( @RequestParam(value = "id",required = false) String id,
                          @RequestParam(value = "name", required = false) String name){
        return "update " + id +" " + name;
    }

    @ResponseBody
    @DeleteMapping("/detail/{id}")
    public String delleteById(@PathVariable("id") String id){ return "Delleted" +" " + id;}

    @ResponseBody
    @GetMapping("/details/list")
    public String findByListIds(@RequestBody String list){
        return "Found all list by" + list;
    }

    @ResponseBody
    @GetMapping("/details")
    public  String findAll(){
        return "I'm found everything";
    }

    @ResponseBody
    @DeleteMapping("/details")
    public String delleteList(@RequestBody String list){
        return "Delleted list by " + list;
    }
}
