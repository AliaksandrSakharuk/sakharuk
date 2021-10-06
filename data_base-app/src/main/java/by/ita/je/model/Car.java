package by.ita.je.model;

import javax.persistence.*;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
@Entity
@NamedQuery(name = "FindCarByHQL", query = "SELECT car FROM Car car JOIN car.order JOIN car.order.listWorker worker " +
        "WHERE (worker.dataTimeStartWork BETWEEN  :from_data AND :to_data) AND car.nameCar=:name")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nameOwner;
    private String nameCar;
    private int mileage;
    private int power;
    private boolean isElectro;
    private boolean isHibrid;
    private ZonedDateTime dataTimeStartFix;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "car", fetch = FetchType.LAZY)
    private List<Detail> details;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name = "ORDER_ID")
    private  Order order;

    public void addDetailToCar(Detail detail){
        if(details==null){
            details = new ArrayList<Detail>();
        }
        details.add(detail);
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public List<Detail> getDetails() {
        return details;
    }

    public void setDetails(List<Detail> details) {
        this.details = details;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNameOwner() {
        return nameOwner;
    }

    public void setNameOwner(String nameOwner) {
        this.nameOwner = nameOwner;
    }

    public String getNameCar() {
        return nameCar;
    }

    public void setNameCar(String nameCar) {
        this.nameCar = nameCar;
    }

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public boolean isElectro() {
        return isElectro;
    }

    public void setElectro(boolean electro) {
        isElectro = electro;
    }

    public boolean isHibrid() {
        return isHibrid;
    }

    public void setHibrid(boolean hibrid) {
        isHibrid = hibrid;
    }

    public ZonedDateTime getDataTimeStartFix() {
        return dataTimeStartFix;
    }

    public void setDataTimeStartFix(ZonedDateTime dataTimeStartFix) {
        this.dataTimeStartFix = dataTimeStartFix;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Car)) return false;
        Car car = (Car) o;
        return getId() == car.getId() && getMileage() == car.getMileage() && getPower() == car.getPower() && isElectro() == car.isElectro() && isHibrid() == car.isHibrid() && Objects.equals(getNameOwner(), car.getNameOwner()) && Objects.equals(getNameCar(), car.getNameCar()) && Objects.equals(getDataTimeStartFix(), car.getDataTimeStartFix());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getNameOwner(), getNameCar(), getMileage(), getPower(), isElectro(), isHibrid(), getDataTimeStartFix());
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", nameOwner='" + nameOwner + '\'' +
                ", nameCar='" + nameCar + '\'' +
                ", mileage=" + mileage +
                ", power=" + power +
                ", isElectro=" + isElectro +
                ", isHibrid=" + isHibrid +
                ", dataTimeStartFix=" + dataTimeStartFix +
                '}';
    }

    public static class Builder{
        private Car car;

        public Builder(){ car=new Car();}

        public Builder withNameOwner(String name){
            car.nameOwner=name;
            return this;
        }
        public Builder withNameCar(String name){
            car.nameCar=name;
            return this;
        }
        public Builder withMileage(int mileage){
            car.mileage=mileage;
            return this;
        }
        public Builder withPower(int power){
            car.power=power;
            return this;
        }
        public Builder withIsElectro(boolean isElectro){
            car.isElectro=isElectro;
            return this;
        }
        public Builder withIsHibrid(boolean isHibrid){
            car.isHibrid=isHibrid;
            return this;
        }
        public Builder withDataTimeStartFix(){
            car.dataTimeStartFix=ZonedDateTime.now();
            return this;
        }
        public Car build() {
            return car;
        }
    }
}