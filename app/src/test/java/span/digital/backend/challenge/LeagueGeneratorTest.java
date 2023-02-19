package span.digital.backend.challenge;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;


public class LeagueGeneratorTest {
    
    @Test
    public void testGenerateLeague_expectedLeagueResults() {
        
        //Given
        List<Set<Team>> matchList = generateDummyMatchList();
        
        //When
        Map<String, Integer> league = LeagueGenerator.generateLeague(matchList);
        
        //Then
        assertEquals(league.get("Tarantulas").intValue(), 6);
        assertEquals(league.get("Lions").intValue(), 5);
        assertEquals(league.get("FC Awesome").intValue(), 1);
        assertEquals(league.get("Snakes").intValue(), 1);
        assertEquals(league.get("Grouches").intValue(), 0);
    }
    
    @Test
    public void testAddWinnerToLeague() {
        
        //Given
        final String WINNER_NAME = "Lions";
        final int WINNER_POINTS = 5;
        Team winningTeam = new Team(WINNER_NAME, WINNER_POINTS);
        Map<String, Integer> league = new HashMap<>();
        
        //When
        LeagueGenerator.addWinnerToLeague(winningTeam, league);
        
        //Then
        assertEquals(3, league.get(WINNER_NAME));
    }
    
    @Test
    public void testAddDrawToLeague() {
        
        //Given
        final String TEAM_1_NAME = "Lions";
        final int TEAM_1_POINTS = 5;
        Team team1 = new Team(TEAM_1_NAME, TEAM_1_POINTS);
        
        final String TEAM_2_NAME = "Grouches";
        final int TEAM_2_POINTS = 5;
        Team team2 = new Team(TEAM_2_NAME, TEAM_2_POINTS);
        
        Set<Team> match = Stream.of(team1, team2).collect(Collectors.toSet());
        Map<String, Integer> league = new HashMap<>();
        
        //When
        LeagueGenerator.addDrawsToLeague(match, league);
        
        //Then
        assertEquals(1, league.get(TEAM_1_NAME));
        assertEquals(1, league.get(TEAM_2_NAME));
    }
    
    @Test
    public void testAddLosersToLeague() {
        
        //Given
        final String WINNER_NAME = "Lions";
        final int WINNER_POINTS = 5;
        Team winner = new Team(WINNER_NAME, WINNER_POINTS);
        
        final String LOSER_NAME = "Grouches";
        final int LOSER_POINTS = 5;
        Team loser = new Team(LOSER_NAME, LOSER_POINTS);
        
        Set<Team> match = Stream.of(winner, loser).collect(Collectors.toSet());
        Map<String, Integer> league = new HashMap<>();
        
        //When
        LeagueGenerator.addLosersToLeague(winner, match, league);
        
        //Then
        assertEquals(0, league.get(LOSER_NAME));
    }
    
    public List<Set<Team>> generateDummyMatchList() {
        List<Set<Team>> matchList = new ArrayList<>();
        
        //Match 1
        Team team1 = new Team("Lions", 3);
        Team team2 = new Team("Snakes", 3);
        Set<Team> match1 = Stream.of(team1, team2).collect(Collectors.toSet());
        matchList.add(match1);
        
        //Match 2
        Team team3 = new Team("Tarantulas", 1);
        Team team4 = new Team("FC Awesome", 0);
        Set<Team> match2 = Stream.of(team3, team4).collect(Collectors.toSet());
        matchList.add(match2);
        
        //Match 3
        Team team5 = new Team("Lions", 1);
        Team team6 = new Team("FC Awesome", 1);
        Set<Team> match3 = Stream.of(team5, team6).collect(Collectors.toSet());
        matchList.add(match3);
        
        //Match 4
        Team team7 = new Team("Tarantulas", 3);
        Team team8 = new Team("Snakes", 1);
        Set<Team> match4 = Stream.of(team7, team8).collect(Collectors.toSet());
        matchList.add(match4);
        
        //Match 5
        Team team9 = new Team("Lions", 4);
        Team team10 = new Team("Grouches", 0);
        Set<Team> match5 = Stream.of(team9, team10).collect(Collectors.toSet());
        matchList.add(match5);
        
        return matchList;
    }
}