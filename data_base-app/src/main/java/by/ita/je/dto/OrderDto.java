package by.ita.je.dto;

import by.ita.je.model.Worker;

import java.math.BigDecimal;
import java.util.List;

public class OrderDto {
    private long id;
    private String firstNameClient;
    private long phoneNumber;
    private int volumeBonus;
    private BigDecimal bill;
    private List<WorkerDto> listWorker;

    public OrderDto() {    }

    public List<WorkerDto> getListWorker() {
        return listWorker;
    }

    public void setListWorker(List<WorkerDto> listWorker) {
        this.listWorker = listWorker;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setFirstNameClient(String firstNameClient) {
        this.firstNameClient = firstNameClient;
    }

    public String getFirstNameClient() {
        return firstNameClient;
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