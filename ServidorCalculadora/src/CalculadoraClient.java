import java.io.*;
import java.net.*;

public class CalculadoraClient {
    public static void main(String[] args) throws IOException {
        if (args.length != 2) {
            System.err.println("Usage: java CalculadoraClient <host name> <port number>");
            System.exit(1);
        }

        String hostName = args[0];
        int portNumber = Integer.parseInt(args[1]);

        try (
            Socket socket = new Socket(hostName, portNumber);
            BufferedReader in = new BufferedReader(
                new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader stdIn = new BufferedReader(
                new InputStreamReader(System.in));
        ) {
            System.out.println("Conectado ao servidor de cálculo.");
            String num1, num2;

            do {
                System.out.print("Digite o primeiro número: ");
                num1 = stdIn.readLine();
    
                System.out.print("Digite o segundo número: ");
                num2 = stdIn.readLine();
                
                out.println(num1);
                out.println(num2);
                
                String resultado = in.readLine();
                System.out.println("Resultado da soma: " + resultado);
                System.out.println("");
            } while (num1 != null && num2 != null);
        } catch (UnknownHostException e) {
            System.err.println("Não conheço o host " + hostName);
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Erro de I/O ao conectar com " + hostName);
            System.exit(1);
        }
    }
}
