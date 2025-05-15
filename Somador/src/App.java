

public class App {
    public static void main(String[] args) {
        Somador somador = new Somador();
        
        try {
            somador.readFile(args[0]);
            System.out.println("Arquivo aberto com sucesso!");
        } catch (Exception e) {
            System.out.println("Nenhum arquivo de entrada foi fornecido.");
            return;
        }

        if (args.length < 2) {
            somador.setOutputFile("");
        } else {
            somador.setOutputFile(args[1]);
        }

        somador.somar();
        somador.imprimir();
    }
}
