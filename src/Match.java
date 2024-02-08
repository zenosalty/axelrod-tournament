import strategies.Outcome;
import strategies.prescient.PrescientStrategy;

public class Match {

    static final int LOSS = -1;
    static final int PRIZE = 2;
    static final int GAIN = 3;
    static final int SHARE = 0;

    private Player p1;
    private Player p2;

    private char[] t1;
    private char[] t2;
    
    public Match() {}

    public Match(Player p1, Player p2) {
        this.p1 = p1;
        this.p2 = p2;
    }

    private void updatePoints(Outcome o1, Outcome o2) {
        if (Outcome.COOPERATE == o1 && o1 == o2) {
            p1.addPoints(PRIZE);
            p2.addPoints(PRIZE);
        } else if (Outcome.COOPERATE == o1) {
            p1.addPoints(LOSS);
            p2.addPoints(GAIN);
        } else if (Outcome.COOPERATE == o2) {
            p1.addPoints(GAIN);
            p2.addPoints(LOSS);
        } else {
            p1.addPoints(SHARE);
            p2.addPoints(SHARE);
        }
    }

    public void fight(int rounds) {

        t1 = new char[rounds];
        t2 = new char[rounds];

        Outcome p1_outcome;
        Outcome p2_outcome;

        for (int i = 0; i < rounds; i++) {

            p1_outcome = p1.getStrategy().decide();
            p2_outcome = p2.getStrategy().decide();

            updatePoints(p1_outcome, p2_outcome);

            if (p1.getStrategy() instanceof PrescientStrategy)
                ((PrescientStrategy) p1.getStrategy()).prepareNextDecision(p2_outcome);
            if (p2.getStrategy() instanceof PrescientStrategy)
                ((PrescientStrategy) p2.getStrategy()).prepareNextDecision(p1_outcome);
        }
    }
    
    public void setFirstPlayer(Player p) {
        p1 = p;
    }

    public void setSecondPlayer(Player p) {
        p2 = p;
    }

    public void setPlayers(Player p1, Player p2) {
        this.p1 = p1;
        this.p2 = p2;
    }
}
