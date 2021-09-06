package by.ita.je.dao.api;

import by.ita.je.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.time.ZonedDateTime;
import java.util.List;

public interface SearcherJPQLDao extends JpaRepository<Car, Long> {

    @Query(value = "SELECT * FROM CAR INNER JOIN ORDERS ON car.order_id=orders.id INNER JOIN ORDERS_WORKER ON " +
            "orders.id=ORDERS_WORKER.ORDER_ID INNER JOIN WORKER ON ORDERS_WORKER .WORKER_ID =worker.id WHERE " +
            "worker.DATA_TIME_START_WORK  BETWEEN  :from_data AND :to_data AND car.name_car=:name"
            , nativeQuery = true)
    List<Car> findCarTWorkByPeriod(@Param("name") String nameCar
            , @Param("from_data") ZonedDateTime fromDataTimeStartWork
            , @Param("to_data") ZonedDateTime toDataTimeStartWork);
}
