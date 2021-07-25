package by.ita.je.dto;


import by.ita.je.model.Worker;

import java.time.ZonedDateTime;

public class WorkerDto {
    private String firstName;
    private String secondName;
    private int salary;
    private int bonus;


    public String getFirstName() {        return firstName;    }

    public int getSalary() {        return salary;    }

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
