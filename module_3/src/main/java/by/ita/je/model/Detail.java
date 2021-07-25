package by.ita.je.model;



import javax.persistence.*;
import java.time.ZonedDateTime;
import java.util.Objects;

@Entity
@Table(name="details")
public class Detail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String notes;
    private long partNumber;
    private int weight;
    private int cost;
    private short extraCharge; // наценка
    private ZonedDateTime dataTimeDelivery;

    public String getName() {        return name;    }

    public String getNotes() {        return notes;    }

    public long getPartNumber() {        return partNumber;    }

    public int getWeight() {        return weight;    }

    public int getCost() {        return cost;    }

    public short getExtraCharge() {        return extraCharge;    }

    public ZonedDateTime getDataTimeDelivery() {        return dataTimeDelivery;    }

    public void setName(String name) {        this.name = name;    }

    public void setNotes(String notes) {        this.notes = notes;    }

    public void setPartNumber(long partNumber) {        this.partNumber = partNumber;    }

    public void setWeight(int weight) {        this.weight = weight;    }

    public void setCost(int cost) {        this.cost = cost;    }

    public void setExtraCharge(short extraCharge) {        this.extraCharge = extraCharge;    }

    public void setDataTimeDelivery(ZonedDateTime dataTimeDelivery) {        this.dataTimeDelivery = dataTimeDelivery;    }

    @Override
    public String toString() {
        return "Detail{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", notes='" + notes + '\'' +
                ", partNumber=" + partNumber +
                ", weight=" + weight +
                ", cost=" + cost +
                ", extraCharge=" + extraCharge +
                ", dataTimeDelivery=" + dataTimeDelivery +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Detail)) return false;
        Detail detail = (Detail) o;
        return id == detail.id && getPartNumber() == detail.getPartNumber() && getWeight() == detail.getWeight() && getCost() == detail.getCost() && getExtraCharge() == detail.getExtraCharge() && Objects.equals(getName(), detail.getName()) && Objects.equals(getNotes(), detail.getNotes()) && Objects.equals(getDataTimeDelivery(), detail.getDataTimeDelivery());
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, getName(), getNotes(), getPartNumber(), getWeight(), getCost(), getExtraCharge(), getDataTimeDelivery());
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
        public Builder withWeight(int weight){
            detail.weight=weight;
            return this;
        }
        public Builder withCost(int cost){
            detail.cost=cost;
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
