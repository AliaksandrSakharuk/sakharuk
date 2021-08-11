package by.ita.je.dto;

import java.math.BigDecimal;

public class ClientDto {
    private String firstName;
    private long phoneNumber;
    private int volumeBonus;
    private BigDecimal bill;

    public ClientDto() {    }

    public ClientDto(String firstName, long phoneNumber, int volumeBonus, BigDecimal bill) {
        this.firstName = firstName;
        this.phoneNumber = phoneNumber;
        this.volumeBonus = volumeBonus;
        this.bill=bill;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getVolumeBonus() {
        return volumeBonus;
    }

    public void setVolumeBonus(int volumeBonus) {
        this.volumeBonus = volumeBonus;
    }

    public BigDecimal getBill() {
        return bill;
    }

    public void setBill(BigDecimal bill) {
        this.bill = bill;
    }

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
