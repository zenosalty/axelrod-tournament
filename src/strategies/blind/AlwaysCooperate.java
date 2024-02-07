package strategies.blind;

import strategies.Strategy;

public class AlwaysCooperate implements Strategy {
    @Override
    public boolean decide() {
        return true;
    }
}