package Estrategia;

import java.util.ArrayList;
import java.util.Collections;

import Modelos.Viagem;

public class PorAssentos implements Estrategia {

  @Override
  public Viagem encontrarViagem(ArrayList<Viagem> v) {
    if (v == null || v.isEmpty()) {
      return null;
    }

    // Encontra a viagem com a maior diferença entre assentos totais e número
    // de passageiros, ou seja, com mais lugares livres
    return Collections.max(v, (a, b) -> (a.getAssentos() - a.getPassageiros().size()) - (b.getAssentos() - b.getPassageiros().size()));
  }
  
}
