package com.study.agecalculator;
import java.time.LocalDate;

public class App {

    public static void main(String[] args) {
        PessoaFactory factory = new PessoaFactory();
        for(String item : calcularIdades(args, factory)) {
            System.out.println(item);
        }
    }

    public static String[] calcularIdades(String[] args, PessoaFactory factory) {
        Pessoa[] pessoas = factory.criar(args);
        String[] saida = new String[args.length];

        for(int i = 0; i < pessoas.length; i++) {
            saida[i] = pessoas[i].toString();
        }

        return saida;
    }

    private static class PessoaFactory {
        public Pessoa[] criar(String[] args) {
            return new Pessoa[0];
        }
    }
}
