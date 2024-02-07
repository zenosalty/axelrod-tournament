import strategies.Strategy;

public class Player {
    private Strategy s;
    private int total_score;

    public Player(Strategy s) {
        this.s = s;
        total_score = 0;
    }

    public void addPoints(int points) {
        total_score += points;
    }

    public Strategy getStrategy() {
        return s;
    }

    public int getScore() {
        return total_score;
    }
}
