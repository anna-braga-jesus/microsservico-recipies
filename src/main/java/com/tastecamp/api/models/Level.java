package com.tastecamp.api.models;

public enum Level {
        INICIANTE("iniciante"),
        MEDIO("medio"),
        AVANCADO("avancado");
    
        private String descricao;
    
        Level(String descricao) {
            this.descricao = descricao;
        }
    
        public String getDescricao() {
            return descricao;
        }
    }
    
