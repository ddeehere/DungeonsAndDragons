package danielandanthony.dungeonsanddragons;

/**
 * The statistics of each monster in N2D6. Note: there is a different character sheet for each monster, but this sets the initial values for each monster.
 */
public class Monster extends Character {
    /**
     * Constructor that creates each monster's individual stats.
     */
    public Monster () {
        // Assigned values for each part of the character sheet.
        super(new CharacterSheet("Monster"));
        CharacterSheet cs = getCharacterSheet();
        cs.setmaxHealth(10);
        cs.setarmorClass(15);
        cs.setcon(20);
        cs.setstr(18);
        cs.setdex(14);
        cs.setinT(8);
        cs.setwis(10);
        cs.setcha(10);
        cs.setconMod(5);
        cs.setstrMod(4);
        cs.setdexMod(2);
        cs.setintMod(-1);
        cs.setwisMod(0);
        cs.setchaMod(0);
        cs.setswordAttackBonus(3);
        cs.setbowAttackBonus(0);
        cs.setswordDamageBonus(3);
        cs.setbowDamageBonus(0);
        cs.setspellHealingBonus(0);
        cs.setarrows(0);
        cs.setspellsPerDay(0);
    }
}
