package by.ita.je.model;




import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
    private ZonedDateTime dataTime_In;



    public void setNameOwner(String nameOwner) {        this.nameOwner = nameOwner;    }

    public long getId() {        return id;    }

    public String getNameOwner() {        return nameOwner;    }

    public String getNameCar() {        return nameCar;    }

    public int getMileage() {        return mileage;    }

    public int getPower() {        return power;    }

    public boolean isElectro() {        return isElectro;    }

    public boolean isHibrid() {        return isHibrid;    }

    public ZonedDateTime getDataTime_In() {        return dataTime_In;    }

    public void setNameCar(String nameCar) {        this.nameCar = nameCar;    }

    public void setMileage(int mileage) {        this.mileage = mileage;    }

    public void setPower(int power) {        this.power = power;    }

    public void setElectro(boolean electro) {        isElectro = electro;    }

    public void setOnHibrid(boolean onHibrid) {        this.isHibrid = onHibrid;    }

    public void setDataTime_In(ZonedDateTime dataTime_In) {        this.dataTime_In = dataTime_In;    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", nameOwner='" + nameOwner + '\'' +
                ", nameCar='" + nameCar + '\'' +
                ", mileage=" + mileage +
                ", power=" + power +
                ", isElectro=" + isElectro +
                ", onHibrid=" + isHibrid +
                ", dataTime_In=" + dataTime_In +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Car)) return false;
        Car car = (Car) o;
        return getId() == car.getId() && getMileage() == car.getMileage() && getPower() == car.getPower() && isElectro() == car.isElectro() && isHibrid() == car.isHibrid() && getNameOwner().equals(car.getNameOwner()) && getNameCar().equals(car.getNameCar()) && getDataTime_In().equals(car.getDataTime_In());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getNameOwner(), getNameCar(), getMileage(), getPower(), isElectro(), isHibrid(), getDataTime_In());
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
        public Builder withDataTime_In(){
            car.dataTime_In=ZonedDateTime.now();
            return this;
        }
        public Car build() {return car;}

    }



}
