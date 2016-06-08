package danielandanthony.dungeonsanddragons;

/**
 * One of the player classes, Cleric.
 */
public class Cleric extends Character {
    /**
     * This is a constructor that creates a character sheet for the Cleric class.
     */
    public Cleric () {
        // Assigned values for each part of the character sheet.
        super(new CharacterSheet("Cleric"));
        CharacterSheet cs = getCharacterSheet();
        cs.setmaxHealth(30);
        cs.setarmorClass(15);
        cs.setcon(15);
        cs.setstr(13);
        cs.setdex(11);
        cs.setinT(12);
        cs.setwis(18);
        cs.setcha(12);
        cs.setconMod(2);
        cs.setstrMod(1);
        cs.setdexMod(0);
        cs.setintMod(1);
        cs.setwisMod(4);
        cs.setchaMod(1);
        cs.setswordAttackBonus(1);
        cs.setbowAttackBonus(3);
        cs.setswordDamageBonus(4);
        cs.setbowDamageBonus(3);
        cs.setspellHealingBonus(6);
        cs.setarrows(15);
        cs.setspellsPerDay(5);
    }
}
