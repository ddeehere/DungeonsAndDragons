package danielandanthony.dungeonsanddragons;

import android.widget.Spinner;
import android.widget.Toast;
import java.util.Random;

/**
 * Generates the map, a program called by the DungeonMaster class.
 */
public class Map {
    private Terrain[][] terrains = new Terrain[9][9];

    public Map() {
        // Sea: sets the Sea terrain.
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 9; j++) {
                terrains[i][j] = new Sea();
            }
        }

        // Mountain: sets the Mountain terrain.
        for (int i = 6; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                terrains[i][j] = new Mountain();
            }
        }

        // Sets Oriana's position.
        int locationOrianaX = new Random().nextInt(3) + 6;
        int locationOrianaY = new Random().nextInt(9);
        ((Mountain) terrains[locationOrianaX][locationOrianaY]).setOriana(new Oriana());


        // Forest: sets the Forest terrain.
        for (int i = 3; i < 6; i++) {
            for (int j = 0; j < 9; j++) {
                terrains[i][j] = new Forest();
            }
        }

        // Villages: Creates the number of villages, then randomly generates them in the forest.
        int numberOfVillages = new Random().nextInt(27);
        for (int i = 0; i < numberOfVillages; i++) {
            int villageLocationX = new Random().nextInt(3) + 3;
            int villageLocationY = new Random().nextInt(9);
            terrains[villageLocationX][villageLocationY] = new Village();
        }

    }

    /**
     * Array for the map with many terrains.
     * @return The terrains/map.
     */
    public Terrain[][] getTerrains() {
        return terrains;
    }
}


