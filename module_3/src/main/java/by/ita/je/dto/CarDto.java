package by.ita.je.dto;


import java.util.Objects;

public class CarDto {

    private String nameOwner;
    private String nameCar;
    private int mileage;
    private int power;

    public CarDto(String nameOwner, String nameCar, int mileage, int power) {
        this.nameOwner = nameOwner;
        this.nameCar = nameCar;
        this.mileage = mileage;
        this.power = power;
    }


    public String getNameOwner() {        return nameOwner;    }

    public String getNameCar() {        return nameCar;    }

    public int getMileage() {        return mileage;    }

    public int getPower() {        return power;    }

    @Override
    public String toString() {
        return "CarsDto{" +
                "nameOwner='" + nameOwner + '\'' +
                ", nameCar='" + nameCar + '\'' +
                ", mileage=" + mileage +
                ", power=" + power +
                '}';
    }




}
