package by.ita.je.dao;

import by.ita.je.model.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrderDao extends CrudRepository<Order, Long> {
}
