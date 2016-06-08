package danielandanthony.dungeonsanddragons;

import java.util.Random;

/**
 * Generates monsters (in an array) in each square of the map of N2D6.
 */
public class Terrain {
    private Monster[] monsters;

    public Terrain() {
        int numberOfMonsters = new Random().nextInt(4);
        monsters = new Monster[numberOfMonsters];
        for (int i = 0; i < numberOfMonsters; i++) {
            monsters[i] = new Monster();
        }
    }

    public Monster[] getMonsters() {
        return monsters;
    }
}

