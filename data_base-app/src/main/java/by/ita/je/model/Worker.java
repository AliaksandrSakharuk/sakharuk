package by.ita.je.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.Objects;

@Entity
@Table(name = "worker")
public class Worker {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "second_name")
    private String secondName;
    @Column(name = "salary")
    private BigDecimal salary;
    @Column(name = "bonus")
    private int bonus;
    @Column(name = "phone_number")
    private long phoneNumber;
    @Column(name = "is_cheif")
    private boolean isCheif;
    @Column(name = "data_start_work")
    private ZonedDateTime dataTimeStartWork;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public int getBonus() {
        return bonus;
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public boolean isCheif() {
        return isCheif;
    }

    public void setCheif(boolean cheif) {
        isCheif = cheif;
    }

    public ZonedDateTime getDataTimeStartWork() {
        return dataTimeStartWork;
    }

    public void setDataTimeStartWork(ZonedDateTime dataTimeStartWork) {
        this.dataTimeStartWork = dataTimeStartWork;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Worker)) return false;
        Worker worker = (Worker) o;
        return getId() == worker.getId() && getBonus() == worker.getBonus() && getPhoneNumber() == worker.getPhoneNumber() && isCheif() == worker.isCheif() && Objects.equals(getFirstName(), worker.getFirstName()) && Objects.equals(getSecondName(), worker.getSecondName()) && Objects.equals(getSalary(), worker.getSalary()) && Objects.equals(getDataTimeStartWork(), worker.getDataTimeStartWork());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getFirstName(), getSecondName(), getSalary(), getBonus(), getPhoneNumber(), isCheif(), getDataTimeStartWork());
    }

    @Override
    public String toString() {
        return "Worker{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", salary=" + salary +
                ", bonus=" + bonus +
                ", phoneNumber=" + phoneNumber +
                ", isCheif=" + isCheif +
                ", dataTimeStartWork=" + dataTimeStartWork +
                '}';
    }

    public static class Builder{
        private Worker worker;

        public Builder withFirstName(String firstName){
            worker.firstName=firstName;
            return this;
        }
        public Builder withSecondName(String secondName){
            worker.secondName=secondName;
            return this;
        }
        public Builder withSalary(BigDecimal salary){
            worker.salary=salary;
            return this;
        }
        public Builder withBonus(int bonus){
            worker.bonus=bonus;
            return this;
        }
        public Builder withPhoneNumber(long phoneNumber){
            worker.phoneNumber=phoneNumber;
            return this;
        }
        public Builder withCheif(boolean isCheif){
            worker.isCheif=isCheif;
            return this;
        }
        public Worker build(){
            return worker;
        }
    }
}