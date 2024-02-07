/*
 * Chooses cooperation on its first move,
 * and if the other player chooses cooperation,
 * Joss has a 90% probability of choosing
 * cooperation on its next move
 * (a 10% probability of non-cooperation).
 *
 * If the other player chooses non-cooperation,
 * Joss chooses non-cooperation on its next move,
 * without exception.
 */

package strategies.prescient;

public class Joss extends PrescientStrategy {

    public Joss() {
        super();
    }

    @Override
    public void prepareNextDecision(boolean opponent_cooperates) {

        next_decision = opponent_cooperates;

        if (opponent_cooperates && (int)(Math.random() * 10 + 1) == 1)
            next_decision = false;
    }
}
