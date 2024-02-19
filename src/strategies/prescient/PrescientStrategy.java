package strategies.prescient;

import strategies.Outcome;
import strategies.Strategy;

public abstract class PrescientStrategy implements Strategy {

    protected Outcome next_decision;

    public PrescientStrategy() {
        // by default, every prescient strategy is nice
        next_decision = Outcome.COOPERATE;
    }

    public abstract void prepareNextDecision(Outcome o);

    public Outcome decide() {
        return next_decision;
    }
}
