package pro.sky.courseworkcouse_2.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Random;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class NotEnoughQuestionsException extends RuntimeException {

}
