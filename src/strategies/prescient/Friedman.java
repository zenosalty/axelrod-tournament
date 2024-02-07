package strategies.prescient;

import strategies.Strategy;

public class Friedman extends PrescientStrategy {

    public Friedman() {
        super();
    }

    @Override
    public void prepareNextDecision(boolean opponent_cooperates) {
        if (!opponent_cooperates)
            next_decision = false;
    }
}
