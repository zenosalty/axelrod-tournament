/*
 * Prescient Strategies are named thus after
 * their ability to make sophisticated choices
 * by considering the outcomes of their opponents
 * in previous rounds.
 *   Except for the first round, the following
 * outcomes reflect how the next_decision had
 * been determined based on the opponent's
 * behaviour, which may be kept track of not
 * only by looking at the previous outcome but
 * also by storing additional data.
 */

package strategies.prescient;

import strategies.Outcome;
import strategies.Strategy;

public abstract class PrescientStrategy implements Strategy {

    protected Outcome next_decision;

    public PrescientStrategy() {
        // by default, every prescient strategy starts nicely
        next_decision = Outcome.COOPERATE;
    }

    public abstract void prepareNextDecision(Outcome o);

    public Outcome decide() {
        return next_decision;
    }
}
