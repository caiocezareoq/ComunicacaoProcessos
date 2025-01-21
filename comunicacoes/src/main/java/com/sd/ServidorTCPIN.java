package com.sd;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;


public class ServidorTCPIN {
    public static void main(String[] args) {
        int porta = 54321; // Escolha uma porta válida

        try (ServerSocket serverSocket = new ServerSocket(porta)) {
            while (true) {
                // Aceitar uma conexão
                Socket clienteSocket = serverSocket.accept();
                System.out.println("Cliente conectado: " + clienteSocket.getInetAddress());

                // Ler os dados enviados pelo cliente
                try (InputStream inputStream = clienteSocket.getInputStream();
                     ClubesInputStream clubesInputStream = new ClubesInputStream(inputStream)) {
                     
                    Clube[] clubes = clubesInputStream.lerClubes();
                    
                    // Imprimir os dados dos clubes
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
                
                // Fechar a conexão com o cliente
                clienteSocket.close();
                System.out.println("Conexão com cliente encerrada.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
