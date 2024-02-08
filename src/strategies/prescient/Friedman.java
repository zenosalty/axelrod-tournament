package strategies.prescient;

import strategies.Outcome;

public class Friedman extends PrescientStrategy {

    public Friedman() {
        super();
    }

    @Override
    public void prepareNextDecision(Outcome o) {
        if (Outcome.DEFECT == o)
            next_decision = Outcome.DEFECT;
    }
}