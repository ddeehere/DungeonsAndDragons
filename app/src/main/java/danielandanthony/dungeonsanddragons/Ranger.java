package danielandanthony.dungeonsanddragons;

/**
 * One of the player classes, Ranger.
 */
public class Ranger extends Character {
    /**
     * This is a constructor that creates a character sheet for the Ranger class.
     */
    public Ranger () {
        // Assigned values for each part of the character sheet.
        super(new CharacterSheet("Ranger"));
        CharacterSheet cs = getCharacterSheet();
        cs.setmaxHealth(30);
        cs.setarmorClass(16);
        cs.setcon(16);
        cs.setstr(14);
        cs.setdex(15);
        cs.setinT(9);
        cs.setwis(12);
        cs.setcha(10);
        cs.setconMod(3);
        cs.setstrMod(2);
        cs.setdexMod(2);
        cs.setintMod(-1);
        cs.setwisMod(1);
        cs.setchaMod(0);
        cs.setswordAttackBonus(3);
        cs.setbowAttackBonus(4);
        cs.setswordDamageBonus(7);
        cs.setbowDamageBonus(5);
        cs.setspellDamageBonus(2);
        cs.setarrows(25);
        cs.setspellsPerDay(1);
    }
}
