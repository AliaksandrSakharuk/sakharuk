package by.ita.je.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@Slf4j
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class NotFoundData extends RuntimeException {
    public NotFoundData(String mesege){
        super("The notice with id= " + mesege);
        log.error("Not found data");
    }
}
