package com.veterinaria.microsservicos.autenticacao.domain.usuario;

import com.veterinaria.microsservicos.autenticacao.domain.endereco.Endereco;
import com.veterinaria.microsservicos.autenticacao.shared.utils.StringUtil;

import java.time.LocalDate;
import java.time.Period;

public class Usuario {

    private String cpf;
    private String nome;
    private String sobrenome;
    private LocalDate dataNascimento;
    private Endereco endereco;

    public Usuario(String cpf, String nome, String sobrenome, LocalDate dataNascimento) {
        if (!StringUtil.verifyByRegex(cpf, "^\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}$")) {
            throw new IllegalArgumentException("O C.P.F. informado não é válido!");
        }
        this.cpf = cpf;
        if (!StringUtil.verifyByRegex(nome, "^[a-zA-Z]{3,}$")) {
            throw new IllegalArgumentException("O nome informado não é válido");
        }
        this.nome = nome;
        if (!StringUtil.verifyByRegex(sobrenome, "^[a-zA-Z]{3,}$")) {
            throw new IllegalArgumentException("O sobrenome informado não é válido");
        }
        this.sobrenome = sobrenome;

        if (dataNascimento == null || Period.between(dataNascimento, LocalDate.now()).getYears() < 14) {
            throw new IllegalArgumentException("A idade mínima permitida é de 14 anos!");
        }
        this.dataNascimento = dataNascimento;
    }

    public String getCpf() {
        return cpf;
    }

    public String getNome() {
        return nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public Endereco getEndereco() {
        return endereco;
    }
}
