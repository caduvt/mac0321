package EstadoViagem;

import Modelos.Usuario;
import Modelos.Viagem;

public class EmAndamento implements EstadoViagem {

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
    throw new Error("A viagem já está em andamento!");
  }

  @Override
  public void concluir(Viagem v) {
    v.setEstado(new Concluida());
    // lógica de cobrar pagamentos dos passageiros
  }

  @Override
  public String toString() {
    return "Em Andamento";
  }  
}
