package com.sd;

class Clube {
    private String nome;
    private String campeonato;
    private int numeroSocios;
    private Federacao federacao; 

    public Clube(String nome, String campeonato, int numeroSocios, Federacao federacao) {
        this.nome = nome;
        this.campeonato = campeonato;
        this.numeroSocios = numeroSocios;
        this.federacao = federacao;
    }

    public String getNome() {
        return nome;
    }

    public String getCampeonato() {
        return campeonato;
    }

    public int getNumeroSocios() {
        return numeroSocios;
    }

    public Federacao getFederacao() {
        return federacao;
    }
}