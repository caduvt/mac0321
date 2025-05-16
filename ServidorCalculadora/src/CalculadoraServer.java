import java.io.*;
import java.net.*;

public class CalculadoraServer {
    public static void main(String[] args) throws IOException {
        if (args.length != 1) {
            System.err.println("Usage: java CalculadoraServer <port number>");
            System.exit(1);
        }

        int portNumber = Integer.parseInt(args[0]);
        System.out.println("Servidor de cálculo iniciado na porta " + portNumber);

        try (
            ServerSocket serverSocket = new ServerSocket(portNumber);
        ) {
            while (true) {
                try (
                    Socket clientSocket = serverSocket.accept();
                    BufferedReader in = new BufferedReader(
                        new InputStreamReader(clientSocket.getInputStream()));
                    PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                ) {
                    System.out.println("Cliente conectado.");
                    String num1Str = null, num2Str = null;
                    
                    do {
                        try {
                            num1Str = in.readLine();
                            num2Str = in.readLine();
                            int num1 = Integer.parseInt(num1Str);
                            int num2 = Integer.parseInt(num2Str);
                            int soma = num1 + num2;
                            out.println(String.valueOf(soma));
                        } catch (NumberFormatException e) {
                            out.println("Erro: entrada inválida.");
                        }
    
                        System.out.println("Cálculo realizado e enviado ao cliente.");
                    } while(num1Str != null && num2Str != null);
                    
                } catch (IOException e) {
                    System.err.println("Erro ao lidar com cliente: " + e.getMessage());
                }
            }
        } catch (IOException e) {
            System.err.println("Erro ao iniciar o servidor: " + e.getMessage());
        }
    }
}
