package by.ita.je.service.api;

import by.ita.je.exception.NotCorrectData;
import by.ita.je.exception.NotFoundData;
import by.ita.je.model.Order;
import java.util.List;

public interface ServiceOrder {
    Order create(Order order) throws NotCorrectData;

    Order findById(Long id) throws NotFoundData;

    List<Order> readByIDs(List <Long> listIds);

    List<Order> readAll();

    Order update(Long id, Order order) throws NotFoundData;

    void deleteById(Long id) throws NotFoundData;

    void deleteList(List <Long> listIds);
}
