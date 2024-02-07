import strategies.Strategy;
import strategies.prescient.PrescientStrategy;

public class Match {

    private Strategy player_1;
    private Strategy player_2;

    private int p1_points;
    private int p2_points;

    public Match(Strategy first, Strategy second) {
        player_1 = first;
        player_2 = second;
    }

    private void updatePoints(boolean p1_outcome, boolean p2_outcome) {
        if (p1_outcome && p2_outcome) {
            p1_points += 3;
            p2_points += 3;
        } else if (p1_outcome) {
            p2_points += 5;
        } else if (p2_outcome) {
            p1_points += 5;
        } else {
            p1_points += 1;
            p2_points += 1;
        }
    }

    public void fight(int rounds) {

        boolean p1_outcome;
        boolean p2_outcome;

        p1_points = 0;
        p2_points = 0;

        for (int i = 0; i < rounds; i++) {

            p1_outcome = player_1.decide();
            p2_outcome = player_2.decide();

            updatePoints(p1_outcome, p2_outcome);

            if (player_1 instanceof PrescientStrategy)
                ((PrescientStrategy) player_1).prepareNextDecision(p2_outcome);
            if (player_2 instanceof PrescientStrategy)
                ((PrescientStrategy) player_2).prepareNextDecision(p1_outcome);
        }
    }

    public int getP1Points() {
        return p1_points;
    }

    public int getP2Points() {
        return p2_points;
    }
}
