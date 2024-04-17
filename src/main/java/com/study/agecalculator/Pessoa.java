package com.study.agecalculator;

public class Pessoa (String nome, int idade) {

    @Override
    public String toString() {
        return String.format("%s:%d", nome, idade);
    }

}
