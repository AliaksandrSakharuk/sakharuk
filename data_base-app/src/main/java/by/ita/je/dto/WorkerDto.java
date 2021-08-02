package by.ita.je.dto;




import java.math.BigDecimal;


public class WorkerDto {
    private String firstName;
    private String secondName;
    private BigDecimal salary;
    private int bonus;

    public WorkerDto() {    }

    public WorkerDto(String firstName, String secondName, BigDecimal salary, int bonus) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.salary = salary;
        this.bonus = bonus;
    }

    public void setFirstName(String firstName) {        this.firstName = firstName;    }

    public void setSecondName(String secondName) {        this.secondName = secondName;    }

    public void setSalary(BigDecimal salary) {        this.salary = salary;    }

    public void setBonus(int bonus) {        this.bonus = bonus;    }

    public String getFirstName() {        return firstName;    }

    public BigDecimal getSalary() {        return salary;    }

    public int getBonus() {        return bonus;    }

    public String getSecondName() {        return secondName;    }

    @Override
    public String toString() {
        return "WorkerDto{" +
                "firstName='" + firstName + '\'' +
                ", salary=" + salary +
                ", bonus=" + bonus +
                ", secondName=" + secondName +
                '}';
    }
}
