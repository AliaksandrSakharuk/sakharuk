package by.ita.je.model;

import by.ita.je.model.enums.Status;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import javax.persistence.*;

@Builder
@Entity
public class Position {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private long id;
    @Enumerated(EnumType.STRING)
    private Status status;
    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH}, mappedBy = "position")
    private Worker worker;

    public Position() {
    }

    public Position(long id, Status status, Worker worker) {
        this.id = id;
        this.status = status;
        this.worker = worker;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void setWorker(Worker worker) {
        this.worker = worker;
    }
}
