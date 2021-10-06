package by.ita.je.dto;


public class WorkerDto {
    private long id;
    private String firstName;
    private String secondName;
    private long phoneNumber;
    private int bonus;
    private PositionDto position;

    public WorkerDto() {    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public PositionDto getPosition() {
        return position;
    }

    public void setPosition(PositionDto position) {
        this.position = position;
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

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getBonus() {
        return bonus;
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }

    @Override
    public String toString() {
        return "WorkerDto{" +
                "firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", bonus=" + bonus +
                '}';
    }
}