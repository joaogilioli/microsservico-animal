package com.veterinaria.microsservicos.autenticacao.domain.conta;

import com.veterinaria.microsservicos.autenticacao.shared.utils.StringUtil;

public class Conta {

    private String username;
    private String email;
    private String senha;
    private Status status;

    public Conta(String username, String email, String senha, Status status) {
        if (!StringUtil.verifyByRegex(username, "^(?!.*[._]{2})[a-zA-Z0-9](?:[a-zA-Z0-9._]{3,22}[a-zA-Z0-9])?$")) {
            throw new IllegalArgumentException("O username informado não é válido");
        }
        this.username = username;
        if (!StringUtil.verifyByRegex(email, "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,63}$")) {
            throw new IllegalArgumentException("O e-mail informado não é válido");
        }
        this.email = email;
        if (!StringUtil.verifyByRegex(senha,  "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$")) {
            throw new IllegalArgumentException("A senha informado não é válido");
        }
        this.senha = senha;
        if (status == null) {
            throw new IllegalArgumentException("O status informado não é válido");
        }
        this.status = status;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }

    public Status getStatus() {
        return status;
    }
}
