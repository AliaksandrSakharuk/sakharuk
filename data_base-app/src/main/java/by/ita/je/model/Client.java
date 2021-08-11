package by.ita.je.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.Objects;

@Entity
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String firstName;
    private String lastName;
    private long phoneNumber;
    private int volumeBonus;
    private BigDecimal bill;
    private boolean isCash;
    private ZonedDateTime dataTimeRequest;

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

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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
        if (!(o instanceof Client)) return false;
        Client client = (Client) o;
        return getId() == client.getId() && getPhoneNumber() == client.getPhoneNumber() && getVolumeBonus() == client.getVolumeBonus() && isCash() == client.isCash() && Objects.equals(getFirstName(), client.getFirstName()) && Objects.equals(getLastName(), client.getLastName()) && Objects.equals(getBill(), client.getBill()) && Objects.equals(getDataTimeRequest(), client.getDataTimeRequest());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getFirstName(), getLastName(), getPhoneNumber(), getVolumeBonus(), getBill(), isCash(), getDataTimeRequest());
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", volumeBonus=" + volumeBonus +
                ", bill=" + bill +
                ", isCash=" + isCash +
                ", dataTimeRequest=" + dataTimeRequest +
                '}';
    }

    public static class Builder{
        Client client;

        public Builder withFirstName(String firstName){
            client.firstName=firstName;
            return this;
        }

        public Builder withLastName(String lastName){
            client.lastName=lastName;
            return this;
        }

        public Builder withPhoneNumber(long phoneNumber){
            client.phoneNumber=phoneNumber;
            return this;
        }
        public Builder withVolumeBonus(int volumeBonus){
            client.volumeBonus=volumeBonus;
            return this;
        }
        public Builder withBill(BigDecimal bill){
            client.bill=bill;
            return this;
        }
        public Builder withCash(boolean isCash){
            client.isCash=isCash;
            return this;
        }
        public Builder withDataTime(ZonedDateTime dataTime){
            client.dataTimeRequest=dataTime;
            return this;
        }
        public Client build(){
            return client;
        }
    }
}
