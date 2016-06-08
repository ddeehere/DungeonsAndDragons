package danielandanthony.dungeonsanddragons;

import java.util.Random;

/**
 * This generates villages in the map of N2D6
 */
public class Village extends Terrain{
    /**
    * Generates villagers in the villages.
    */
    int numberOfVillagers = new Random().nextInt(25);
    private Villager[] villagers = new Villager[numberOfVillagers];
    public Village() {
        for (int i = 0; i < numberOfVillagers; i++) {
            villagers[i] = new Villager();
        }
    }

    public Villager[] getVillagers() {
        return villagers;
    }
}
