/*
 * During a match, points are assigned according
 * to the following scheme:
 * - when both players cooperate, they gain a
 *   positive "prize"
 * - when both players defect, they gain an
 *   equal "share"
 * - when one player defects and the other
 *   cooperates, the former gets a "loot" stolen
 *   by the latter, which instead suffers a "loss"
 *
 * The corresponding values of prize, share, loot
 * and loss are arbitrary, but they should be
 * set in such a manner that the overall game is
 * non-zero-sum.
 */

import strategies.Outcome;
import strategies.prescient.PrescientStrategy;

public class Match {

    static final int LOSS = -1;
    static final int PRIZE = 2;
    static final int LOOT = 3;
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
            p2.addPoints(LOOT);
        } else if (Outcome.COOPERATE == o2) {
            p1.addPoints(LOOT);
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

            t1[i] = p1_outcome == Outcome.COOPERATE ? 'C' : 'D';
            t2[i] = p2_outcome == Outcome.COOPERATE ? 'C' : 'D';

            updatePoints(p1_outcome, p2_outcome);

            if (p1.getStrategy() instanceof PrescientStrategy)
                ((PrescientStrategy) p1.getStrategy()).prepareNextDecision(p2_outcome);
            if (p2.getStrategy() instanceof PrescientStrategy)
                ((PrescientStrategy) p2.getStrategy()).prepareNextDecision(p1_outcome);
        }

        System.out.print(":\t");
        for (int i = 0; i < rounds; i++) {
            System.out.print(t1[i] + " ");
        }
        System.out.println();
        System.out.print(":\t");
        for (int i = 0; i < rounds; i++) {
            System.out.print(t2[i] + " ");
        }

        System.out.println();
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
