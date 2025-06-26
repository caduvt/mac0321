package EstadoViagem;

import Modelos.Usuario;
import Modelos.Viagem;

public interface EstadoViagem {
  void adicionarPassageiro(Viagem v, Usuario u);
  void removerPassageiro(Viagem v, Usuario u);
  void cancelar(Viagem v);
  void iniciar(Viagem v);
  void concluir(Viagem v);
}
