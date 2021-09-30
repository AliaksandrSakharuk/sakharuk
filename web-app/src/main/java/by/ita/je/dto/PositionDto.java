package by.ita.je.dto;

import by.ita.je.dto.enums.Status;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

public class PositionDto {
    private long id;
    @Enumerated(EnumType.STRING)
    private Status status;

    public PositionDto() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public PositionDto(Status status) {
        this.status = status;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
