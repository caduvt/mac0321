package src.mvc;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

public class Ordenador {
    Ordenador instance;

    // Ordena os times de acordo com sua pontuação
    // Desempata com base em saldo de gols
    // e retorna na forma de um array
    public static TeamStats[] sortTeams(HashMap<String, TeamStats> teams) {
        TeamStats[] sortedTeams = teams.values().toArray(new TeamStats[0]);
        Arrays.sort(sortedTeams, comparador);
        return sortedTeams;
    }

    static Comparator<TeamStats> comparador = new Comparator<TeamStats>() {
        public int compare(TeamStats t1, TeamStats t2) {
            int aux = Integer.compare(t2.getScore(), t1.getScore());
            if (aux == 0) {
                return Integer.compare(t2.getGoalsDifference(), t1.getGoalsDifference());
            }
            return aux;
        }
    };
}
