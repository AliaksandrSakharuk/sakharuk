package by.ita.je.service.api;

import by.ita.je.exception.NotCorrectData;
import by.ita.je.exception.NotFoundData;
import by.ita.je.model.Detail;
import java.util.List;

public interface ServiceDetail {
    Detail create(Detail detail)throws NotCorrectData;

    Detail findById(Long id)throws NotFoundData;

    List<Detail> readByIDs(List <Long> listIds);

    List<Detail> readAll();

    Detail update(Long id, Detail detail)throws NotFoundData;

    void deleteById(Long id)throws NotFoundData;

    void deleteList(List <Long> listIds);
}
