package com.study.agecalculator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AgecalculatorApplication {

	public static void main(String[] args) {
		SpringApplication.run(AgecalculatorApplication.class, args);

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
	}

}
