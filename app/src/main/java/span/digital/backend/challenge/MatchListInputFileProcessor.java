package span.digital.backend.challenge;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.stream.Collectors;


public class MatchListInputFileProcessor {
    
    public static List<Set<Team>> getMatchList(File file) {
        List<Set<Team>> matchList;
        try (Scanner fileScanner = new Scanner(file)) {
            matchList = new ArrayList<>();
            while (fileScanner.hasNextLine()) {
                addTeamsToMatchList(fileScanner, matchList);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e.getMessage());
        }
        
        return matchList;
    }
    
    protected static void addTeamsToMatchList(Scanner fileScanner, List<Set<Team>> matchList) {
        Validator.assertFileHasLines(fileScanner);
        String line = fileScanner.nextLine();
        String[] teamArray = line.split(",");
        Validator.assertTeams(teamArray, line);
        
        Set<Team> match = Arrays.stream(teamArray)
                .map(teamString -> {
                    String teamStringTrimmed = teamString.trim();
                    validateTeam(teamStringTrimmed.trim());
                    return Team.valueOf(teamStringTrimmed);
                })
                .collect(Collectors.toSet());
        matchList.add(match);
    }
    
    private static void validateTeam(String teamString) {
        Validator.assertStringHasSpace(teamString);
        Validator.assertStringHasPoints(teamString);
    }
}
