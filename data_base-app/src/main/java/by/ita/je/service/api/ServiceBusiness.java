package by.ita.je.service.api;

import by.ita.je.model.*;
import com.fasterxml.jackson.databind.JsonNode;

import java.util.List;

public interface ServiceBusiness {
    Car addDetailToCar(long id, List<Detail> detailList);

    Car addCarToOrder(long id);

    Car update(Long id, Car car);

    JsonNode read(Long id);

    void delete(Long id);

}
