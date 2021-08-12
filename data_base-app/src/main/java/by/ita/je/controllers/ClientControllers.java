package by.ita.je.controllers;

import by.ita.je.dto.ClientDto;
import by.ita.je.model.Client;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
public class ClientControllers {
    private final static ObjectMapper objectMapper=new ObjectMapper();

    @PostMapping("/client")
    public ClientDto create(@RequestBody ClientDto clientDto) {
        final Client clientNew = objectMapper.convertValue(clientDto, Client.class);
        return clientDto;
    }

    @GetMapping("/client/{id}")
    public ClientDto findById(@PathVariable("id") String id) {
        ClientDto clientDto=new ClientDto();
        return clientDto ;
    }

    @PutMapping(value = "/client")
    public ClientDto update(@RequestParam(value = "id", required = false) String id,
                            @RequestBody ClientDto clientDto){
        return clientDto;
    }

    @GetMapping("/clients/list")
    public List<ClientDto> findListByIds(@RequestBody List<Long> listIds){
        List<ClientDto> listClientDto=new ArrayList<ClientDto>();
        return listClientDto;
    }

    @GetMapping("/clients")
    public  List<ClientDto> findAll(){
        List<ClientDto> listClientDto=new ArrayList<ClientDto>();
        return listClientDto;
    }

    @ResponseBody
    @DeleteMapping("/clients")
    public void delleteList(@RequestBody List<Long> listIds){

    }

    @DeleteMapping("/client/{id}")
    public void delleteById(@PathVariable("id") String id){

    }

}
