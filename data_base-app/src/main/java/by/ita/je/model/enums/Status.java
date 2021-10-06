package by.ita.je.model.enums;

import java.util.stream.Stream;

public enum Status {
    DIRECTOR("director"),
    ACCOUNTANT("accountant"),
    MASTER("master"),
    MECHANIСAL("mechanic"),
    ASSISTANT("assistant");

    private String position;

    Status(String position) {
        this.position = position;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public static Status of(String position) {
        return Stream.of(Status.values())
                .filter(p -> p.getPosition().equalsIgnoreCase(position))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
