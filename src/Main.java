import strategies.blind.Pendulum;
import strategies.blind.Random;
import strategies.prescient.tit4tat.XTitForTat;

public class Main {
    public static void main(String[] args) {
        int rounds = 10;

        Player p1 = new Player(new Pendulum(1, true));
        Player random = new Player(new Random());
        Player xtitfortat = new Player(new XTitForTat(2));

        Match m = new Match();

        m.setPlayers(p1, random);
        m.fight(rounds);

        System.out.println(p1.getScore() + " " + random.getScore());
    }
}