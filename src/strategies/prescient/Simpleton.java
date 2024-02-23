package strategies.prescient;

import strategies.Outcome;

public class Simpleton extends PrescientStrategy {
    @Override
    public void prepareNextDecision(Outcome o) {
        if (Outcome.DEFECT == o)
            next_decision = (next_decision == Outcome.COOPERATE) ? Outcome.DEFECT : Outcome.COOPERATE;
    }
}