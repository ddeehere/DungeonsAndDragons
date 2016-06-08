package danielandanthony.dungeonsanddragons;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.*;
import android.view.View;
import android.widget.EditText;
import java.util.ArrayList;
import java.lang.String;

/**
 *
 */
public class DnD extends AppCompatActivity {

    private static ArrayList<Character> characters = new ArrayList<Character>();

    @Override

    /**
     * This method controls what happens after clicking the button on the start page.
     */
    protected void onCreate(Bundle savedInstanceState) {
        // Sets the DnD class to the DnD activity, sets the button2 value to a variable, characterSheetButton.
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dn_d);
        android.widget.Button characterSheetButton = (android.widget.Button)findViewById(R.id.button2);
        generateCharacterSheets();

        // Sets the value of button to the variable startButton.
        android.widget.Button startButton = (android.widget.Button)findViewById(R.id.button);
        // Goes to another page after clicking the start button.
        startButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(DnD.this, ActivityDungeonMaster.class);
                startActivity(intent);
            }
        });
        // Goes to another page after clicking the character sheet button.
        characterSheetButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(DnD.this, ActivityCharacterSheet.class);
                EditText playerName = (EditText) findViewById(R.id.playerName);
                Bundle b = new Bundle();
                b.putString("playerName", playerName.getText().toString());
                intent.putExtra("dndBundle", b);
                startActivity(intent);
            }
        });

    }

    /**
     * This generates the characters cleric, ranger, and paladin.
     */
    public void generateCharacterSheets() {
        Character cleric = new Cleric();
        characters.add(cleric);

        Character ranger = new Ranger();
        characters.add(ranger);

        Character paladin = new Paladin();
        characters.add(paladin);
    }
    public static CharacterSheet getCharacterSheet(String name) {
        for (Character character : characters) {
            if (character.getCharacterSheet().getName().equals(name)) {
                return character.getCharacterSheet();
            }
        }

        return null;
    }

    /**
     * Array of characters.
     * @return The characters
     */
    public static ArrayList<Character>  getCharacters() {
        return characters;
    }
}
