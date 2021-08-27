package by.ita.je.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.persistence.*;
import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.*;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private long id;
    private String firstNameClient;
    private String lastNameClient;
    private long phoneNumber;
    private int volumeBonus;
    private BigDecimal bill;
    private boolean isCash;
    private ZonedDateTime dataTimeRequest;

    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH}, mappedBy = "order")
    private List<Car> listCar;

    @ManyToMany(cascade ={CascadeType.PERSIST, CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH}, fetch = FetchType.LAZY)
    @JoinTable(
            name = "ORDERS_WORKER"
            ,joinColumns = @JoinColumn(name = "order_id")
            ,inverseJoinColumns = @JoinColumn(name = "worker_id")
    )
    private List<Worker> listWorker;

    public void addCarToOder(Car car){
        if(listCar==null){
            listCar= new ArrayList<Car>();
        }
        listCar.add(car);
    }

    public void setListCar(List<Car> listCar) {
        this.listCar = listCar;
    }

    public List<Worker> getListWorker() {
        return listWorker;
    }

    public void setListWorker(List<Worker> listWorker) {
        this.listWorker = listWorker;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstNameClient() {
        return firstNameClient;
    }

    public void setFirstNameClient(String firstNameClient) {
        this.firstNameClient = firstNameClient;
    }

    public String getLastNameClient() {
        return lastNameClient;
    }

    public void setLastNameClient(String lastNameClient) {
        this.lastNameClient = lastNameClient;
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

    public boolean isCash() {
        return isCash;
    }

    public void setCash(boolean cash) {
        isCash = cash;
    }

    public ZonedDateTime getDataTimeRequest() {
        return dataTimeRequest;
    }

    public void setDataTimeRequest(ZonedDateTime dataTimeRequest) {
        this.dataTimeRequest = dataTimeRequest;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Order)) return false;
        Order order = (Order) o;
        return getId() == order.getId() && getPhoneNumber() == order.getPhoneNumber() && getVolumeBonus() == order.getVolumeBonus() && isCash() == order.isCash() && Objects.equals(getFirstNameClient(), order.getFirstNameClient()) && Objects.equals(getLastNameClient(), order.getLastNameClient()) && Objects.equals(getBill(), order.getBill()) && Objects.equals(getDataTimeRequest(), order.getDataTimeRequest());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getFirstNameClient(), getLastNameClient(), getPhoneNumber(), getVolumeBonus(), getBill(), isCash(), getDataTimeRequest());
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", firstName='" + firstNameClient + '\'' +
                ", lastName='" + lastNameClient + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", volumeBonus=" + volumeBonus +
                ", bill=" + bill +
                ", isCash=" + isCash +
                ", dataTimeRequest=" + dataTimeRequest +
                '}';
    }


    public static class Builder{
        Order order;

        public Builder(){ order=new Order();}

        public Builder withFirstName(String firstNameClient){
            order.firstNameClient=firstNameClient;
            return this;
        }

        public Builder withLastName(String lastNameClient){
            order.lastNameClient=lastNameClient;
            return this;
        }

        public Builder withPhoneNumber(long phoneNumber){
            order.phoneNumber=phoneNumber;
            return this;
        }
        public Builder withVolumeBonus(int volumeBonus){
            order.volumeBonus=volumeBonus;
            return this;
        }
        public Builder withBill(BigDecimal bill){
            order.bill=bill;
            return this;
        }
        public Builder withCash(boolean isCash){
            order.isCash=isCash;
            return this;
        }
        public Builder withDataTime(ZonedDateTime dataTime){
            order.dataTimeRequest=dataTime;
            return this;
        }
        public Order build(){
            return order;
        }
    }
}