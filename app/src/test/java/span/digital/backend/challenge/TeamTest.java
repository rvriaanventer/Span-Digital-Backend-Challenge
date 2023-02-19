package span.digital.backend.challenge;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;


public class TeamTest {
    
    
    @Test
    public void testValueOf_validTeam() {
        
        //Given
        final String NAME = "Lions";
        final int POINTS = 3;
        String teamString = String.format("%s %d", NAME, POINTS);
        
        //When
        Team team = Team.valueOf(teamString);
        
        //Then
        assertEquals(NAME, team.getName());
        assertEquals(POINTS, team.getPoints());
    }
}