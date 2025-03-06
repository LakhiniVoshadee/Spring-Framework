package lk.ijse.spring_boot_bean_validation_16.advise;

import lk.ijse.spring_boot_bean_validation_16.dto.ResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ResponseDTO> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        for (FieldError fieldError : ex.getBindingResult().getFieldErrors()) {
            errors.put(fieldError.getField(),
                    fieldError.getDefaultMessage());
        }
        ResponseDTO responseDTO = new ResponseDTO(
                "Validation Failed!",
                HttpStatus.BAD_REQUEST.value(),
                errors
        );
        return new ResponseEntity<>(responseDTO, HttpStatus.BAD_REQUEST);
    }
}
