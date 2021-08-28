package by.ita.je.service;

import by.ita.je.model.*;
import by.ita.je.model.enums.Status;
import by.ita.je.service.api.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
@Transactional
public class BusinessServiceImpl implements ServiceBusiness {

    private final ServiceCar serviceCar;
    private final ServiceDetail serviceDetail;
    private final ServiceWorker serviceWorker;
    private final ServicePosition servicePosition;

    @Override
    public Car create(Car car) {
    createIfNoRelationshipCarToDetail(car);
    createIfNoRelationsCarToPosition(car);
        return serviceCar.create(car);
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
    public Car read(Long id) {
        return serviceCar.findById(id);
    }

    private void createIfNoRelationshipCarToDetail(Car car) {
        List<Detail> listDetail=car.getDetails();
        if(Objects.isNull(listDetail) || listDetail.isEmpty()){
            List<Detail> listNew= Stream
                    .generate(()->serviceDetail.create(new Detail.Builder().withName("POWER").build()))
                    .limit(2)
                    .collect(Collectors.toList());
            listNew.stream().forEach(detail -> detail.setCar(car));
        car.setDetails(listNew);
        }
    }
    private void createIfNoRelationsCarToPosition(Car car){
        if(Objects.isNull(car.getOrder())){
            car.setOrder(createOrder());
        }
        if(Objects.isNull(car.getOrder().getListWorker()) || car.getOrder().getListWorker().isEmpty()){
            car.getOrder().setListWorker(createWorkers());
        }
    }

    private Order createOrder(){
        return new Order.Builder()
                .withFirstName("IT-ACADEMY")
                .withBill(new BigDecimal(123))
                .withPhoneNumber(9393939)
                .build();
    }

    private  List<Worker> createWorkers(){
        Worker master=serviceWorker.create(new Worker.Builder().withSecondName("SAKHARUK").build());
        Worker assistent=serviceWorker.create(new Worker.Builder().withSecondName("KAZAK").build());
        master.setPosition(Position.builder()
                .status(Status.MASTER)
                .build());
        assistent.setPosition(Position.builder()
                .status(Status.ASSISTANT)
                .build());
        return List.of(master, assistent);
    }
}
