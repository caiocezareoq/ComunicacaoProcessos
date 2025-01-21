package com.sd;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServidorTCPOUT {
    public static void main(String[] args) {
        int porta = 54321;

        try (ServerSocket serverSocket = new ServerSocket(porta)) {
            System.out.println("Servidor escutando na porta " + porta + "...");

            while (true) {
                // Aceitar uma conexão do cliente
                Socket clienteSocket = serverSocket.accept();
                System.out.println("Cliente conectado: " + clienteSocket.getInetAddress());

                // Ler os dados enviados pelo cliente
                try (DataInputStream inputStream = new DataInputStream(clienteSocket.getInputStream())) {
                    // Ler o número de clubes
                    int numeroClubes = inputStream.readInt();
                    System.out.println("Número de clubes: " + numeroClubes);

                    // Ler os nomes dos clubes
                    for (int i = 0; i < numeroClubes; i++) {
                        String clube = inputStream.readUTF();
                        System.out.println("Clube " + (i + 1) + ": " + clube);
                    }
                } catch (IOException e) {
                    System.err.println("Erro ao ler dados do cliente: " + e.getMessage());
                    e.printStackTrace();
                } finally {
                    // Fechar a conexão com o cliente
                    clienteSocket.close();
                    System.out.println("Conexão com o cliente encerrada.");
                }
            }
        } catch (IOException e) {
            System.err.println("Erro ao iniciar o servidor: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
