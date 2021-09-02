package by.ita.je.dao.api;

import by.ita.je.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.time.ZonedDateTime;

public interface SearcherDao extends JpaRepository<Car, Long> {

    @Query(value = "SELECT * FROM CAR,ORDERS, ORDERS_WORKER, WORKER WHERE car.name_car=:name AND " +
            "car.order_id=orders.id AND orders_worker.order_id=orders.id AND orders_worker.worker_id=worker.id " +
            "AND worker.DATA_TIME_START_WORK  BETWEEN  :from_data AND :to_data", nativeQuery = true)
    Car findCarTWorkByPeriod(@Param("name") String nameCar
            , @Param("from_data") ZonedDateTime fromDataTimeStartWork
            , @Param("to_data") ZonedDateTime toDataTimeStartWork);
}
