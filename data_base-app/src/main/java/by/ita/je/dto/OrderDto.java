package by.ita.je.dto;

import java.math.BigDecimal;

public class OrderDto {
    private String firstNameClient;
    private long phoneNumber;
    private int volumeBonus;
    private BigDecimal bill;

    public OrderDto() {    }

    public OrderDto(String firstNameClient, long phoneNumber, int volumeBonus, BigDecimal bill) {
        this.firstNameClient = firstNameClient;
        this.phoneNumber = phoneNumber;
        this.volumeBonus = volumeBonus;
        this.bill=bill;
    }

    public String getFirstNameClient() {
        return firstNameClient;
    }

    public void setFirstName(String firstNameClient) {
        this.firstNameClient = firstNameClient;
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
                "firstName='" + firstNameClient + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", volumeBonus=" + volumeBonus +
                ", bill=" + bill +
                '}';
    }
}