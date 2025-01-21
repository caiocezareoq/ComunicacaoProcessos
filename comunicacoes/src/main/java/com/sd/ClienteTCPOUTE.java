package com.sd;

import java.io.FileOutputStream;
import java.io.OutputStream;

public class ClienteTCPOUTE {
    public static void main(String[] args) {
        String servidor = "localhost"; // Substitua pelo IP/hostname do servidor remoto, se necessário.
        int porta = 54321; // Porta válida onde o servidor está escutando.

        try {
            // Criar federações
            Federacao cbf = new Federacao("CBF", "Brasil");
            Federacao conmebol = new Federacao("CONMEBOL", "América do Sul");

            // Criar clubes para o teste
            Clube[] clubes = {
                new Clube("Clube A", "Série-A", 15000, cbf),
                new Campeonato("Clube B", "Libertadores", 20000, conmebol, "Libertadores"),
                new Clube("Clube C", "Série-B", 10000, cbf)
            };

            // Conectar ao servidor
            System.out.println("Conectando ao servidor " + servidor + " na porta " + porta + "...");

            // Gravar os dados no arquivo
            try (OutputStream outputStream = new FileOutputStream("clubes.dat");
                 ClubesOutputStream clubesOutputStream = new ClubesOutputStream(clubes, outputStream)) {

                clubesOutputStream.enviarClubes();
                System.out.println("Dados gravados no arquivo 'clubes.dat'.");
            }
        } catch (Exception e) {
            System.err.println("Erro ao conectar ao servidor: " + e.getMessage());
            e.printStackTrace();
        }
    }
}