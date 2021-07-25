package by.ita.je.dto;



public class ClientDto {

    private String firstName;
    private long phoneNumber;
    private int volumeBonus;
    private int bill;

    public ClientDto(String firstName, long phoneNumber, int volumeBonus, int bill) {
        this.firstName = firstName;
        this.phoneNumber = phoneNumber;
        this.volumeBonus = volumeBonus;
        this.bill=bill;
    }

    public String getFirstName() {        return firstName;    }

    public long getPhoneNumber() {        return phoneNumber;    }

    public int getVolumeBonus() {        return volumeBonus;    }

    public int getBill() {        return bill;    }

    @Override
    public String toString() {
        return "ClientDto{" +
                "firstName='" + firstName + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", volumeBonus=" + volumeBonus +
                ", bill=" + bill +
                '}';
    }
}
