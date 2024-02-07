/*
 * Random is a "dumb" strategy
 * introduced by Axelrod in
 * the tournament.
 *
 * Random simply tosses a coin
 * at the beginning of every
 * round: it will defect or
 * cooperate with a 50% chance.
 */

package strategies.blind;

import strategies.Strategy;

import java.util.concurrent.ThreadLocalRandom;

public class Random implements Strategy {
    @Override
    public boolean decide() {
        return ThreadLocalRandom.current().nextBoolean();
    }
}
