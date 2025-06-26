package Estrategia;

import java.util.ArrayList;

import Modelos.Viagem;

public interface Estrategia {
  Viagem encontrarViagem(ArrayList<Viagem> v);
}
