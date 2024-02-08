package strategies.prescient;

import strategies.Outcome;

public class TitForTat extends PrescientStrategy {

    public TitForTat() {
        super();
    }

    public void prepareNextDecision(Outcome o) {
        next_decision = o;
    }
}
