package danielandanthony.dungeonsanddragons;

//import android.os.Bundle;
//import android.support.v7.app.AppCompatActivity;
//import android.widget.AdapterView;
import java.util.ArrayList;

/**
 * Runs a fight once at the click of the fight button, or if you encounter a monster.
 */
public class Fighting {
    private ArrayList<Character> playersCharacters;

    /**
     * Counts the number of players there are, each one takes a turn at the click.
     * @param playersCharacters The number of players
     */
    public Fighting(ArrayList<Character> playersCharacters) {

        this.playersCharacters = playersCharacters;
    }

    /**
     * Runs the fight sequence, player one attacks monster, monster slashes back, player two attacks, monster slashes back, etc.
     * @param monsterCharacter The monster attacking you.
     */
    public void fighting(Monster monsterCharacter) {
        // Player's turn.
        for (Character playersCharacter : playersCharacters) {
            // If player is dead, the corpse does not take a turn in fighting.
            if (playersCharacter.getCharacterSheet().getmaxHealth() <= 0) {
                continue;
            }
            // The player's turn, shooting with a bow.
            int attackBonus = playersCharacter.getCharacterSheet().getbowAttackBonus();
            int diceD20 = new Dice(20).rollDice();
            int totalBowAttack = attackBonus + diceD20;
            if (totalBowAttack >= monsterCharacter.getCharacterSheet().getarmorClass()) {
                int monsterCurrentHealth = monsterCharacter.getCharacterSheet().getmaxHealth()
                        - playersCharacter.getCharacterSheet().getbowDamageBonus();
                monsterCharacter.getCharacterSheet().setmaxHealth(monsterCurrentHealth);
            }
            // The monster's turn, melee attack with a sword.
            attackBonus = monsterCharacter.getCharacterSheet().getswordAttackBonus();
            diceD20 = new Dice(20).rollDice();
            int totalSwordAttack = attackBonus + diceD20;
            if (totalSwordAttack >= playersCharacter.getCharacterSheet().getarmorClass()) {
                int playerCurrentHealth = playersCharacter.getCharacterSheet().getmaxHealth()
                        - monsterCharacter.getCharacterSheet().getswordDamageBonus();
                playersCharacter.getCharacterSheet().setmaxHealth(playerCurrentHealth);

            }
        }

    }
}