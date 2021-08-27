package by.ita.je.service;

import by.ita.je.dao.api.BusinessDao;
import by.ita.je.model.*;
import by.ita.je.model.enums.Status;
import by.ita.je.service.api.*;
import com.fasterxml.jackson.databind.JsonNode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BusinessServiceImpl implements ServiceBusiness {

    private final BusinessDao businessDao;
    private final ServiceCar serviceCar;
    private final ServiceDetail serviceDetail;
    private final ServiceWorker serviceWorker;
    private final ServicePosition servicePosition;


    @Override
    public JsonNode read(Long id) {
        return null;
    }

    @Override
    public Car update(Long id, Car car) {
        car.getDetails().forEach(detail -> serviceDetail.update(detail.getId(),detail));
        car.getOrder().getListWorker().forEach(worker
                -> servicePosition.update(worker.getPosition().getId(),worker.getPosition()));
        return car;
    }

    @Override
    public void delete(Long id) {
        serviceCar.deleteById(id);
    }

    @Override
    public Car addDetailToCar(long id, List<Detail> detailList) {
        Car car=serviceCar.findById(id);
        List<Detail> listDetailNew=car.getDetails();
        detailList.stream()
                .map(detail -> listDetailNew.add(detail))
                .collect(Collectors.toList());
        car.setDetails(listDetailNew);
        detailList.stream()
                .forEach(detail -> detail.setCar(car));
        return businessDao.save(car);
    }

    @Override
    public Car addCarToOrder(long id) {
    final Car car=serviceCar.findById(id);
    Order order=car.getOrder();
    if(Objects.isNull(order)){
        order=new Order.Builder()
                .withFirstName("IT-ACADEMY")
                .withBill(new BigDecimal(123))
                .withPhoneNumber(9393939)
                .build();
        car.setOrder(order);
        order.addCarToOder(car);
    }
        createIfNoRelationsOrderToPosition(order);
        return businessDao.save(car);
    }

    private void createIfNoRelationsOrderToPosition(Order order){
        List <Worker> listWorker=order.getListWorker();
        if(Objects.isNull(listWorker) || listWorker.isEmpty()){
            List<Worker> cs=new ArrayList<Worker>();
            Worker master=serviceWorker.findById(1L);
            Worker assistent=serviceWorker.findById(2L);
            master.setPosition(Position.builder()
                    .status(Status.MASTER)
                    .build());
            assistent.setPosition(Position.builder()
                    .status(Status.ASSISTANT)
                    .build());
            cs.add(master);
            cs.add(assistent);
            order.setListWorker(cs);
        }
    }
}
