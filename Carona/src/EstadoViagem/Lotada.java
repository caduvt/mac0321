package EstadoViagem;

import Modelos.Usuario;
import Modelos.Viagem;

public class Lotada implements EstadoViagem {
  @Override
  public void adicionarPassageiro(Viagem v, Usuario u) {
    throw new Error("A viagem está lotada e não aceita novos passageiros");
  }

  @Override
  public void removerPassageiro(Viagem v, Usuario u) {
    v.getPassageiros().remove(u);
  }

  @Override
  public void cancelar(Viagem v) {
    v.setEstado(new Cancelada());
  }

  @Override
  public void iniciar(Viagem v) {
    v.setEstado(new EmAndamento());
  }

  @Override
  public void concluir(Viagem v) {
    throw new Error("Apenas viagens em andamento podem ser concluídas");
  }

  @Override
  public String toString() {
    return "Lotada";
  }
}
