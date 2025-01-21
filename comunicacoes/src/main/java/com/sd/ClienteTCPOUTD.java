package com.sd;

import java.io.OutputStream;
import java.io.PrintStream;

public class ClienteTCPOUTD {
    public static void main(String[] args) {
        String servidor = "localhost"; 
        int porta = 54321; 

        try {
            
            Federacao cbf = new Federacao("CBF", "Brasil");
            Federacao conmebol = new Federacao("CONMEBOL", "América do Sul");

           
            Clube[] clubes = {
                new Clube("Clube A", "Série-A", 15000, cbf),
                new Campeonato("Clube B", "Libertadores", 20000, conmebol, "Libertadores"),
                new Clube("Clube C", "Série-B", 10000, cbf)
            };

            
            System.out.println("Conectando ao servidor " + servidor + " na porta " + porta + "...");

            
            try (OutputStream outputStream = new PrintStream(System.out);
                 ClubesOutputStream clubesOutputStream = new ClubesOutputStream(clubes, outputStream)) {

                clubesOutputStream.enviarClubes();
                System.out.println("Dados enviados para a saída padrão.");
            }
        } catch (Exception e) {
            System.err.println("Erro ao conectar ao servidor: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
