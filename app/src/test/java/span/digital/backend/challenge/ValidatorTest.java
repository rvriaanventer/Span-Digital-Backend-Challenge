package span.digital.backend.challenge;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;


public class ValidatorTest {
    
    @Test
    public void testAssertTeams_lessThanTwoTeams() {
        
        //Given
        final String TEAM_STRING = "team 1";
        String[] teamArray = {};
        
        //When
        Exception exception =
                assertThrows(IllegalArgumentException.class, () -> Validator.assertTeams(teamArray, TEAM_STRING));
        
        //Then
        assertEquals("A match must contain more two or more teams: " + TEAM_STRING, exception.getMessage());
    }
    
    @Test
    public void testAssertStringHasSpace_noSpace() {
        
        //Given
        final String TEAM_STRING = "team1";
        
        //When
        Exception exception =
                assertThrows(IllegalArgumentException.class, () -> Validator.assertStringHasSpace(TEAM_STRING));
        
        //Then
        assertEquals("Team string must contain a space: " + TEAM_STRING, exception.getMessage());
    }
    
    @Test
    public void testAssertStringHasSpace_noPoints() {
        
        //Given
        final String TEAM_STRING = "team awesome";
        
        //When
        Exception exception =
                assertThrows(IllegalArgumentException.class, () -> Validator.assertStringHasPoints(TEAM_STRING));
        
        //Then
        assertEquals("Team string must contain a points number: " + TEAM_STRING, exception.getMessage());
    }
    
}