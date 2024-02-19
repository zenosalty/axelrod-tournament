/*
 * The counterpart of AlwaysDefect,
 * AlwaysCooperate hates being angry
 * and cooperates regardless of its
 * opponents choices.
 */

package strategies.blind;

import strategies.Strategy;
import strategies.Outcome;

public class AlwaysCooperate implements Strategy {
    @Override
    public Outcome decide() {
        return Outcome.COOPERATE;
    }

    public String toString() {
        return "Always Cooperate";
    }
}