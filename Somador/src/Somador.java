import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Somador {
    ArrayList<Integer> somas;
    ArrayList<Integer> numeros;
    PrintWriter out;
    Scanner src;

    public Somador() {
        somas = new ArrayList<>();
        numeros = new ArrayList<>();
        out = null;
        src = null;
    }

    public void readFile(String file) {
        try {
            src = new Scanner(new FileReader(file));
            while (src.hasNextLine()) {
                String data = (src.nextLine());
                numeros.add(Integer.valueOf(data));
            }
            src.close();
            if (numeros.size() % 2 == 1) numeros.add(0);
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo de entrada não encontrado.");
        }
    }

    public void somar() {
        int k = 0;
        while (k < numeros.size()) {
            somas.add(numeros.get(k++) + numeros.get(k++));
        }
    }

    public void setOutputFile(String file) {
        try {
            out = new PrintWriter(new FileWriter(file));
        } catch (IOException e) {
            System.out.println("Impossível criar arquivo de saída. Usaremos o terminal no lugar.");
            out = new PrintWriter(System.out);
        }
    }

    public void imprimir() {
        try {
            for (Integer soma : somas) {
                out.println(soma);
            }
            out.close();
        } catch (Exception e) {
            for (Integer soma : somas) {
                System.out.println(soma);
            }
        }
    }
}