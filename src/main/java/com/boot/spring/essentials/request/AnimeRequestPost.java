package com.boot.spring.essentials.request;

import lombok.Data;
import javax.validation.constraints.NotBlank;

@Data
public class AnimeRequestPost {
    @NotBlank(message = "The anime name cannot empty")
    private String name;
}
