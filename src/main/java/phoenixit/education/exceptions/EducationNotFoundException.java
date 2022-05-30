package phoenixit.education.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.function.Supplier;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class EducationNotFoundException extends RuntimeException {
    public EducationNotFoundException (String message) {
        super(message);
    }
}
