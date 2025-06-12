package src.mvc;

import java.util.Collection;
import java.util.HashMap;

// Represents the scores of a league

public class LeagueStats implements LeagueStatsModel {

    private HashMap<String, TeamStats> teams = new HashMap<>();
    private HashMap<String, String> abbreviations = new HashMap<>();

    public LeagueStats() {
        abbreviations.put("SAO", "São Paulo");
        abbreviations.put("BOT", "Botafogo");
        abbreviations.put("CEA", "Ceara");
        abbreviations.put("SAN", "Santos");
        abbreviations.put("CRU", "Cruzeiro");
        abbreviations.put("FOR", "Fortaleza");
        abbreviations.put("COR", "Corinthians");
        abbreviations.put("PAL", "Palmeiras");
        abbreviations.put("BAH", "Bahia");
        abbreviations.put("FLU", "Fluminense");
        abbreviations.put("ATL", "Atlético Mineiro");
        abbreviations.put("JUV", "Juventude");
        abbreviations.put("SPT", "Sport");
        abbreviations.put("VIT", "Vitoria");
        abbreviations.put("INT", "Internacional");
        abbreviations.put("VAS", "Vasco");
        abbreviations.put("MIR", "Mirassol");
        abbreviations.put("RED", "Red Bull Bragantino");
        abbreviations.put("FLA", "Flamengo");
        abbreviations.put("GRE", "Grêmio");

    }

    // homeTeam and visitorTeam are team abbreviations
    public void addResult(String homeTeam, int homeGoals, String visitorTeam, int visitorGoals) {

        if (!abbreviations.containsKey(visitorTeam) || !abbreviations.containsKey(homeTeam)) {
            throw new IllegalArgumentException("Uma das abreviações inseridas é inválida!");
        }

        teams.putIfAbsent(homeTeam, new TeamStats(abbreviations.get(homeTeam)));
        teams.putIfAbsent(visitorTeam, new TeamStats(abbreviations.get(visitorTeam)));

        TeamStats teamScore1 = teams.get(homeTeam);
        TeamStats teamScore2 = teams.get(visitorTeam);

        teamScore1.addResult(homeGoals, visitorGoals);
        teamScore2.addResult(visitorGoals, homeGoals);
    }

    public Collection<TeamStats> getResults() {
        return teams.values();
    }

    public TeamStats[] getSortedResults() {
        return Ordenador.sortTeams(teams);
    }

    // Populates model with some fake data.
    // -- good for testing and demo purposes
    public void populate() {

        teams.clear(); // we will wipe out any previous data

        addResult("SAO", 0, "PAL", 2);
        addResult("VIT", 0, "SAN", 0);
        addResult("ATL", 1, "RED", 1);
        addResult("BAH", 2, "CRU", 2);
        addResult("COR", 1, "CEA", 1);
        addResult("BOT", 2, "FOR", 0);
        addResult("SPT", 2, "MIR", 2);
        addResult("INT", 2, "VAS", 1);
        addResult("JUV", 2, "FLU", 2);
        addResult("FLA", 0, "GRE", 3);

        addResult("SAO", 2, "MIR", 1);
        addResult("CRU", 0, "FOR", 1);
        addResult("SAN", 0, "COR", 2);
        addResult("FLU", 1, "ATL", 1);
        addResult("BAH", 1, "PAL", 0);
    }

    // Demo
    public static void main(String[] args) {
        LeagueStats result = new LeagueStats();
        result.populate();
    }

}
