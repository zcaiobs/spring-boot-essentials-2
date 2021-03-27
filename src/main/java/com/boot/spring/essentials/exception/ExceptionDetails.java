package com.boot.spring.essentials.exception;

import lombok.Data;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@Data
@SuperBuilder
public class ExceptionDetails {
    private String title;
    private String details;
    private int status;
    private String developerMessage;
    private LocalDateTime timestamp;
}
