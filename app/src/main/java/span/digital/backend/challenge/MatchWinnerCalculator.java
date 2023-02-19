package span.digital.backend.challenge;

import java.util.Comparator;
import java.util.Set;

import javax.annotation.Nullable;


public class MatchWinnerCalculator {
    
    @Nullable
    public static Team getWinningTeam(Set<Team> match) {
        
        //Draw
        if (match.stream().map(Team::getPoints).distinct().count() <= 1) {
            return null;
        } else {
            return match.stream()
                    .max(Comparator.comparingInt(Team::getPoints))
                    .orElseThrow(IllegalArgumentException::new);
        }
    }
}
