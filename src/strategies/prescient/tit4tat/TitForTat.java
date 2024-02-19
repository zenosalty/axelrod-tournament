/*
 * So far, this is regarded as the best Strategy
 * of the tournament. It is not always effective,
 * however. But in the long run and with the
 * right (and minimum) amount of nearby opponents,
 * it turns out that Tit-For-Tat is pretty strong.
 */

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
