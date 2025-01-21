package com.sd;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class ClienteTCPINC {
    public static void main(String[] args) {
        String arquivo = "clubes.txt"; 
        try {
            
            InputStream inputStream = new FileInputStream(arquivo);
            try (ClubesInputStream clubesInputStream = new ClubesInputStream(inputStream)) {
                Clube[] clubes = clubesInputStream.lerClubes();
                
                
                for (Clube clube : clubes) {
                    if (clube != null) {
                        System.out.println("Nome do clube: " + clube.getNome());
                        System.out.println("Campeonato: " + clube.getCampeonato());
                        System.out.println("Número de sócios: " + clube.getNumeroSocios());
                        System.out.println("Federação: " + clube.getFederacao().getNome());
                        System.out.println();
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Erro ao ler os dados do arquivo: " + e.getMessage());
            e.printStackTrace();
        }
    }
}

