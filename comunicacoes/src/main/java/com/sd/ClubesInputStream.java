package com.sd;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class ClubesInputStream extends InputStream {
    private InputStream inputStream;
    private BufferedReader reader;

    public ClubesInputStream(InputStream inputStream) {
        this.inputStream = inputStream;
        this.reader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
    }

    @Override
    public int read() throws IOException {
        return inputStream.read();
    }

    public Clube[] lerClubes() throws IOException {
        String linha;
        Clube[] clubes = new Clube[3];
        int i = 0;

        while ((linha = reader.readLine()) != null && i < clubes.length) {
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

    public void close() throws IOException {
        // Fechar recursos manualmente
        if (reader != null) {
            reader.close();
        }
        if (inputStream != null) {
            inputStream.close();
        }
    }
}
