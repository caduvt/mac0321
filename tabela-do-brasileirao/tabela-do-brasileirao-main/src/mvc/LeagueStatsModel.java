package src.mvc;

import java.util.Collection;

public interface LeagueStatsModel {
    void addResult(String team1, int goals1, String team2, int goals2);

    public Collection<TeamStats> getResults();

    public TeamStats[] getSortedResults();

    void populate();
}
