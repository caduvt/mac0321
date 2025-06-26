package EstadoViagem;

import Modelos.Usuario;
import Modelos.Viagem;

public class Concluida implements EstadoViagem {

  @Override
  public void adicionarPassageiro(Viagem v, Usuario u) {
    throw new Error("Apenas viagens aceitando passageiros podem receber novos passageiros");
  }

  @Override
  public void removerPassageiro(Viagem v, Usuario u) {
    throw new Error("Apenas viagens aceitando passageiros podem remover passageiros");
  }

  @Override
  public void cancelar(Viagem v) {
    throw new Error("Apenas viagens aceitando passageiros podem ser canceladas");
  }

  @Override
  public void iniciar(Viagem v) {
    throw new Error("A viagem foi concluída e não pode mais ser iniciada");
  }

  @Override
  public void concluir(Viagem v) {
    throw new Error("Apenas viagens em andamento podem ser concluídas");
  }

  @Override
  public String toString() {
    return "Concluída";
  }
}
