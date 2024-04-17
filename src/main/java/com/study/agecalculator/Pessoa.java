package com.study.agecalculator;

public record Pessoa(String nome, int idade) {

    @Override
    public String toString() {
        return String.format("%s:%d", nome, idade);
    }

}
