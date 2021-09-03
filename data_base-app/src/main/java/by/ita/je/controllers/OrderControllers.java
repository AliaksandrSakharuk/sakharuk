package by.ita.je.controllers;

import by.ita.je.dto.OrderDto;
import by.ita.je.model.Order;
import by.ita.je.service.api.ServiceOrder;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class OrderControllers {

    private final ObjectMapper objectMapper;
    private final ServiceOrder clientService;

    @PostMapping("/order")
    public OrderDto create(@RequestBody OrderDto orderDto){
        final Order orderNew = objectMapper.convertValue(orderDto, Order.class);
        final Order order =clientService.create(orderNew);
        return objectMapper.convertValue(order, OrderDto.class);
    }

    @GetMapping("/order/{id}")
    public OrderDto findById(@PathVariable("id") String id){
        final Order order =clientService.findById(Long.valueOf(id));
        return objectMapper.convertValue(order, OrderDto.class);
    }

    @PutMapping(value = "/order")
    public OrderDto update(@RequestParam(value = "id", required = false) String id,
                           @RequestBody OrderDto orderDto){
        final Order orderNew =objectMapper.convertValue(orderDto, Order.class);
        Order order =clientService.update(Long.valueOf(id), orderNew);
        return objectMapper.convertValue(orderNew, OrderDto.class);
    }

    @GetMapping("/orders/list")
    public List<OrderDto> findListByIds(@RequestBody List<Long> listIds){
        List<Order> listOrder =clientService.readByIDs(listIds);
        List<OrderDto> listOrderDto = listOrder.stream()
                .map(client -> objectMapper.convertValue(client, OrderDto.class))
                .collect(Collectors.toList());
        return listOrderDto;
    }

    @GetMapping("/orders")
    public  List<OrderDto> findAll(){
        List <Order> listOrder =clientService.readAll();
        List<OrderDto> listOrderDto = listOrder.stream()
                .map(client -> objectMapper.convertValue(client, OrderDto.class))
                .collect(Collectors.toList());
        return listOrderDto;
    }

    @DeleteMapping("/orders")
    public void delleteList(@RequestBody List<Long> listIds){
        clientService.deleteList(listIds);
    }

    @DeleteMapping("/order/{id}")
    public void delleteById(@PathVariable("id") String id){
        clientService.deleteById(Long.valueOf(id));
    }

}
