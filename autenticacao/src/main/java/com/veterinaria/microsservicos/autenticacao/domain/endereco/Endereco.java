package com.veterinaria.microsservicos.autenticacao.domain.endereco;

public class Endereco {

    private String cep;
    private String pais;
    private String estado;
    private String municipio;
    private String bairro;
    private String rua;
    private String numero;
    private String complemento;

    public String getCep() {
        return cep;
    }

    public String getPais() {
        return pais;
    }

    public String getEstado() {
        return estado;
    }

    public String getMunicipio() {
        return municipio;
    }

    public String getBairro() {
        return bairro;
    }

    public String getRua() {
        return rua;
    }

    public String getNumero() {
        return numero;
    }

    public String getComplemento() {
        return complemento;
    }
}
