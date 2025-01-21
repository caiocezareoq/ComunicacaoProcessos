package com.sd;

class Campeonato extends Clube {
    private String tipoCampeonato;

    public Campeonato(String nome, String campeonato, int numeroSocios, Federacao federacao, String tipoCampeonato) {
        super(nome, campeonato, numeroSocios,federacao);
        this.tipoCampeonato = tipoCampeonato;
    }

    public String getTipoCampeonato() {
        return tipoCampeonato;
    }
}