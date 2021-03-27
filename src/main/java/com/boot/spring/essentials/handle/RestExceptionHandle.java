package com.boot.spring.essentials.handle;

import com.boot.spring.essentials.exception.BadRequestException;
import com.boot.spring.essentials.exception.BadRequestExceptionDetails;
import com.boot.spring.essentials.exception.ValidationExceptionDetails;
import lombok.extern.log4j.Log4j2;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Log4j2
@ControllerAdvice
public class RestExceptionHandle {
    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<BadRequestExceptionDetails> handleBadRequestException(BadRequestException bre) {
        return new ResponseEntity<>(
                BadRequestExceptionDetails.builder()
                    .timestamp(LocalDateTime.now())
                    .status(HttpStatus.BAD_REQUEST.value())
                    .title("Bad Request Exception, check the Documentation")
                    .details(bre.getMessage())
                    .developerMessage(bre.getClass().getName())
                    .build(), HttpStatus.BAD_REQUEST
        );
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ValidationExceptionDetails> handleMethodArgumentNotValidException
            (MethodArgumentNotValidException exception) {
        List<FieldError> fieldErrors = exception.getBindingResult().getFieldErrors();
        String filds = fieldErrors.stream().map(FieldError::getField).collect(Collectors.joining(", "));
        String fildsMessage = fieldErrors.stream().map(DefaultMessageSourceResolvable::getDefaultMessage).collect(Collectors.joining(", "));

        return new ResponseEntity<>(
                ValidationExceptionDetails.builder()
                        .timestamp(LocalDateTime.now())
                        .status(HttpStatus.BAD_REQUEST.value())
                        .title("Bad Request Exception, invalid filds")
                        .details("Check the field(s) error")
                        .developerMessage(exception.getClass().getName())
                        .filds(filds)
                        .fildsMessage(fildsMessage)
                        .build(), HttpStatus.BAD_REQUEST
        );
    }
}
