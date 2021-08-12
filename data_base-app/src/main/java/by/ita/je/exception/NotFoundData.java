package by.ita.je.exception;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class NotFoundData extends RuntimeException {
    public NotFoundData(String mesege){
        super("The notice with id= " + mesege);
        log.error("Not found data");
    }
}
