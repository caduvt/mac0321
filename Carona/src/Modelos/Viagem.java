package Modelos;

import java.util.ArrayList;

import EstadoViagem.AceitandoPassageiros;
import EstadoViagem.EstadoViagem;

public class Viagem {
  private Usuario motorista;
  private ArrayList<Usuario> passageiros = new ArrayList<>();
  private String partida;
  private String destino;
  private int assentos;
  private int preco;
  private EstadoViagem estado;

  public Viagem(Usuario motorista, String partida, String destino, int assentos, int preco) {
    this.motorista = motorista;
    this.partida = partida;
    this.destino = destino;
    this.assentos = assentos;
    this.preco = preco;
    this.estado = new AceitandoPassageiros();
  }

  public boolean cheia() {
    return passageiros.size() == assentos;
  }

  public ArrayList<Usuario> getPassageiros() {
    return passageiros;
  }

  public int getPreco() {
    return preco;
  }

  public int getAssentos() {
    return assentos;
  }

  public String getDestino() {
    return destino;
  }

  public String getPartida() {
    return partida;
  }

  public void setEstado(EstadoViagem e) {
    estado = e;
  }

  public EstadoViagem getEstado() {
    return estado;
  }

  public void adicionarPassageiro(Usuario u) {
    estado.adicionarPassageiro(this, u);
  }

  public void iniciar() {
    estado.iniciar(this);
  }

  public void concluir() {
    estado.concluir(this);
  }

  public void cancelar() {
    estado.cancelar(this);
  }

  public void cobrarPassageiros() {
    passageiros.forEach(p -> System.out.println("Cobrando R$" + preco + " de " + p.getNome()));
  }
}
