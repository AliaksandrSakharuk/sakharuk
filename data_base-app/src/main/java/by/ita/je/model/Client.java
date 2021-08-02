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
    private boolean unwantedClient;
    private ZonedDateTime dataTime_request;

    public long getId() {        return id;    }

    public String getFirstName() {        return firstName;    }

    public String getLastName() {        return lastName;    }

    public long getPhoneNumber() {        return phoneNumber;    }

    public int getVolumeBonus() {        return volumeBonus;    }

    public BigDecimal getBill() {        return bill;    }

    public boolean isUnwantedClient() {        return unwantedClient;    }

    public ZonedDateTime getDataTime_request() {        return dataTime_request;    }

    public void setFirstName(String firstName) {        this.firstName = firstName;    }

    public void setLastName(String lastName) {        this.lastName = lastName;    }

    public void setPhoneNumber(long phoneNumber) {        this.phoneNumber = phoneNumber;    }

    public void setVolumeBonus(int volumeBonus) {        this.volumeBonus = volumeBonus;    }

    public void setBill(BigDecimal bill) {        this.bill = bill;    }

    public void setUnwantedClient(boolean unwantedClient) {        this.unwantedClient = unwantedClient;    }

    public void setDataTime_request(ZonedDateTime dataTime_request) {        this.dataTime_request = dataTime_request;    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", volumeBonus=" + volumeBonus +
                ", bill=" + bill +
                ", unwantedClient=" + unwantedClient +
                ", dataTime=" + dataTime_request +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Client)) return false;
        Client client = (Client) o;
        return getId() == client.getId() && getPhoneNumber() == client.getPhoneNumber() && getVolumeBonus() == client.getVolumeBonus() && isUnwantedClient() == client.isUnwantedClient() && Objects.equals(getFirstName(), client.getFirstName()) && Objects.equals(getLastName(), client.getLastName()) && Objects.equals(getBill(), client.getBill()) && Objects.equals(getDataTime_request(), client.getDataTime_request());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getFirstName(), getLastName(), getPhoneNumber(), getVolumeBonus(), getBill(), isUnwantedClient(), getDataTime_request());
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
        public Builder withUnwantedClient(boolean unwantedClient){
            client.unwantedClient=unwantedClient;
            return this;
        }
        public Builder withDataTime(ZonedDateTime dataTime){
            client.dataTime_request=dataTime;
            return this;
        }
        public Client build(){
            return client;
        }
    }



}
