/**
 * Interface de conversores no geral (seja temperatura ou distâncias).
 * Aqui, está sendo usado uma única interface tanto para temperaturas
 * quanto para distâncias, dado que ambos os inputs são números.
 * Provavelmente valeria a pena usar interfaces distintas caso os objetos
 * fossem mais diferentes.
 */
public interface Conversor {
    public double converte(double valor);
} 
