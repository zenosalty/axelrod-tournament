/*
 * TitForXTat is a generalization
 * of Tit-For-Tat-like strategies,
 * which are well known for their
 * forgiveness qualities, as well
 * as being nice.
 *   Classic Tit-For-Tat is the
 * least forgiving form, which
 * forgets whatever the opponent
 * did before the last round.
 * On the other hand, Tit-For-2-Tat,
 * is more forgiving, retaliating
 * only after two consecutive
 * defections by the opponent;
 * and so on.
 *   Thus, given the generalization
 * provided by this strategy, Tit-For-Tat
 * is actually Tit-For-1-Tat, whereas
 * Sample is Tit-For-2-Tat.
 *   Let us consider two interesting
 * scenarios: Tit-For-0-Tat (or whenever
 * x <= 0) is the same Strategy as
 * AlwaysDefect, which never gives
 * a chance to the opponent nor trusts it;
 * Tit-For-(+infinity)-Tat is AlwaysCooperate,
 * which instead makes hope and forgiveness
 * its driving philosophy.
 */

package strategies.prescient.tit4tat;

import strategies.Outcome;
import strategies.prescient.PrescientStrategy;

public class TitForXTat extends PrescientStrategy {

    private int x;
    private int previous_defections;

    public TitForXTat(int x) {
        super();
        this.x = x;
        previous_defections = 0;
    }

    @Override
    public void prepareNextDecision(Outcome o) {
        // if the opp. cooperates, consider forgiving
        // by "forgetting" previous defections
        if (Outcome.COOPERATE == o)
            previous_defections = 0;
        else
            previous_defections++;

        // if subsequent defections exceed the limit, retaliate
        next_decision = previous_defections >= x ? Outcome.DEFECT : Outcome.COOPERATE;
        // do not reset the previous_def. counter,
        // since another defection may
        // occur in the following round
    }

    public String toString() {
        return "Tit-For-" + x + "-Tat";
    }
}
