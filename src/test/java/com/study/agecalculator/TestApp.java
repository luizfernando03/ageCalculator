package com.study.agecalculator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class TestApp {

   PessoaFactory pessoaFactory = new PessoaFactory(2024);
    @Test
    public void deveCalcularIdadeCorretamente() {
        String[] args = {"Jose:1990", "Maria:1980"};
        String[] esperado = {"Jose:34", "Maria:44"};

        String[] resultado = App.calcularIdades(args, pessoaFactory);

        assertArrayEquals(esperado, resultado);
    }

    @Test
    public void deveRetornarUmaStringVaziaQuandoListaDeEntradaEVazia() {
        String[] args = {};
        String[] esperado = {};

        String[] resultado = App.calcularIdades(args, factory);

        assertArrayEquals(esperado, resultado);
    }

    public static Stream<Arguments> gerarEntradasInvalidas() {
        return Stream.of(
                arguments("Jose:2025", "Ano de nascimento não pode ser maior que o atual."),
                arguments(":2020", "O nome não pode ser vazio."),
                arguments("Jose:", "Cada linha da entrada deve seguir o formato nome:anoNascimento."),
                arguments("Jose2020", "Cada linha da entrada deve seguir o formato nome:anoNascimento."),
                arguments("", "Cada linha da entrada deve seguir o formato nome:anoNascimento.")
        );
    }

    @ParameterizedTest
    @MethodSource("gerarEntradasInvalidas")
    public void deveGerarExcecaoQuandoIdadeMaiorQueAnoAtual(String entrada, String mensagemErro) {
        String[] args = {entrada};
        Exception exception = assertThrows(ValidacaoException.class, () -> App.calcularIdades(args, factory));

        assertEquals(mensagemErro, exception.getMessage());
    }

    @Test
    public void deveExecutarMainSemErros() {
        String[] args = {"Jose:1990"};
        assertDoesNotThrow(() -> App.main(args));
    }

}
