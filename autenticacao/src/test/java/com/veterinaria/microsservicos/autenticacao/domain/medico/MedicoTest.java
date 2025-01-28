package com.veterinaria.microsservicos.autenticacao.domain.medico;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MedicoTest {

    @Test
    void testaVerificacaoDoCrmInformado() {
        assertDoesNotThrow(() -> new Medico("123456-PR", "123.456.789-00", Especialidade.CLINICA_GERAL));
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new Medico("123456-00", "123.456.789-00", Especialidade.CLINICA_GERAL));
        assertEquals("O C.R.M. informado não é válido!", exception.getMessage());
        assertThrows(IllegalArgumentException.class, () -> new Medico("123456PR", "123.456.789-00", Especialidade.CLINICA_GERAL));
        assertThrows(IllegalArgumentException.class, () -> new Medico("123-PR", "123.456.789-00", Especialidade.CLINICA_GERAL));
    }

    @Test
    void testaVerificacaoDoCpfInformado() {
        assertDoesNotThrow(() -> new Medico("123456-PR", "123.456.789-00", Especialidade.CLINICA_GERAL));
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new Medico("123456-PR", "12345678900", Especialidade.CLINICA_GERAL));
        assertEquals("O C.P.F. informado não é válido!", exception.getMessage());
        assertThrows(IllegalArgumentException.class, () -> new Medico("123456-PR", "123456789-00", Especialidade.CLINICA_GERAL));
        assertThrows(IllegalArgumentException.class, () -> new Medico("123456-PR-PR", "123-456-789-00", Especialidade.CLINICA_GERAL));
    }

    @Test
    void testaVerificacaoDaEspecialidadeInformado() {
        assertDoesNotThrow(() -> new Medico("123456-PR", "123.456.789-00", Especialidade.CLINICA_GERAL));
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new Medico("123456-PR", "123.456.789-00", null));
        assertEquals("Não foi informada uma especialidade", exception.getMessage());
    }

}