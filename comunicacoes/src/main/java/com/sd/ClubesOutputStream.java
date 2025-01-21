package com.sd;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;

public class ClubesOutputStream implements AutoCloseable {
    private Clube[] clubes;
    private BufferedWriter writer;

    // Construtor que recebe o array de clubes e o OutputStream
    public ClubesOutputStream(Clube[] clubes, OutputStream outputStream) {
        this.clubes = clubes;
        // Inicializando o BufferedWriter para escrita de texto
        this.writer = new BufferedWriter(new OutputStreamWriter(outputStream, StandardCharsets.UTF_8));
    }

    // Método para enviar os dados dos clubes
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

        writer.flush(); // Certifique-se de que os dados sejam enviados
    }

    @Override
    public void close() {
        try {
            // Fechar o BufferedWriter
            if (writer != null) {
                writer.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
