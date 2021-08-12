package by.ita.je.controllers;

import by.ita.je.dto.ClientDto;
import by.ita.je.model.Client;
import by.ita.je.service.api.ServiceClient;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class ClientControllers {

    private final ObjectMapper objectMapper;
    private final ServiceClient clientService;

    @PostMapping("/client")
    public ClientDto create(@RequestBody ClientDto clientDto){
        final Client clientNew = objectMapper.convertValue(clientDto, Client.class);
        final Client client=clientService.create(clientNew);
        return objectMapper.convertValue(client,ClientDto.class);
    }

    @GetMapping("/client/{id}")
    public ClientDto findById(@PathVariable("id") String id){
        final Client client=clientService.findById(Long.valueOf(id));
        return objectMapper.convertValue(client, ClientDto.class);
    }

    @PutMapping(value = "/client")
    public ClientDto update(@RequestParam(value = "id", required = false) String id,
                            @RequestBody ClientDto clientDto){
        final Client clientNew=objectMapper.convertValue(clientDto, Client.class);
        Client client=clientService.update(Long.valueOf(id), clientNew);
        return objectMapper.convertValue(clientNew, ClientDto.class);
    }

    @GetMapping("/clients/list")
    public List<ClientDto> findListByIds(@RequestBody List<Long> listIds){
        List<Client> listClient=clientService.readByIDs(listIds);
        List<ClientDto> listClientDto=listClient.stream()
                .map(client -> objectMapper.convertValue(client, ClientDto.class))
                .collect(Collectors.toList());
        return listClientDto;
    }

    @GetMapping("/clients")
    public  List<ClientDto> findAll(){
        List <Client> listClient=clientService.readAll();
        List<ClientDto> listClientDto=listClient.stream()
                .map(client -> objectMapper.convertValue(client, ClientDto.class))
                .collect(Collectors.toList());
        return listClientDto;
    }

    @DeleteMapping("/clients")
    public void delleteList(@RequestBody List<Long> listIds){
        clientService.deleteList(listIds);
    }

    @DeleteMapping("/client/{id}")
    public void delleteById(@PathVariable("id") String id){
        clientService.deleteById(Long.valueOf(id));
    }

}
