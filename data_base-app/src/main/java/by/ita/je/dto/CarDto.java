package by.ita.je.dto;



public class CarDto {
    private String nameCar;
    private String nameOwner;
       private int mileage;
    private int power;

    public CarDto() {    }

    public CarDto(String nameCar, String nameOwner,  int mileage, int power) {
        this.nameCar = nameCar;
        this.nameOwner = nameOwner;
        this.mileage = mileage;
        this.power = power;
    }

    public void setNameOwner(String nameOwner) {        this.nameOwner = nameOwner;    }

    public void setNameCar(String nameCar) {        this.nameCar = nameCar;    }

    public void setMileage(int mileage) {        this.mileage = mileage;    }

    public void setPower(int power) {        this.power = power;    }

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
