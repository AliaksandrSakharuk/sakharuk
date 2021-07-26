package by.ita.je.controllers;


import by.ita.je.dto.CarDto;
import by.ita.je.dto.ClientDto;
import by.ita.je.model.Car;
import by.ita.je.model.Client;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.*;

@RestController
public class ClientControllers {
    ObjectMapper objectMapper=new ObjectMapper();

    @ResponseBody
    @PostMapping("/client")
    public Client create(@RequestBody ClientDto clientDto) {
        final Client client1 = objectMapper.convertValue(clientDto, Client.class);
        return client1;
    }
    @GetMapping("/client/{id}")
    public String findById(@PathVariable("id") String id)
    {        return "found " + id ;
    }

    @ResponseBody
    @PutMapping(value = "/client")
    public String update( @RequestParam(value = "id",required = false) String id,
                          @RequestParam(value = "firstName", required = false) String firstName){
        return "update " + id +" " + firstName;
    }

    @ResponseBody
    @DeleteMapping("/client/{id}")
    public String delleteById(@PathVariable("id") String id){ return "Delleted" +" " + id;}

    @ResponseBody
    @GetMapping("/clients/list")
    public String findByListIds(@RequestBody String list){
        return "Found all list by" + list;
    }

    @ResponseBody
    @GetMapping("/clients")
    public  String findAll(){
        return "I'm found everything";
    }

    @ResponseBody
    @DeleteMapping("/clients")
    public String delleteList(@RequestBody String list){
        return "Delleted list by " + list;
    }

}
