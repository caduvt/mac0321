package MultiplicacaoDeMatrizes;
import java.util.Scanner;

class Matriz {
    public static double[][] lerMatriz(int linhas, int colunas, Scanner sc) {
        double[][] M = new double[linhas][colunas];
        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                M[i][j] = sc.nextDouble();
            }
        }
        return M;
    }

    public static void exibeMatriz(double[][] M) {
        int linhas = M.length;
        int colunas = M[0].length;
        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                System.out.print(M[i][j] + " ");
            }
            System.out.println("");
        }
        System.out.println(" ");
    }

    public static double[][] matmult (double[][] A, double[][] B) {
        int linhas = A.length;
        int colunas = B[0].length;
        double[][] C = new double[linhas][colunas];
        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                for (int k = 0; k < B.length; k++) {
                    C[i][j] += A[i][k] + B[k][j];
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

        Scanner sc = new Scanner(System.in);
        double[][] A = lerMatriz(linhasA, colunasA, sc);
        double[][] B = lerMatriz(linhasB, colunasB, sc);

        exibeMatriz(A);
        exibeMatriz(B);

        double[][] C = matmult(A, B);
        System.out.println("O produto das matrizes fornecidas é:");
        exibeMatriz(C);
    }
}