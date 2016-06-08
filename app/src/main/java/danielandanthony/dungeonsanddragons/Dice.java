package danielandanthony.dungeonsanddragons;


import java.util.Random;

/**
 * This class is what returns the dice roll value called by the TestDice class.
 */
public class Dice {
    private int sides;

    public Dice(int sides) {
        this.sides = sides;
    }

    public static int randomInt(int max) {
        return (new Random().nextInt(max));
    }

    public int rollDice() {
        int diceRoll = Dice.randomInt(this.sides);
        diceRoll += 1;
        return diceRoll;
    }

}