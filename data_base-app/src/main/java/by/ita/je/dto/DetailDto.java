package by.ita.je.dto;

import java.math.BigDecimal;

public class DetailDto {
    private String name;
    private long partNumber;
    private BigDecimal purchasePrice;
    private int extraCharge;

    public DetailDto() {    }

    public DetailDto(String name, long partNumber, BigDecimal purchasePrice , int extraCharge) {
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

    public BigDecimal getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(BigDecimal purchasePrice) {
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
                ", cost=" + purchasePrice  +
                ", extraCharge=" + extraCharge +
                '}';
    }
}
