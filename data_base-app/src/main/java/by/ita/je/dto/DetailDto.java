package by.ita.je.dto;

public class DetailDto {
    private String name;
    private long partNumber;
    private double purchasePrice;
    private int extraCharge;

    public DetailDto() {    }

    public DetailDto(String name, long partNumber, double purchasePrice , int extraCharge) {
        this.name = name;
        this.partNumber = partNumber;
        this.purchasePrice  = purchasePrice ;
        this.extraCharge = extraCharge;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getPartNumber() {
        return partNumber;
    }

    public void setPartNumber(long partNumber) {
        this.partNumber = partNumber;
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

    @Override
    public String toString() {
        return "DetailDto{" +
                "name='" + name + '\'' +
                ", partNumber=" + partNumber +
                ", purchasePrice=" + purchasePrice +
                ", extraCharge=" + extraCharge +
                '}';
    }
}
