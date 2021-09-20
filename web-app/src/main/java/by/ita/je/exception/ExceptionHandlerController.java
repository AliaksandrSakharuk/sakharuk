package by.ita.je.exception;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExceptionHandlerController  extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public String handlerException(Model model, Exception exception){
      String messege;
        int numberStatus=Integer.valueOf(exception.getMessage().substring(0,3).strip());
        if(numberStatus==404){
            messege="Сервер не может найти запрашиваемый ресурс!";
        }
        else if(numberStatus>=500){
            messege="Ошибка на стороне сервера";
        }
        else messege="Некорректный запрос";
        model.addAttribute("messege", messege);
        model.addAttribute("number", numberStatus);
        return "error";
    }
}
