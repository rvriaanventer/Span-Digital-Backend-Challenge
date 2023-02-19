package span.digital.backend.challenge;

public enum MatchOutcome {
    WIN(3),
    
    DRAW(1),
    
    LOSE(0);
    
    private final int points;
    
    MatchOutcome(int points) {
        this.points = points;
    }
    
    public int getPoints() {
        return points;
    }
}