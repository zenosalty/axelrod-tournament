package strategies.prescient.tit4tat;

import strategies.Outcome;
import strategies.prescient.PrescientStrategy;

public class TitForTat extends PrescientStrategy {

    public TitForTat() {
        super();
    }

    public void prepareNextDecision(Outcome o) {
        next_decision = o;
    }

    public String toString() {
        return "Tit For Tat";
    }
}
