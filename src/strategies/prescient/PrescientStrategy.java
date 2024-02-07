package strategies.prescient;

import strategies.Strategy;

public abstract class PrescientStrategy implements Strategy {

    protected boolean next_decision;

    public PrescientStrategy() {
        next_decision = true;
    }

    public abstract void prepareNextDecision(boolean opponent_cooperates);

    public boolean decide() {
        return next_decision;
    }
}
