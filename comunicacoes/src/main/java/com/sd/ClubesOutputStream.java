package com.sd;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;

public class ClubesOutputStream implements AutoCloseable {
    private Clube[] clubes;
    private BufferedWriter writer;

    
    public ClubesOutputStream(Clube[] clubes, OutputStream outputStream) {
        this.clubes = clubes;
        
        this.writer = new BufferedWriter(new OutputStreamWriter(outputStream, StandardCharsets.UTF_8));
    }

   
    public void enviarClubes() throws IOException {
        writer.write("Número de clubes: " + clubes.length);
        writer.newLine();

        for (Clube clube : clubes) {
            writer.write("Nome do clube: " + clube.getNome());
            writer.newLine();
            writer.write("Campeonato: " + clube.getCampeonato());
            writer.newLine();
            writer.write("Número de sócios: " + clube.getNumeroSocios());
            writer.newLine();
            writer.write("Federação: " + clube.getFederacao().getNome());
            writer.newLine();
            writer.newLine();
        }

        writer.flush();
    }

    @Override
    public void close() {
        try {
            
            if (writer != null) {
                writer.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
