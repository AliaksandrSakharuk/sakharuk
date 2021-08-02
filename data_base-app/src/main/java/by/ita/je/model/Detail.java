package by.ita.je.model;




import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.Objects;

@Entity
public class Detail {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String notes;
    private long partNumber;
    private BigDecimal sellingPrice;
    private BigDecimal purchasePrice ;
    private int extraCharge;
    private ZonedDateTime dataTimeDelivery;

    public String getName() {        return name;    }

    public String getNotes() {        return notes;    }

    public long getPartNumber() {        return partNumber;    }

    public BigDecimal getSellingPrice() {        return sellingPrice;    }

    public BigDecimal getPurchasePrice() {        return purchasePrice;    }

    public int getExtraCharge() {        return extraCharge;    }

    public ZonedDateTime getDataTimeDelivery() {        return dataTimeDelivery;    }

    public void setName(String name) {        this.name = name;    }

    public void setNotes(String notes) {        this.notes = notes;    }

    public void setPartNumber(long partNumber) {        this.partNumber = partNumber;    }

    public void setSellingPrice(BigDecimal sellingPrice) {        this.sellingPrice = sellingPrice;    }

    public void setPurchasePrice(BigDecimal purchasePrice) {        this.purchasePrice = purchasePrice;    }

    public void setExtraCharge(int extraCharge) {        this.extraCharge = extraCharge;    }

    public void setDataTimeDelivery(ZonedDateTime dataTimeDelivery) {        this.dataTimeDelivery = dataTimeDelivery;    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Detail)) return false;
        Detail detail = (Detail) o;
        return id == detail.id && getPartNumber() == detail.getPartNumber() && getExtraCharge() == detail.getExtraCharge() && Objects.equals(getName(), detail.getName()) && Objects.equals(getNotes(), detail.getNotes()) && Objects.equals(getSellingPrice(), detail.getSellingPrice()) && Objects.equals(getPurchasePrice(), detail.getPurchasePrice()) && Objects.equals(getDataTimeDelivery(), detail.getDataTimeDelivery());
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, getName(), getNotes(), getPartNumber(), getSellingPrice(), getPurchasePrice(), getExtraCharge(), getDataTimeDelivery());
    }

    public static class Builder{
        Detail detail;

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
        public Builder withPurchasePrice(BigDecimal purchasePrice){
            detail.purchasePrice=purchasePrice;
            return this;
        }
        public Builder withSelling_price(BigDecimal sellingPrice){
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
        public Detail build(){ return detail;}


    }
}
