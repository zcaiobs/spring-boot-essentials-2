package com.boot.spring.essentials.exception;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class BadRequestExceptionDetails {
    private String title;
    private String details;
    private int status;
    private String developerMessage;
    private LocalDateTime timestamp;
}
