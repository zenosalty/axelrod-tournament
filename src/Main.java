import strategies.blind.*;
import strategies.prescient.Simpleton;

public class Main {
    public static void main(String[] args) {
        int rounds = 10;

        Player random = new Player(new Random());
        Player simpleton = new Player (new Simpleton());

        Match m = new Match();

        m.setPlayers(simpleton, random);
        m.fight(rounds);

        System.out.println(simpleton.getScore() + " " + random.getScore());
    }
}