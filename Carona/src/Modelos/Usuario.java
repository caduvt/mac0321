package Modelos;

import Estrategia.Estrategia;

public class Usuario {
  // O enunciado não define quais campos são necessários, por isso há poucos
  String nome;
  int idade;
  Estrategia estrategia;

  public Usuario(String nome, int idade, Estrategia estrategia) {
    this.nome = nome;
    this.idade = idade;
    this.estrategia = estrategia;
  }

  public void setEstrategia(Estrategia estrategia) {
    this.estrategia = estrategia;
  }

  public String getNome() {
    return nome;
  }
}
