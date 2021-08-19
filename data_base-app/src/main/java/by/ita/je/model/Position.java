package by.ita.je.model;


public enum Position {
    DIRECTOR( 1, "direcotr"),
    ACCOUNTANT(2, "accountant"),
    MASTER(3, "master"),
    MECHANIС(4, "mechanic"),
    ASSISTANT(5, "assistant");


    private long id;
    private String position;

    Position(long id, String position) {
        this.id = id;
        this.position = position;
    }
}
