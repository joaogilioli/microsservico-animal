package com.veterinaria.microsservicos.autenticacao.shared.utils;

public class StringUtil {

    private StringUtil() { super(); }

    public static boolean verifyByRegex(String value, String regex) {
        return !(value == null || value.isBlank() || regex == null || !value.matches(regex));
    }
}
