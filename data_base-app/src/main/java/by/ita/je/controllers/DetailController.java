package by.ita.je.controllers;

import by.ita.je.dto.DetailDto;
import by.ita.je.model.Detail;
import by.ita.je.service.api.ServiceDetail;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@RestController
public class DetailController {

    private final ObjectMapper objectMapper;
    private final ServiceDetail detailService;

    @PostMapping("/detail")
    public DetailDto create(@RequestBody DetailDto detailDto){
        final Detail detailNew = objectMapper.convertValue(detailDto, Detail.class);
        final Detail detail=detailService.create(detailNew);
        return objectMapper.convertValue(detail, DetailDto.class);
    }

    @GetMapping("/detail/{id}")
    public DetailDto findById(@PathVariable("id") String id){
        final Detail detail=detailService.findById(Long.valueOf(id));
        return objectMapper.convertValue(detail, DetailDto.class);
    }

    @PutMapping(value = "/detail")
    public DetailDto update( @RequestParam(value = "id", required = false) String id,
                             @RequestBody DetailDto detailDto){
        final Detail detailNew=objectMapper.convertValue(detailDto, Detail.class);
        Detail detail=detailService.update(Long.valueOf(id), detailNew);
        return objectMapper.convertValue(detail, DetailDto.class);
    }

    @GetMapping("/details/list")
    public List<DetailDto> findListByIds(@RequestBody List<Long> listIds){
        List<Detail> listDetail=detailService.readByIDs(listIds);
        List<DetailDto> listDetailDto=listDetail.stream()
                .map(detail -> objectMapper.convertValue(detail, DetailDto.class))
                .collect(Collectors.toList());
        return listDetailDto;
    }

    @GetMapping("/details")
    public List<DetailDto> findAll(){
        List <Detail> listDetail=detailService.readAll();
        List<DetailDto> listDetailDto=listDetail.stream()
                .map(detail -> objectMapper.convertValue(detail, DetailDto.class))
                .collect(Collectors.toList());
        return listDetailDto;
    }

    @DeleteMapping("/details")
    public void delleteList(@RequestBody List<Long> listIds){
        detailService.deleteList(listIds);
    }

    @DeleteMapping("/detail/{id}")
    public void delleteById(@PathVariable("id") String id){
        detailService.deleteById(Long.valueOf(id));
    }

}
