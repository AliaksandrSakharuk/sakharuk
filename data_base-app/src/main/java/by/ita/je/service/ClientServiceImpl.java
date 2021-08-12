package by.ita.je.service;

import by.ita.je.dao.ClientDao;
import by.ita.je.exception.NotCorrectData;
import by.ita.je.exception.NotFoundData;
import by.ita.je.model.Client;
import by.ita.je.service.api.ServiceClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Spliterator;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Component
@RequiredArgsConstructor
public class ClientServiceImpl implements ServiceClient {

    private final ClientDao clientDao;

    @Override
    public Client create(Client client) throws NotCorrectData {
        if(client.getFirstName()==null) throw new NotCorrectData("Not correct data FIRST_NAME_CLIENT");
        client.setCash(false);
        client.setLastName("Неизвестно");
        client.setDataTimeRequest(ZonedDateTime.now());
        return clientDao.save(client);
    }

    @Override
    public Client findById(Long id) throws NotFoundData{
        final Client client= clientDao.findById(id)
                .orElseThrow(() -> new NotFoundData(id + " not found"));
        return client;
    }

    @Override
    public List<Client> readByIDs(List<Long> listIds) {
        List<Client> listClient=(List<Client>) clientDao.findAllById(listIds);
        return listClient;
    }

    @Override
    public List<Client> readAll() {
        final Spliterator<Client> result = clientDao.findAll().spliterator();
        return StreamSupport
                .stream(result, false)
                .collect(Collectors.toList());
    }

    @Override
    public Client update(Long id, Client clientNew) throws NotFoundData {
        final Client client = clientDao.findById(id)
                .orElseThrow(() -> new NotFoundData(id + " not found"));
        if(clientNew.getFirstName()!="") client.setFirstName(clientNew.getFirstName());
        if(clientNew.getPhoneNumber()!=0) client.setPhoneNumber(clientNew.getPhoneNumber());
        if(clientNew.getVolumeBonus()!=0) client.setVolumeBonus(clientNew.getVolumeBonus());
        client.setBill(clientNew.getBill());
        return clientDao.save(client);
    }

    @Override
    public void deleteById(Long id) {
        try {
            clientDao.deleteById(id);
        }catch (Exception e){
            throw new NotFoundData(id + " not found");
        }
    }

    @Override
    public void deleteList(List<Long> listIds){
        clientDao.deleteAllById(listIds);
    }
}
