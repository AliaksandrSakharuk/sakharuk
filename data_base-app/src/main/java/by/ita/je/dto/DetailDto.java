package by.ita.je.dto;

import by.ita.je.model.Detail;
import lombok.*;

import java.time.ZonedDateTime;


public class DetailDto {

    private String name;
    private long partNumber;
    private int cost;
    private short extraCharge; // наценка

    public String getName() {        return name;    }

    public long getPartNumber() {        return partNumber;    }

    public int getCost() {        return cost;    }

    public short getExtraCharge() {        return extraCharge;    }

    @Override
    public String toString() {
        return "DetailDto{" +
                "name='" + name + '\'' +
                ", partNumber=" + partNumber +
                ", cost=" + cost +
                ", extraCharge=" + extraCharge +
                '}';
    }
}
