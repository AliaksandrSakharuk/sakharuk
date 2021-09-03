package by.ita.je.controllers;

import by.ita.je.dto.PositionDto;

import by.ita.je.model.Position;
import by.ita.je.service.api.ServicePosition;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class PositionController {
    private final ObjectMapper objectMapper;
    private final ServicePosition positionService;

    @PostMapping("/position")
    public PositionDto create(@RequestBody PositionDto positionDto){
        final Position positionNew = objectMapper.convertValue(positionDto, Position.class);
        final Position position=positionService.create(positionNew);
        return objectMapper.convertValue(position, PositionDto.class);
    }
    @GetMapping("/position/{position}")
    public List<PositionDto> findByName(@PathVariable("position") String name){
        List<Position> listPosition= positionService.findPosition(name);
        List<PositionDto> listPositionDto=listPosition.stream()
                .map(position -> objectMapper.convertValue(position, PositionDto.class))
                .collect(Collectors.toList());
        return listPositionDto;
    }

    @GetMapping("/position_id/{id}")
    public PositionDto findById(@PathVariable("id") String id){
        final Position position= positionService.findPositionById(Long.parseLong(id));
        return objectMapper.convertValue(position, PositionDto.class);
    }

    @PutMapping(value = "/position/{id}")
    public PositionDto update(@PathVariable("id") String id,
                         @RequestBody PositionDto positionDto){
        final Position positionNew=objectMapper.convertValue(positionDto, Position.class);
        Position position=positionService.update(Long.valueOf(id), positionNew);
        return objectMapper.convertValue(positionNew, PositionDto.class);
    }

    @DeleteMapping("/position/{id}")
    public void delleteById(@PathVariable("id") String id){
        positionService.delete(Long.valueOf(id));
    }

    @GetMapping("/positions")
    public  List<PositionDto> findAll() {
        List<Position> listPosition = positionService.findAll();
        List<PositionDto> listPositionDto = listPosition.stream()
                .map(position -> objectMapper.convertValue(position, PositionDto.class))
                .collect(Collectors.toList());
        return listPositionDto;
    }
}
