package com.tastecamp.api.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.tastecamp.api.services.RecipieService;

import jakarta.validation.Valid;

import com.tastecamp.api.dto.RecipieDTO;
import com.tastecamp.api.models.Recipie;

@RestController 
@RequestMapping("/api/recipies")
public class RecipiesController {

        @Autowired
        private RecipieService service;


    @GetMapping
    public List<Recipie> getAll(){
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Recipie> getById(@PathVariable Long id ){
        return service.findById(id);
    }

    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    public void create(@RequestBody @Valid RecipieDTO req){
        service.create(new Recipie(req));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void remove(@PathVariable Long id ){
        service.deleteById( id);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Long id, @RequestBody @Valid RecipieDTO req){
        service.update(id, req);
    }


}
