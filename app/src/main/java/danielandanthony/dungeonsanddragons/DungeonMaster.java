package danielandanthony.dungeonsanddragons;

import android.widget.Spinner;
import java.util.Random;

/**
 * This is the class DungeonMaster. It generates the map of the world.
 */
public class DungeonMaster {
    // Variable declaration statements.
    private Map map;
    private Fighting fighting;
    int locationX;
    int locationY;

    /**
     * This the constructor, which creates the map of N2D6 as an object.
     */
    public DungeonMaster() {
        // Setting values for variables.
        map = new Map();
        fighting = new Fighting(DnD.getCharacters());
        locationX = new Random().nextInt(9);
        locationY = new Random().nextInt(9);

    }

    /**
     * Gets the map.
     * @return The generated map of N2D6
     */
    public Map getMap () {
        return map;
    }

    public Fighting getFighting () { return fighting; }
    public int getLocationX () {
        return locationX;
    }
    public int getLocationY () {
        return locationY;
    }

    /**
     * Moves the players around.
     * @param item The direction you're moving: North, South, East or West
     * @param direction The spinner object that lets you select different directions to move.
     */
    public void travel(String item, Spinner direction) {
        // Moves North, South, East, or West, unless you are at the edge of the world.
        if (item.equals("North")) {
            if (locationY > 0) {
                locationY--;
            }
        }
        else if (item.equals("South")) {
            if (locationY < 8) {
                locationY++;
            }
        }
        else if (item.equals("East")) {
            if (locationX < 8) {
                locationX++;
            }
        }
        else {
            if (locationX > 0) {
                locationX--;
            }
        }
    }
}
