package com.veterinaria.microsservicos.autenticacao.shared.utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringUtilTest {

    @Test
    void testaVerificacaoPeloRegex() {
        assertFalse(StringUtil.verifyByRegex(null, null));
        assertFalse(StringUtil.verifyByRegex("", null));
        assertFalse(StringUtil.verifyByRegex("TESTE", null));
        assertFalse(StringUtil.verifyByRegex("TESTE", "^\\d{1}$"));
        assertFalse(StringUtil.verifyByRegex(null, "^\\d{1}$"));
        assertTrue(StringUtil.verifyByRegex("1", "^\\d{1}$"));
    }

}