package kg.china.crmprojectback.exception.handler;

import kg.china.crmprojectback.exception.BaseException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ApiExceptionHandler {
    @ExceptionHandler(value = BaseException.class)
    public ResponseEntity<?> getExceptionMessage(final BaseException e) {
        return buildBaseResponseMessage(e.getMessage(), e.getHttpStatus());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleValidationExceptions(final MethodArgumentNotValidException e) {
        Map<String, String> errors = new HashMap<>();
        e.getBindingResult().getAllErrors().forEach(error -> errors.put(
                ((FieldError) error).getField(),
                error.getDefaultMessage()
        ));

        return buildBaseResponseMessage(
                String.join(" : ", "Недопустимые значения", errors.toString()),
                HttpStatus.BAD_REQUEST
        );
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<?> handleDataIntegrityViolationException(final DataIntegrityViolationException e) {
        return buildBaseResponseMessage(
                String.join(
                        " - ",
                        "Нарушение уникальности",
                        e.getMostSpecificCause().getMessage().substring(
                                e.getMostSpecificCause().getMessage().lastIndexOf("Key")
                        )
                ),
                HttpStatus.UNPROCESSABLE_ENTITY
        );
    }

    private ResponseEntity<String> buildBaseResponseMessage(String message, HttpStatus status) {
        return new ResponseEntity<>(message, status);
    }
}