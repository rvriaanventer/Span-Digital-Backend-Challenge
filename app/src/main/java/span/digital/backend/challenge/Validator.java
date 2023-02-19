package span.digital.backend.challenge;

import java.util.Scanner;


public class Validator {
    
    public static void assertFileHasLines(Scanner fileScanner) {
        if (!fileScanner.hasNextLine()) {
            throw new IllegalArgumentException("The given file has no lines");
        }
    }
    
    public static void assertTeams(String[] teamArray, String line) {
        if (teamArray.length < 2) {
            throw new IllegalArgumentException("A match must contain more two or more teams: " + line);
        }
    }
    
    public static void assertStringHasSpace(String teamString) {
        int lastSpaceIndex = teamString.lastIndexOf(' ');
        if (lastSpaceIndex == -1) {
            throw new IllegalArgumentException("Team string must contain a space: " + teamString);
        }
    }
    
    public static void assertStringHasPoints(String teamString) {
        try {
            int lastSpaceIndex = teamString.lastIndexOf(' ');
            Integer.parseInt(teamString.substring(lastSpaceIndex + 1));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Team string must contain a points number: " + teamString);
        }
    }
}
