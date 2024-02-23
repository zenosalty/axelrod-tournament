import strategies.blind.*;
import strategies.prescient.Tester;

public class Main {
    public static void main(String[] args) {
        int rounds = 10;

        Player good = new Player(new AlwaysCooperate());
        Player bad = new Player(new AlwaysDefect());
        Player tester = new Player(new Tester());
        Player random = new Player(new Random());

        Match m = new Match();

        m.setPlayers(tester, random);
        m.fight(rounds);

        System.out.println(tester.getScore() + " " + random.getScore());
    }
}