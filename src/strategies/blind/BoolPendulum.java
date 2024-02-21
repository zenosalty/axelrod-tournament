/*
 * Pendulum alternates cooperation and defection.
 * For testing purposes only (or is it?).
 */

package strategies.blind;

import strategies.Outcome;
import strategies.Strategy;

@Deprecated
public class BoolPendulum implements Strategy {

    private boolean move;

    public BoolPendulum(boolean welcoming) {
        move = welcoming;
    }

    @Override
    public Outcome decide() {
        move = !move;
        return move ? Outcome.DEFECT : Outcome.COOPERATE;
    }

    public String toString() {
        return "BPn";
    }
}
