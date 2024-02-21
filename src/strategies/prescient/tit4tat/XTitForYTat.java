/*
 * The ultimate generalization of tit-for-tat-based
 * Strategies.
 *   X-Tit-For-Y-Tat evaluates whether its opponent
 * is trustworthy or not by assigning them a certain
 * amount of credits, which depend on the value of Y.
 * At the beginning of the game, X-Tit-For-Y-Tat
 * cooperates and does so until the opponent defects
 * Y times in a row. In other words, Y acts as a
 * "tolerance threshold" which makes X-Tit-For-Y-Tat
 * retaliate when the opponent trespasses it by
 * defecting that many consecutive times. When this
 * event occurs, X-Tit-For-Y-Tat enters a new state
 * in which the opponent is regarded as "untrustworthy",
 * that is, credits have just run out. Now X-Tit-For-Y-Tat
 * keeps retaliating until the opponent increases its
 * credits up to X, which may differ from Y. X acts here
 * as a debt that must be paid back in order to gain
 * X-Tit-For-Y-Tat trust. Once trust has been restored,
 * the opponent's credits are reset to Y and the
 * process repeats til the end of the game.
 *   While in the trustworthy state, the opponent cannot
 * exceed the maximum amount of credits specified by Y.
 * On the other hand, when the untrustworthy state is
 * active, the opponent is bounded by X instead of Y.
 */

package strategies.prescient.tit4tat;

import strategies.Outcome;
import strategies.prescient.PrescientStrategy;

public class XTitForYTat extends PrescientStrategy {

    private int x, y;
    private int credits;
    private boolean trusted;

    public XTitForYTat(int x, int y) {
        super();
        this.x = x;
        this.y = y;
        reset(y);
    }

    private void reset(int y) {
        credits = y;
        trusted = true;
    }

    @Override
    public void prepareNextDecision(Outcome o) {
        if (Outcome.COOPERATE == o) {
            if (trusted)
                credits += credits < y ? 1 : 0;
            else
                credits++;
        } else {
            if (trusted)
                credits--;
            else
                credits -= credits > 0 ? 1 : 0;
        }

        if (trusted && credits == 0)
            trusted = false;
        else if (!trusted && credits == x)
            reset(y);

        next_decision = trusted ? Outcome.COOPERATE : Outcome.DEFECT;
    }

    public String toString() {
        return x + "-Tit-For-" + y + "-Tat";
    }
}
