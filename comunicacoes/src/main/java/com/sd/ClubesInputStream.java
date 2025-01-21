package com.sd;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class ClubesInputStream extends InputStream{
    private InputStream inputStream;
    private BufferedReader reader;
    
    // Construtor que recebe a origem dos dados
    public ClubesInputStream(InputStream inputStream) {
        this.inputStream = inputStream;
        this.reader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
    }

    @Override
    public int read() throws IOException {
        return inputStream.read();
    }

    // Método para ler os dados dos clubes
    public Clube[] lerClubes() throws IOException {
        // Leitura dos dados
        String linha;
        Clube[] clubes = new Clube[3]; // Vamos limitar a leitura a 3 clubes para este exemplo
        int i = 0;
        
        while ((linha = reader.readLine()) != null && i < clubes.length) {
            // Aqui você deve implementar a lógica de parsing das linhas para criar os objetos Clube
            String[] partes = linha.split(",");
            if (partes.length >= 4) {
                String nome = partes[0].trim();
                String campeonato = partes[1].trim();
                int numeroSocios = Integer.parseInt(partes[2].trim());
                Federacao federacao = new Federacao(partes[3].trim(), "Desconhecida");

                clubes[i] = new Clube(nome, campeonato, numeroSocios, federacao);
                i++;
            }
        }
        return clubes;
    }
}
