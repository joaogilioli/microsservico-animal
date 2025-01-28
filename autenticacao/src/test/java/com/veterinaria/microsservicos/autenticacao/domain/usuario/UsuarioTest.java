package com.veterinaria.microsservicos.autenticacao.domain.usuario;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class UsuarioTest {

    @Test
    void testaVerificacaoDoCpfInformado() {
        assertDoesNotThrow(() -> new Usuario("123.456.789-00", "Teste", "Teste", LocalDate.parse("2000-01-01")));
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new Usuario("12345678900", "Teste", "Teste", LocalDate.parse("2000-01-01")));
        assertEquals("O C.P.F. informado não é válido!", exception.getMessage());
        assertThrows(IllegalArgumentException.class, () -> new Usuario("123.456.789.00", "Teste", "Teste", LocalDate.parse("2000-01-01")));
        assertThrows(IllegalArgumentException.class, () -> new Usuario("123-456-789.00", "Teste", "Teste", LocalDate.parse("2000-01-01")));
    }

    @Test
    void testaVerificacaoDoNomeInformado() {
        assertDoesNotThrow(() -> new Usuario("123.456.789-00", "Teste", "Teste", LocalDate.parse("2000-01-01")));
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new Usuario("123.456.789-00", "T", "Teste", LocalDate.parse("2000-01-01")));
        assertEquals("O nome informado não é válido", exception.getMessage());
        assertThrows(IllegalArgumentException.class, () -> new Usuario("123.456.789-00", "T3s", "Teste", LocalDate.parse("2000-01-01")));
        assertThrows(IllegalArgumentException.class, () -> new Usuario("123.456.789-00", "Teste1", "Teste", LocalDate.parse("2000-01-01")));
    }

    @Test
    void testaVerificacaoDoSobrenomeInformado() {
        assertDoesNotThrow(() -> new Usuario("123.456.789-00", "Teste", "Teste", LocalDate.parse("2000-01-01")));
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new Usuario("123.456.789-00", "Teste", "teste1", LocalDate.parse("2000-01-01")));
        assertEquals("O sobrenome informado não é válido", exception.getMessage());
        assertThrows(IllegalArgumentException.class, () -> new Usuario("123.456.789-00", "Teste", "Te1", LocalDate.parse("2000-01-01")));
        assertThrows(IllegalArgumentException.class, () -> new Usuario("123.456.789-00", "Teste", "TESTE$", LocalDate.parse("2000-01-01")));
    }

    @Test
    void testaVerificacaoDaDataDeNascimentoInformado() {
        assertDoesNotThrow(() -> new Usuario("123.456.789-00", "Teste", "Teste", LocalDate.now().minusYears(14)));
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new Usuario("123.456.789-00", "Teste", "Teste", LocalDate.now().minusYears(13)));
        assertEquals("A idade mínima permitida é de 14 anos!", exception.getMessage());
        assertThrows(IllegalArgumentException.class, () -> new Usuario("123.456.789-00", "Teste", "Teste", LocalDate.now().minusYears(10)));
        assertThrows(IllegalArgumentException.class, () -> new Usuario("123.456.789-00", "Teste", "Teste", null));
    }

}