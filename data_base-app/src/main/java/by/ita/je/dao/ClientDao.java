package by.ita.je.dao;

import by.ita.je.model.Client;
import org.springframework.data.repository.CrudRepository;

public interface ClientDao extends CrudRepository<Client, Long> {
}
