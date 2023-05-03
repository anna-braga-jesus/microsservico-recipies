package com.tastecamp.api.models;

import com.tastecamp.api.dto.RecipieDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Entity
@NoArgsConstructor
public class Recipie {

    public Recipie(RecipieDTO req){
            this.name = req.name();
            this.ingredients = req.ingredients();
            this.preparation = req.preparation();
            this.time = req.time();
            this.level = req.level().getDescricao();
    }
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(length = 50, nullable = false)
    private String name;

    @Column(length = 50, nullable = false)
    private String ingredients;

    @Column(length = 150, nullable = false)
    private String preparation;

    @Column(nullable = false)
    private int time;

    @Column( nullable = false)
    private String level;
}
