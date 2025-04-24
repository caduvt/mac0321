import polígonos.*;

public class App {
    public static void main(String[] args) {
        // Cria triângulo isóceles
        Triângulo isoceles = new Triângulo(3, 4);
        System.out.println("Área do isóceles: " + isoceles.calculaÁrea());
        System.out.println("Perímetro do isóceles: " + isoceles.calculaPerímetro());
      
    }
}
