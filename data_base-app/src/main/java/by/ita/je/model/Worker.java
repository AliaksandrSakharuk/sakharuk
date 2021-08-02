package by.ita.je.model;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.Objects;


@Entity
public class Worker {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String firstName;
    private String secondName;
    private BigDecimal salary;
    private int bonus;
    private long phoneNumber;
    private boolean cheif;
    private ZonedDateTime dataTime_start;

    public int getBonus() {        return bonus;    }

    public String getFirstName() {        return firstName;    }

    public String getSecondName() {        return secondName;    }

    public BigDecimal getSalary() {        return salary;    }

    public long getPhoneNumber() {        return phoneNumber;    }

    public boolean isMaster() {        return cheif;    }

    public ZonedDateTime getDataTime_start() {        return dataTime_start;    }

    public void setFirstName(String firstName) {        this.firstName = firstName;    }

    public void setSecondName(String secondName) {        this.secondName = secondName;    }

    public void setSalary(BigDecimal salary) {        this.salary = salary;    }

    public void setBonus(int bonus) {        this.bonus = bonus;    }

    public void setPhoneNumber(long phoneNumber) {        this.phoneNumber = phoneNumber;    }

    public void setCheif(boolean cheif) {        this.cheif = cheif;    }

    public void setDataTime_start(ZonedDateTime dataTime_start) {        this.dataTime_start = dataTime_start;    }

    @Override
    public String toString() {
        return "Worker{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", salary=" + salary +
                ", bonus=" + bonus +
                ", phoneNumber=" + phoneNumber +
                ", cheif=" + cheif +
                ", dataTime_start=" + dataTime_start +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Worker)) return false;
        Worker worker = (Worker) o;
        return id == worker.id && getBonus() == worker.getBonus() && getPhoneNumber() == worker.getPhoneNumber() && cheif == worker.cheif && Objects.equals(getFirstName(), worker.getFirstName()) && Objects.equals(getSecondName(), worker.getSecondName()) && Objects.equals(getSalary(), worker.getSalary()) && Objects.equals(getDataTime_start(), worker.getDataTime_start());
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, getFirstName(), getSecondName(), getSalary(), getBonus(), getPhoneNumber(), cheif, getDataTime_start());
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
        public Builder withMaster(boolean cheif){
            worker.cheif=cheif;
            return this;
        }
        public Worker build(){
            return worker;
        }
    }
}
