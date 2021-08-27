package by.ita.je.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import javax.persistence.*;
import java.time.ZonedDateTime;
import java.util.Objects;

@Entity
public class Detail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private long id;
    private String name;
    private String notes;
    private long partNumber;
    private double sellingPrice;
    private double purchasePrice ;
    private int extraCharge;
    private ZonedDateTime dataTimeDelivery;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "car_id")
    private Car car;

    public void setCar(Car car) {
        this.car = car;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public long getPartNumber() {
        return partNumber;
    }

    public void setPartNumber(long partNumber) {
        this.partNumber = partNumber;
    }

    public double getSellingPrice() {
        return sellingPrice;
    }

    public void setSellingPrice(double sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    public double getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(double purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public int getExtraCharge() {
        return extraCharge;
    }

    public void setExtraCharge(int extraCharge) {
        this.extraCharge = extraCharge;
    }

    public ZonedDateTime getDataTimeDelivery() {
        return dataTimeDelivery;
    }

    public void setDataTimeDelivery(ZonedDateTime dataTimeDelivery) {
        this.dataTimeDelivery = dataTimeDelivery;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Detail)) return false;
        Detail detail = (Detail) o;
        return getId() == detail.getId() && getPartNumber() == detail.getPartNumber() && Double.compare(detail.getSellingPrice(), getSellingPrice()) == 0 && Double.compare(detail.getPurchasePrice(), getPurchasePrice()) == 0 && getExtraCharge() == detail.getExtraCharge() && Objects.equals(getName(), detail.getName()) && Objects.equals(getNotes(), detail.getNotes()) && Objects.equals(getDataTimeDelivery(), detail.getDataTimeDelivery());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getNotes(), getPartNumber(), getSellingPrice(), getPurchasePrice(), getExtraCharge(), getDataTimeDelivery());
    }

    @Override
    public String toString() {
        return "Detail{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", notes='" + notes + '\'' +
                ", partNumber=" + partNumber +
                ", sellingPrice=" + sellingPrice +
                ", purchasePrice=" + purchasePrice +
                ", extraCharge=" + extraCharge +
                ", dataTimeDelivery=" + dataTimeDelivery +
                '}';
    }

    public static class Builder{
        Detail detail;

        public Builder(){ detail=new Detail();}

        public Builder withName(String name){
            detail.name=name;
            return this;
        }
        public Builder withNotes(String notes){
            detail.notes=notes;
            return this;
        }
        public Builder withPartNumber(long partNumber){
            detail.partNumber=partNumber;
            return this;
        }
        public Builder withPurchasePrice(double purchasePrice){
            detail.purchasePrice=purchasePrice;
            return this;
        }
        public Builder withSelling_price(double sellingPrice){
            detail.sellingPrice=sellingPrice;
            return this;
        }
        public Builder withExtraCharge(short extraCharge){
            detail.extraCharge=extraCharge;
            return this;
        }
        public Builder withDataTimeDelivery(ZonedDateTime dataTimeDelivery){
            detail.dataTimeDelivery=dataTimeDelivery;
            return this;
        }
        public Detail build(){
            return detail;
        }
    }
}