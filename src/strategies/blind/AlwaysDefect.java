package strategies.blind;

import strategies.Strategy;

public class AlwaysDefect implements Strategy {
    @Override
    public boolean decide() {
        return false;
    }
}
