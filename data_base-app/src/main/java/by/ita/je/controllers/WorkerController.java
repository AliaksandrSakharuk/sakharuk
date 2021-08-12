package by.ita.je.controllers;

import by.ita.je.dto.WorkerDto;
import by.ita.je.model.Worker;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
public class WorkerController {
    private final static ObjectMapper objectMapper=new ObjectMapper();

    @PostMapping("/worker")
    public WorkerDto create(@RequestBody WorkerDto workerDto) {
        final Worker workerNew = objectMapper.convertValue(workerDto, Worker.class);
        return workerDto;
    }
    @GetMapping("/worker/{id}")
    public WorkerDto findById(@PathVariable("id") String id){
        WorkerDto workerDto=new WorkerDto();
        return workerDto;
    }

    @PutMapping(value = "/worker")
    public WorkerDto update( @RequestParam(value = "id",required = false) String id,
                             @RequestBody WorkerDto workerDto){
        return workerDto;
    }

    @GetMapping("/workers/list")
    public List<WorkerDto> findListByIds(@RequestBody List <Long> listIds){
        List<WorkerDto> listWorkerDto=new ArrayList<WorkerDto>();
        return listWorkerDto;

    }

    @GetMapping("/workers")
    public  List<WorkerDto> findAll(){
        List<WorkerDto> listWorkerDto=new ArrayList<WorkerDto>();
        return listWorkerDto;

    }

    @DeleteMapping("/worker/{id}")
    public void delleteById(@PathVariable("id") String id){

    }

    @DeleteMapping("/workers")
    public void delleteList(@RequestBody List<Long> listIds){

    }
}
