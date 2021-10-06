package by.ita.je.controllers;

import by.ita.je.dto.WorkerDto;
import by.ita.je.model.Worker;
import by.ita.je.service.api.ServiceWorker;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@RestController
public class WorkerController {

    private final ObjectMapper objectMapper;
    private final ServiceWorker workerService;

    @PostMapping("/worker")
    public WorkerDto create(@RequestBody WorkerDto workerDto) {
        final Worker workerNew = objectMapper.convertValue(workerDto, Worker.class);
        final Worker worker=workerService.create(workerNew);
        return objectMapper.convertValue(worker, WorkerDto.class);
    }

    @GetMapping("/worker/{id}")
    public WorkerDto findById(@PathVariable("id") String id){
        final Worker worker=workerService.findById(Long.valueOf(id));
        return objectMapper.convertValue(worker, WorkerDto.class);
    }

    @PutMapping(value = "/worker")
    public WorkerDto update( @RequestParam(value = "id",required = false) String id,
                             @RequestBody WorkerDto workerDto){
        final Worker workerNew=objectMapper.convertValue(workerDto, Worker.class);
        Worker worker=workerService.update(Long.valueOf(id), workerNew);
        return objectMapper.convertValue(worker, WorkerDto.class);
    }

    @GetMapping("/workers/list")
    public List<WorkerDto> findListByIds(@RequestBody List <Long> listIds){
        List<Worker> listWorker=workerService.readByIDs(listIds);
        List<WorkerDto> listWorkerDto=listWorker.stream()
                .map(worker -> objectMapper.convertValue(worker, WorkerDto.class))
                .collect(Collectors.toList());
        return listWorkerDto;
    }

    @GetMapping("/workers")
    public  List<WorkerDto> findAll(){
        List <Worker> listWorker=workerService.readAll();
        List<WorkerDto> listWorkerDto=listWorker.stream()
                .map(worker -> objectMapper.convertValue(worker, WorkerDto.class))
                .collect(Collectors.toList());
        return listWorkerDto;
    }

    @DeleteMapping("/worker/{id}")
    public void delleteById(@PathVariable("id") String id){ workerService.deleteById(Long.valueOf(id));}

    @DeleteMapping("/workers")
    public void delleteList(@RequestBody List<Long> listIds){  workerService.deleteList(listIds) ; }
}
