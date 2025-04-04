package MultiplicacaoDeMatrizes;
import java.util.Scanner;

class Matriz {
    static Scanner sc = new Scanner(System.in);
    int linhas, colunas;
    double[][] valores;

    public Matriz(int l, int c) {
        linhas = l;
        colunas = c;
        valores = new double[linhas][colunas];
    }

    public void exibir() {
        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                System.out.print(valores[i][j] + " ");
            }
            System.out.println("");
        }
        System.out.println(" ");
    }

    public void ler() {
        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                valores[i][j] = sc.nextDouble();
            }
        }
    }

    public static Matriz mult (Matriz A, Matriz B) {
        Matriz C = new Matriz(A.linhas, B.colunas);
        for (int i = 0; i < A.linhas; i++) {
            for (int j = 0; j < B.colunas; j++) {
                for (int k = 0; k < B.linhas; k++) {
                    C.valores[i][j] += A.valores[i][k] + B.valores[k][j];
                }
            }
        }
        return C;
    }

    public static void main(String[] args) {
        if (args.length < 4) {
            System.out.println("Use: java Matriz.java qtd-linhas-A qtd-colunas-A qtd-linhas-B qtd-colunas-B");
            return;
        }

        int linhasA = Integer.parseInt(args[0]);
        int colunasA = Integer.parseInt(args[1]);
        int linhasB = Integer.parseInt(args[2]);
        int colunasB = Integer.parseInt(args[3]);

        Matriz A = new Matriz(linhasA, colunasA);
        Matriz B = new Matriz(linhasB, colunasB);

        A.ler();
        B.ler();
        A.exibir();
        B.exibir();

        Matriz C = mult(A, B);
        System.out.println("O produto das matrizes dadas é:");
        C.exibir();
    }
}