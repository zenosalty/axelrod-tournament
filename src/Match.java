import strategies.Strategy;
import strategies.prescient.PrescientStrategy;

public class Match {

    static final int LOSS = -1;
    static final int PRIZE = 2;
    static final int GAIN = 3;
    static final int SHARE = 0;

    private Player first;
    private Player second;

    public Match(Player first, Player second) {
        this.first = first;
        this.second = second;
    }

    public Match(Player first, Player second, int rounds) {
        this(first, second);
        fight(rounds);
    }

    private void updatePoints(boolean p1_outcome, boolean p2_outcome) {
        if (p1_outcome && p2_outcome) {
            first.addPoints(PRIZE);
            second.addPoints(PRIZE);
        } else if (p1_outcome) {
            first.addPoints(LOSS);
            second.addPoints(GAIN);
        } else if (p2_outcome) {
            first.addPoints(GAIN);
            second.addPoints(LOSS);
        } else {
            first.addPoints(SHARE);
            second.addPoints(SHARE);
        }
    }

    public void fight(int rounds) {

        boolean p1_outcome;
        boolean p2_outcome;

        for (int i = 0; i < rounds; i++) {

            p1_outcome = first.getStrategy().decide();
            p2_outcome = second.getStrategy().decide();

            updatePoints(p1_outcome, p2_outcome);

            if (first.getStrategy() instanceof PrescientStrategy)
                ((PrescientStrategy) first.getStrategy()).prepareNextDecision(p2_outcome);
            if (second.getStrategy() instanceof PrescientStrategy)
                ((PrescientStrategy) second.getStrategy()).prepareNextDecision(p1_outcome);
        }
    }
}
