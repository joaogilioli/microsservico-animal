package com.veterinaria.microsservicos.autenticacao.domain.conta;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContaTest {

    @Test
    void testaVerificacaoDoUsernameInformado() {
        assertDoesNotThrow(() -> new Conta("teste.um", "teste@mail.com", "Teste@123", Status.INATIVO));
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new Conta("teste#um", "teste@mail.com", "Teste@123", Status.INATIVO));
        assertEquals("O username informado não é válido", exception.getMessage());
        assertThrows(IllegalArgumentException.class, () -> new Conta("1234567890123456789012345", "teste@mail.com", "Teste@123", Status.INATIVO));
        assertThrows(IllegalArgumentException.class, () -> new Conta("te", "teste@mail.com", "Teste@123", Status.INATIVO));
    }

    @Test
    void testaVerificacaoDoEmailInformado() {
        assertDoesNotThrow(() -> new Conta("teste.um", "teste@mail.com", "Teste@123", Status.INATIVO));
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new Conta("teste.um", "testemail.com", "Teste@123", Status.INATIVO));
        assertEquals("O e-mail informado não é válido", exception.getMessage());
        assertThrows(IllegalArgumentException.class, () -> new Conta("teste.um", "teste@mail", "Teste@123", Status.INATIVO));
        assertThrows(IllegalArgumentException.class, () -> new Conta("teste.um", "teste@mailcom", "Teste@123", Status.INATIVO));
    }

    @Test
    void testaVerificacaoDoSenhaInformado() {
        assertDoesNotThrow(() -> new Conta("teste.um", "teste@mail.com", "Teste@123", Status.INATIVO));
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new Conta("teste.um", "teste@mail.com", "Teste123", Status.INATIVO));
        assertEquals("A senha informado não é válido", exception.getMessage());
        assertThrows(IllegalArgumentException.class, () -> new Conta("teste.um", "teste@mail.com", "Teste@", Status.INATIVO));
        assertThrows(IllegalArgumentException.class, () -> new Conta("teste.um", "teste@mail.com", "teste@123", Status.INATIVO));
    }

    @Test
    void testaVerificacaoDoStatusInformado() {
        assertDoesNotThrow(() -> new Conta("teste.um", "teste@mail.com", "Teste@123", Status.INATIVO));
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new Conta("teste.um", "teste@mail.com", "Teste@123", null));
        assertEquals("O status informado não é válido", exception.getMessage());
    }

}