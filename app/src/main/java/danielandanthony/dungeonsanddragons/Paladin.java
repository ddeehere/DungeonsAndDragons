package danielandanthony.dungeonsanddragons;

/**
 * One of the player classes, Paladin.
 */
public class Paladin extends Character {
    /**
     * This is a constructor that creates a character sheet for the Paladin class.
     */
    public Paladin () {
        // Assigned values for each part of the character sheet.
        super(new CharacterSheet("Paladin"));
        CharacterSheet cs = getCharacterSheet();
        cs.setmaxHealth(30);
        cs.setarmorClass(18);
        cs.setcon(18);
        cs.setstr(16);
        cs.setdex(16);
        cs.setcha(8);
        cs.setinT(7);
        cs.setwis(13);
        cs.setconMod(4);
        cs.setstrMod(3);
        cs.setdexMod(3);
        cs.setintMod(-2);
        cs.setwisMod(1);
        cs.setchaMod(-1);
        cs.setswordAttackBonus(4);
        cs.setbowAttackBonus(5);
        cs.setswordDamageBonus(10);
        cs.setbowDamageBonus(4);
        cs.setspellDamageBonus(2);
        cs.setspellHealingBonus(2);
        cs.setarrows(20);
        cs.setspellsPerDay(4);
    }
}
