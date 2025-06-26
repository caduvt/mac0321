package Estrategia;

import java.util.ArrayList;
import java.util.Collections;

import Modelos.Viagem;

public class PorPreco implements Estrategia {

  @Override
  public Viagem encontrarViagem(ArrayList<Viagem> v) {
    if (v == null || v.isEmpty()) {
      return null;
    }

    return Collections.min(v, (a, b) -> a.getPreco() - b.getPreco());
  }
  
}
