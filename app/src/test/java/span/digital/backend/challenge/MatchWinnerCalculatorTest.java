package span.digital.backend.challenge;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;


public class MatchWinnerCalculatorTest {
    
    
    @Test
    public void testGetWinningTeam_winnerExists() {
        
        //Given
        Team team1 = new Team("Test team 1", 5);
        Team team2 = new Team("Test team 2", 3);
        Set<Team> match = Stream.of(team1, team2).collect(Collectors.toSet());
        
        //When
        Team winner = MatchWinnerCalculator.getWinningTeam(match);
        
        //Then
        assertEquals(team1, winner);
    }
    
    @Test
    public void testGetWinningTeam_draw() {
        //Given
        Team team1 = new Team("Test team 1", 3);
        Team team2 = new Team("Test team 2", 3);
        Set<Team> match = Stream.of(team1, team2).collect(Collectors.toSet());
        
        //When
        Team winner = MatchWinnerCalculator.getWinningTeam(match);
        
        //Then
        assertNull(winner);
    }
}