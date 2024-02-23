/*
 * It works the same way as TFT,
 * but instead of retaliating
 * after every defection by the
 * opponent, it instead cooperates
 * 10% of the times.
 *
 * Remember that the purpose of this
 * Strategy makes sense when it plays
 * against, say, other nice strategies
 * but in a noisy environment.
 */

package strategies.prescient.tit4tat;

import strategies.Outcome;
import strategies.prescient.PrescientStrategy;

public class GenerousTitForTat extends PrescientStrategy {
    @Override
    public void prepareNextDecision(Outcome o) {
        next_decision = o;

        if (Outcome.DEFECT == o && (int)(Math.random() * 10 + 1) == 1)
            next_decision = Outcome.COOPERATE;
    }
}