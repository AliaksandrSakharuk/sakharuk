package by.ita.je.dao;

import by.ita.je.model.Worker;
import org.springframework.data.repository.CrudRepository;

public interface WorkerDao extends CrudRepository<Worker, Long> {
}
