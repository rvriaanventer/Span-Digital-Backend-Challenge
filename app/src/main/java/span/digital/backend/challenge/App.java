package span.digital.backend.challenge;

import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;


public class App {
    
    public static void main(String[] args) {
        
        try (Scanner commandLineScanner = new Scanner(System.in)) {
            boolean fileValid = false;
            do {
                System.out.println("Please provide the file path:");
                String filePath = commandLineScanner.nextLine();
                File file = new File(filePath);
                
                if (file.exists()) {
                    fileValid = true;
                    List<Set<Team>> matchList = MatchListInputFileProcessor.getMatchList(file);
                    Map<String, Integer> league = LeagueGenerator.generateLeague(matchList);
                    printSortedLeague(league);
                } else {
                    System.out.println("File does not exist!");
                }
                
            } while (!fileValid);
        }
    }
    
    private static void printSortedLeague(Map<String, Integer> league) {
        league.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .forEach(e -> System.out.printf(
                        "%s, %d %s%n",
                        e.getKey(),
                        e.getValue(),
                        e.getValue() == 1 ? "pt" : "pts"));
    }
}
