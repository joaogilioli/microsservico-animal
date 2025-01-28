package com.veterinaria.microsservicos.autenticacao.domain.medico;

import com.veterinaria.microsservicos.autenticacao.shared.utils.StringUtil;

public class Medico {

    private String crm;
    private String cpf;
    private Especialidade especialidade;

    public Medico(String crm, String cpf, Especialidade especialidade) {
        if (!StringUtil.verifyByRegex(crm, "^\\d{4,6}-[A-Z]{2}$")) {
            throw new IllegalArgumentException("O C.R.M. informado não é válido!");
        }
        this.crm = crm;
        if (!StringUtil.verifyByRegex(cpf, "^\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}$")) {
            throw new IllegalArgumentException("O C.P.F. informado não é válido!");
        }
        this.cpf = cpf;
        if (especialidade == null) {
            throw new IllegalArgumentException("Não foi informada uma especialidade");
        }
        this.especialidade = especialidade;
    }

    public String getCrm() {
        return crm;
    }

    public String getCpf() {
        return cpf;
    }

    public Especialidade getEspecialidade() {
        return especialidade;
    }
}
