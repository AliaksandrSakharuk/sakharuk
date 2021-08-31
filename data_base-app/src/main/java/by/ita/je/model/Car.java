package by.ita.je.model;

import javax.persistence.*;
import java.time.ZonedDateTime;
import java.util.Objects;
@Entity
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