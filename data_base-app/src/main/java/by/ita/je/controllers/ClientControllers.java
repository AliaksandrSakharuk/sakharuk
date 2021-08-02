package by.ita.je.controllers;


import by.ita.je.dto.CarDto;
import by.ita.je.dto.ClientDto;
import by.ita.je.model.Car;
import by.ita.je.model.Client;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

@RestController
public class ClientControllers {
    private final static ObjectMapper objectMapper=new ObjectMapper();

    @ResponseBody
    @PostMapping("/client")
    public ClientDto create(@RequestBody ClientDto clientDto) {
        final Client client1 = objectMapper.convertValue(clientDto, Client.class);
        return clientDto;
    }
    @GetMapping("/client/{id}")
    public ClientDto findById(@PathVariable("id") String id)
    {  ClientDto clientDto=new ClientDto();
        return clientDto ;
    }

    @ResponseBody
    @PutMapping(value = "/client")
    public ClientDto update(@RequestParam(value = "firstName", required = false) String firstName,
                            @RequestBody ClientDto clientDto){

        return clientDto;
    }

    @ResponseBody
    @DeleteMapping("/client/{id}")
    public void delleteById(@PathVariable("id") String id){ }

    @ResponseBody
    @GetMapping("/clients/list")
    public List<ClientDto> findListByIds(@RequestBody List<String> listIds){
        List<ClientDto> listClientDto=new ArrayList<ClientDto>();

        return listClientDto;
    }

    @ResponseBody
    @GetMapping("/clients")
    public  List<ClientDto> findAll(){
        List<ClientDto> listClientDto=new ArrayList<ClientDto>();

        return listClientDto;
    }

    @ResponseBody
    @DeleteMapping("/clients")
    public void delleteList(@RequestBody List<ClientDto> listClientDto){

    }

}
