import polígonos.*;

public class App {
    public static void main(String[] args) {
        // Cria triângulo isóceles
        TriânguloIsóceles isoceles = new TriânguloIsóceles(3, 4, "marrom");
        System.out.println("Área do isóceles: " + isoceles.calculaÁrea());
        System.out.println("Perímetro do isóceles: " + isoceles.calculaPerímetro());
      
        // Cria triângulo equilátero
        TriânguloEquilátero equilatero = new TriânguloEquilátero(2, "azul");
        System.out.println("Área do equilátero: " + equilatero.calculaÁrea());
        System.out.println("Perímetro do equilátero: " + equilatero.calculaPerímetro());
    }
}
