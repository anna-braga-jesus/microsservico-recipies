package com.tastecamp.api.dto;

import com.tastecamp.api.models.Level;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public record RecipieDTO(

    @NotNull @Size(min = 2, max = 30) String name, 

    @NotNull
    String ingredients,

    @NotNull String preparation,

    @NotNull @Positive int time,

    @NotNull Level level) {
    
}
