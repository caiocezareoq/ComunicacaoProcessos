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
               
                Socket clienteSocket = serverSocket.accept();
                System.out.println("Cliente conectado: " + clienteSocket.getInetAddress());

                
                try (DataInputStream inputStream = new DataInputStream(clienteSocket.getInputStream())) {
                    
                    int numeroClubes = inputStream.readInt();
                    System.out.println("Número de clubes: " + numeroClubes);

                    
                    for (int i = 0; i < numeroClubes; i++) {
                        String clube = inputStream.readUTF();
                        System.out.println("Clube " + (i + 1) + ": " + clube);
                    }
                } catch (IOException e) {
                    System.err.println("Erro ao ler dados do cliente: " + e.getMessage());
                    e.printStackTrace();
                } finally {
                    
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
