package by.ita.je.service.api;

import by.ita.je.exception.NotCorrectData;
import by.ita.je.exception.NotFoundData;
import by.ita.je.model.Client;
import java.util.List;

public interface ServiceClient {
    Client create(Client client) throws NotCorrectData;

    Client findById(Long id) throws NotFoundData;

    List<Client> readByIDs(List <Long> listIds);

    List<Client> readAll();

    Client update(Long id, Client client) throws NotFoundData;

    void deleteById(Long id) throws NotFoundData;

    void deleteList(List <Long> listIds);
}
