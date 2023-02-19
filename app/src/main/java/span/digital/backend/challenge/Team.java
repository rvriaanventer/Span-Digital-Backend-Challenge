package span.digital.backend.challenge;

public class Team {
    
    private String name;
    private int points;
    
    public Team() {
    }
    
    public Team(String name, int points) {
        this.name = name;
        this.points = points;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public int getPoints() {
        return points;
    }
    
    public void setPoints(int points) {
        this.points = points;
    }
    
    public static Team valueOf(String teamString) {
        Team team = new Team();
        int lastSpaceIndex = teamString.lastIndexOf(' ');
        team.setPoints(Integer.parseInt(teamString.substring(lastSpaceIndex + 1)));
        team.setName(teamString.substring(0, lastSpaceIndex));
        return team;
    }
}
