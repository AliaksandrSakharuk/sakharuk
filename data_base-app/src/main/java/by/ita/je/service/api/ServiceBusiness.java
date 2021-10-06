package by.ita.je.service.api;

import by.ita.je.model.*;
import com.fasterxml.jackson.databind.JsonNode;

import java.util.List;

public interface ServiceBusiness {
    Car create(Car car);

    Car update(Long id, Car car);

    Car read(Long id);

    void delete(Long id);

}
