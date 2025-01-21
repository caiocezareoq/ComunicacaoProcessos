package com.sd;

public class SocioTorcedor extends Clube{
    private String tipo;

    public SocioTorcedor(String nome, String campeonato, int numeroSocios, Federacao federacao, String tipo) {
        super(nome, campeonato, numeroSocios, federacao);
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }
}
