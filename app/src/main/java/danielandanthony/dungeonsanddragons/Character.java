package danielandanthony.dungeonsanddragons;

/**
 * Stores the character sheet in the memory of the program, and returns the character sheets.
 */
public class Character {
	private CharacterSheet characterSheet;
	public Character () {

	}

	public Character (CharacterSheet characterSheet) {
		
		this.characterSheet = characterSheet;

		}
	public CharacterSheet getCharacterSheet() {
		return this.characterSheet; 
	}
}