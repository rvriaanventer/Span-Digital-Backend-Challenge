package span.digital.backend.challenge;

import static span.digital.backend.challenge.MatchOutcome.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;


public class LeagueGenerator {
    
    public static Map<String, Integer> generateLeague(List<Set<Team>> matchList) {
        
        Map<String, Integer> league = new HashMap<>();
        
        matchList.forEach(match -> {
            Team winningTeam = MatchWinnerCalculator.getWinningTeam(match);
            if (winningTeam != null) {
                addWinnerToLeague(winningTeam, league);
                addLosersToLeague(winningTeam, match, league);
            } else {
                addDrawsToLeague(match, league);
            }
        });
        
        return league;
    }
    
    protected static void addWinnerToLeague(
            Team winningTeam,
            Map<String, Integer> league) {
        league.merge(winningTeam.getName(), WIN.getPoints(), Integer::sum);
    }
    
    protected static void addLosersToLeague(
            Team winner,
            Set<Team> match,
            Map<String, Integer> league) {
        
        match.stream()
                .filter(team -> team != winner)
                .forEach(team -> league.merge(team.getName(), LOSE.getPoints(), Integer::sum));
    }
    
    protected static void addDrawsToLeague(Set<Team> match, Map<String, Integer> league) {
        match.forEach(team -> league.merge(team.getName(), DRAW.getPoints(), Integer::sum));
    }
    
}
