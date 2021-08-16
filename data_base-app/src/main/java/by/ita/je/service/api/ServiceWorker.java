package by.ita.je.service.api;

import by.ita.je.exception.NotCorrectData;
import by.ita.je.exception.NotFoundData;
import by.ita.je.model.Worker;
import java.util.List;

public interface ServiceWorker {
    Worker create(Worker worker)throws NotCorrectData;

    Worker findById(Long id)throws NotFoundData;

    List<Worker> readByIDs(List <Long> listIds);

    List<Worker> readAll();

    Worker update(Long id, Worker worker)throws NotFoundData;

    void deleteById(Long id)throws NotFoundData;

    void deleteList(List <Long> listIds);
}
