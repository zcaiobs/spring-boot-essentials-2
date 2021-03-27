package com.boot.spring.essentials.request;

import lombok.Data;
import org.hibernate.validator.constraints.URL;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@Data
public class AnimeRequestPost {
    @NotBlank(message = "The anime name cannot empty")
    private String name;
}
