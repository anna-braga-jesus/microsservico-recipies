package com.tastecamp.api.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tastecamp.api.dto.RecipieDTO;
import com.tastecamp.api.models.Recipie;
import com.tastecamp.api.repository.RecipieRepository;

@Service
public class RecipieService {
    
    @Autowired
    private RecipieRepository repository;

    public List<Recipie> findAll(){
        return repository.findAll();
    }

    public Optional<Recipie> findById(Long id){
        return repository.findById(id);
    }

    public void create(Recipie data ){
    repository.save(data);

    }
    public void update(Long id, RecipieDTO data){
        repository.findById(id).map(r -> {
            r.setName(data.name());
            r.setIngredients(data.ingredients());
            r.setLevel(data.level().getDescricao());
            r.setPreparation(data.preparation());
            r.setTime(data.time());
            return repository.save(r);
        });
    }

    public void deleteById(Long id){
        repository.deleteById(id);
    }
}
