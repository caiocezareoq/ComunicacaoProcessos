package com.sd;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServidorTCPIN {
    public static void main(String[] args) {
        int porta = 53281;

        try (ServerSocket serverSocket = new ServerSocket(porta)) {
            while (true) {
                
                Socket clienteSocket = serverSocket.accept();
                System.out.println("Cliente conectado: " + clienteSocket.getInetAddress());

                InputStream inputStream = null;
                ClubesInputStream clubesInputStream = null;
                try {
                    
                    inputStream = clienteSocket.getInputStream();
                    clubesInputStream = new ClubesInputStream(inputStream);

                
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
                } catch (IOException e) {
                    System.err.println("Erro ao processar os dados do cliente: " + e.getMessage());
                    e.printStackTrace();
                } finally {
                    
                    try {
                        if (clubesInputStream != null) {
                            clubesInputStream.close();
                        }
                        if (inputStream != null) {
                            inputStream.close();
                        }
                        clienteSocket.close();
                    } catch (IOException e) {
                        System.err.println("Erro ao fechar recursos: " + e.getMessage());
                        e.printStackTrace();
                    }
                }

                System.out.println("Conexão com cliente encerrada.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
