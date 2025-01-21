package com.sd;

class Federacao {
    private String nome;
    private String pais;

    public Federacao(String nome, String pais) {
        this.nome = nome;
        this.pais = pais;
    }

    public String getNome() {
        return nome;
    }

    public String getPais() {
        return pais;
    }
}