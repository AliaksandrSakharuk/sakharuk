package by.ita.je.service;

import by.ita.je.dao.api.OrderDao;
import by.ita.je.exception.NotCorrectData;
import by.ita.je.exception.NotFoundData;
import by.ita.je.model.Order;
import by.ita.je.service.api.ServiceOrder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Spliterator;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Component
@RequiredArgsConstructor
public class OrderServiceImpl implements ServiceOrder {

    private final OrderDao orderDao;

    @Override
    public Order create(Order order) throws NotCorrectData {
        if(order.getFirstNameClient()==null) throw new NotCorrectData("Not correct data FIRST_NAME_CLIENT");
        order.setCash(false);
        order.setLastNameClient("Неизвестно");
        order.setDataTimeRequest(ZonedDateTime.now());
        return orderDao.save(order);
    }

    @Override
    public Order findById(Long id) throws NotFoundData{
        final Order order = orderDao.findById(id)
                .orElseThrow(() -> new NotFoundData(id + " not found"));
        return order;
    }

    @Override
    public List<Order> readByIDs(List<Long> listIds) {
        List<Order> listOrder =(List<Order>) orderDao.findAllById(listIds);
        return listOrder;
    }

    @Override
    public List<Order> readAll() {
        final Spliterator<Order> result = orderDao.findAll().spliterator();
        return StreamSupport
                .stream(result, false)
                .collect(Collectors.toList());
    }

    @Override
    public Order update(Long id, Order orderNew) throws NotFoundData {
        final Order order = orderDao.findById(id)
                .orElseThrow(() -> new NotFoundData(id + " not found"));
        if(orderNew.getFirstNameClient()!="") order.setFirstNameClient(orderNew.getFirstNameClient());
        if(orderNew.getPhoneNumber()!=0) order.setPhoneNumber(orderNew.getPhoneNumber());
        if(orderNew.getVolumeBonus()!=0) order.setVolumeBonus(orderNew.getVolumeBonus());
        order.setBill(orderNew.getBill());
        return orderDao.save(order);
    }

    @Override
    public void deleteById(Long id) {
        try {
            orderDao.deleteById(id);
        }catch (Exception e){
            throw new NotFoundData(id + " not found");
        }
    }

    @Override
    public void deleteList(List<Long> listIds){
        orderDao.deleteAllById(listIds);
    }
}
