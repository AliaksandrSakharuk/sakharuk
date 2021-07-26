package by.ita.je.controllers;

import by.ita.je.dto.DetailDto;
import by.ita.je.dto.WorkerDto;
import by.ita.je.model.Detail;
import by.ita.je.model.Worker;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.*;

@RestController
public class WorkerController {
    ObjectMapper objectMapper=new ObjectMapper();

    @ResponseBody
    @PostMapping("/worker")
    public Worker create(@RequestBody WorkerDto workerDto) {
        final Worker worker1 = objectMapper.convertValue(workerDto, Worker.class);
        return worker1;
    }
    @GetMapping("/worker/{id}")
    public String findById(@PathVariable("id") String id)
    {        return "found " + id ;
    }

    @ResponseBody
    @PutMapping(value = "/worker")
    public String update( @RequestParam(value = "id",required = false) String id,
                          @RequestParam(value = "firstName", required = false) String firstName){
        return "update " + id +" " + firstName;
    }

    @ResponseBody
    @DeleteMapping("/worker/{id}")
    public String delleteById(@PathVariable("id") String id){ return "Delleted" +" " + id;}

    @ResponseBody
    @GetMapping("/workers/list")
    public String findByListIds(@RequestBody String list){
        return "Found all list by" + list;
    }

    @ResponseBody
    @GetMapping("/workers")
    public  String findAll(){
        return "I'm found everything";
    }

    @ResponseBody
    @DeleteMapping("/workers")
    public String delleteList(@RequestBody String list){
        return "Delleted list by " + list;
    }
}
