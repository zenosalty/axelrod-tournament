/*
 * This strategy acts in a similar way as
 * Tit-For-Tat, but introducing some sneaky
 * moves (at random) in order to take advantage
 * of the opponent.
 *   Joss chooses cooperation on its first move,
 * and if the other player chooses cooperation,
 * Joss has a 90% probability of choosing
 * cooperation on its next move
 * (a 10% probability of non-cooperation).
 *   If the other player chooses non-cooperation,
 * Joss chooses non-cooperation on its next move,
 * without exception.
 */

package strategies.prescient;

import strategies.Outcome;

public class Joss extends PrescientStrategy {

    public Joss() {
        super();
    }

    @Override
    public void prepareNextDecision(Outcome o) {

        next_decision = o;

        if (Outcome.COOPERATE == o && (int)(Math.random() * 10 + 1) == 1)
            next_decision = Outcome.DEFECT;
    }

    public String toString() {
        return "Joss";
    }
}
