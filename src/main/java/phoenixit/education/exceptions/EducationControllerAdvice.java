package phoenixit.education.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import phoenixit.education.models.Response;

import java.util.NoSuchElementException;

@ControllerAdvice
public class EducationControllerAdvice {

    @ResponseBody
    @ExceptionHandler(EducationNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    ResponseEntity<Response> educationNotFoundHandler(EducationNotFoundException ex) {
        Response response = new Response(ex.getMessage());
        return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
    }

    @ResponseBody
    @ExceptionHandler(EducationAlreadyExistsException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    ResponseEntity<Response> educationAlreadyExists(EducationAlreadyExistsException ex) {
        Response response = new Response(ex.getMessage());
        return new ResponseEntity<>(response,HttpStatus.CONFLICT);
    }
}
