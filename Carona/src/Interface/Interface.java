package Interface;

import java.util.ArrayList;
import java.util.List;

import EstadoViagem.AceitandoPassageiros;
import Modelos.Usuario;
import Modelos.Viagem;

public class Interface {
  private static Interface instancia;
  private ArrayList<Usuario> usuarios;
  private ArrayList<Viagem> viagens;

  private Interface() {}

  public Interface getInstancia() {
    if (instancia == null) {
      instancia = new Interface();
    }
    return instancia;
  }

  public void cadastrarUsuario(Usuario u) {
    usuarios.add(u);
  }

  public void cadastrarViagem(Viagem v) {
    viagens.add(v);
  }

  // Lista apenas as viagens com partida e saída correspondentes ao input,
  // e que estão aceitando passageiros
  public List<Viagem> filtrarViagens(String destino, String partida) {
    return viagens.stream().filter(v -> v.getPartida().equals(partida) && v.getDestino().equals(destino))
            .filter(v -> v.getEstado() instanceof AceitandoPassageiros)
            .toList();
  }

  public void imprimirMenu() {
    System.out.println("CENTRAL DE CARONAS");
    System.out.println("=====");
    System.out.println("1. Registrar carona como motorista");
    System.out.println("2. Buscar carona como passageiro");
  }
}
