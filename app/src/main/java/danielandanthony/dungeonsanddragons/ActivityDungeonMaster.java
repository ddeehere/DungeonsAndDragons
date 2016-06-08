package danielandanthony.dungeonsanddragons;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.*;
import android.widget.AdapterView.*;
import java.util.*;

/**
 * This class sets the values for each spinner and button, also sets what each user interface object does when clicked or selected.
 */
public class ActivityDungeonMaster extends AppCompatActivity {
    // Set variables.
    String item = null;
    String question = null;
    Terrain terrain;
    private DungeonMaster dungeonMaster;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dungeon_master);
        dungeonMaster = new DungeonMaster();
        terrain = dungeonMaster.getMap().getTerrains()[dungeonMaster.getLocationX()][dungeonMaster.getLocationY()];
        // Spinner element
        final Spinner questions = (Spinner) findViewById(R.id.questionSpinner);

        // Spinner click listener
        questions.setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                // On selecting a spinner item
                question = parent.getItemAtPosition(position).toString();

                // Showing selected spinner item
                Toast.makeText(parent.getContext(), "Selected: " + question, Toast.LENGTH_LONG).show();
            }
            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub


            }
        });

        // Spinner Drop down elements
        List<String> categories = new ArrayList<String>();
        categories.add("Have you seen Oriana before?");
        categories.add("Where did you last see Oriana?");
        categories.add("When did you last see Oriana?");
        categories.add("Tell us what you know about Oriana.");

        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories);

        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        questions.setAdapter(dataAdapter);

        // Spinner element
        final Spinner direction = (Spinner) findViewById(R.id.directionSpinner);

        // Spinner click listener
        direction.setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                // On selecting a spinner item
                item = parent.getItemAtPosition(position).toString();

                // Showing selected spinner item
                // Toast.makeText(parent.getContext(), "Direction: " + item, Toast.LENGTH_LONG).show();
            }
            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub


            }
        });

        // Spinner Drop down elements
        List<String> categories2 = new ArrayList<String>();
        categories2.add("North");
        categories2.add("East");
        categories2.add("South");
        categories2.add("West");

        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories2);

        // Drop down layout style - list view with radio button
        dataAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        direction.setAdapter(dataAdapter2);

        Button talkButton = (Button)findViewById(R.id.talkButton);
        talkButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Answers after clicking the talk button, what is displayed, depending on the circumstances.
                int x = dungeonMaster.getLocationX();
                int y = dungeonMaster.getLocationY();
                terrain = dungeonMaster.getMap().getTerrains() [x][y];
                if (terrain instanceof Village) {
                    int numberOfVillagers = ((Village) terrain).getVillagers().length;
                    int numberOfMonsters = ((Village) terrain).getMonsters().length;
                    if (numberOfVillagers > 0) {
                        int interrogatedVillager = new Random().nextInt(numberOfVillagers);
                        String answer = ((Village) terrain).getVillagers()[interrogatedVillager].ask(question);
                        Toast.makeText(questions.getContext(), "The villager gives your question some thought, scratches their head, and says, '"
                                + answer + ".'"
                                , Toast.LENGTH_LONG).show();
                    }
                    else if (numberOfMonsters > 0 && numberOfVillagers <= 0) {
                        Toast.makeText(questions.getContext(), "You look around the village, but the only thing you see is blood everywhere. " +
                                "As you go around the corner of what looks like the chiefs house, you encounter a bloody body, the body of the chief. " +
                                "You dare to step a little further, noticing prints on the ground. " +
                                "Suddenly, you hear a growl behind you. " +
                                "You whip around, finding yourself facing a giant beast, its teeth stained with blood..."
                                , Toast.LENGTH_LONG).show();
                    }
                    else {
                        Toast.makeText(questions.getContext(), "You glance around the village, but you don't find any monsters or villagers. " +
                                "You decide to move on."
                                , Toast.LENGTH_LONG).show();
                    }
                }
                else {
                    Toast.makeText(questions.getContext(), "No villagers in sight."
                            , Toast.LENGTH_LONG).show();
                }
            }
        });

        Button travelButton = (Button)findViewById(R.id.travelButton);
        travelButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                // What is displayed after clicking travel button, like coordinates, terrain, etc., depending on the circumstances.
                dungeonMaster.travel(item, direction);
                int x = dungeonMaster.getLocationX();
                int y = dungeonMaster.getLocationY();
                terrain = dungeonMaster.getMap().getTerrains() [x][y];
                int numberOfMonsters = terrain.getMonsters().length;
                int numberOfVillagers = 0;
                if (terrain instanceof Village) {
                    numberOfVillagers = ((Village) terrain).getVillagers().length;
                    if (DnD.getCharacterSheet("Cleric").getmaxHealth() <= 0 && DnD.getCharacterSheet("Ranger").getmaxHealth() <= 0 && DnD.getCharacterSheet("Paladin").getmaxHealth() <= 0) {
                        Toast.makeText(ActivityDungeonMaster.this, "The monster uses the sword to behead each one of you. You all die instantaneously. YOU LOSE THE GAME!! Try again next time."
                                , Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(ActivityDungeonMaster.this, DnD.class);
                        startActivity(intent);
                    }
                    if (numberOfMonsters == 0) {
                        Toast.makeText(direction.getContext(), "You are in a village. " +
                                        "The coordinates are - (" + x + "," + y + "). " +
                                        "Number of monsters - " + numberOfMonsters + ". " +
                                        "Number of villagers - " + numberOfVillagers + ". "
                                , Toast.LENGTH_LONG).show();
                    }
                    else {
                        Fighting fighting = dungeonMaster.getFighting();
                        fighting.fighting(terrain.getMonsters()[0]);
                        Toast.makeText(ActivityDungeonMaster.this, "Current Hp: " +
                                        "Monster - " + terrain.getMonsters()[0].getCharacterSheet().getmaxHealth() +
                                        "; Cleric - " + DnD.getCharacterSheet("Cleric").getmaxHealth() +
                                        "; Ranger - " + DnD.getCharacterSheet("Ranger").getmaxHealth() +
                                        "; Paladin - " + DnD.getCharacterSheet("Paladin").getmaxHealth()
                                , Toast.LENGTH_LONG).show();
                        Toast.makeText(direction.getContext(), "You are in a village. " +
                                        "The coordinates are - (" + x + "," + y + "). " +
                                        "Number of monsters - " + numberOfMonsters + ". " +
                                        "Number of villagers - " + numberOfVillagers + ". "
                                , Toast.LENGTH_LONG).show();
                    }
                }

                else if (terrain instanceof Sea) {
                    if (DnD.getCharacterSheet("Cleric").getmaxHealth() <= 0 && DnD.getCharacterSheet("Ranger").getmaxHealth() <= 0 && DnD.getCharacterSheet("Paladin").getmaxHealth() <= 0) {
                        Toast.makeText(ActivityDungeonMaster.this, "The monster uses the sword to behead each one of you. You all die instantaneously. YOU LOSE THE GAME!! Try again next time."
                                , Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(ActivityDungeonMaster.this, DnD.class);
                        startActivity(intent);
                    }
                    if (numberOfMonsters == 0) {
                        Toast.makeText(direction.getContext(), "You are in the sea. " +
                                        "The coordinates are - (" + x + "," + y + "). " +
                                        "Number of monsters - " + numberOfMonsters + ". "
                                , Toast.LENGTH_LONG).show();
                    }
                    else {
                        Fighting fighting = dungeonMaster.getFighting();
                        fighting.fighting(terrain.getMonsters()[0]);
                        Toast.makeText(ActivityDungeonMaster.this, "Current Hp: " +
                                        "Monster - " + terrain.getMonsters()[0].getCharacterSheet().getmaxHealth() +
                                        "; Cleric - " + DnD.getCharacterSheet("Cleric").getmaxHealth() +
                                        "; Ranger - " + DnD.getCharacterSheet("Ranger").getmaxHealth() +
                                        "; Paladin - " + DnD.getCharacterSheet("Paladin").getmaxHealth()
                                , Toast.LENGTH_SHORT).show();
                        Toast.makeText(direction.getContext(), "You are in the sea. " +
                                        "The coordinates are - (" + x + "," + y + "). " +
                                        "Number of monsters - " + numberOfMonsters + ". "
                                , Toast.LENGTH_LONG).show();
                    }
                }

                else if (terrain instanceof Mountain) {
                    Oriana oriana = ((Mountain) terrain).getOriana();
                    if (oriana == null) {
                        if (DnD.getCharacterSheet("Cleric").getmaxHealth() <= 0 && DnD.getCharacterSheet("Ranger").getmaxHealth() <= 0 && DnD.getCharacterSheet("Paladin").getmaxHealth() <= 0) {
                            Toast.makeText(ActivityDungeonMaster.this, "The monster uses the sword to behead each one of you. You all die instantaneously. YOU LOSE THE GAME!! Try again next time."
                                    , Toast.LENGTH_LONG).show();
                            Intent intent = new Intent(ActivityDungeonMaster.this, DnD.class);
                            startActivity(intent);
                        }
                        if (numberOfMonsters == 0) {
                            Toast.makeText(direction.getContext(), "You are in the mountains. " +
                                            " The coordinates are - (" + x + "," + y + "). " +
                                            "Number of monsters - " + numberOfMonsters + ". "
                                    , Toast.LENGTH_LONG).show();
                        }
                        else {
                            Fighting fighting = dungeonMaster.getFighting();
                            fighting.fighting(terrain.getMonsters()[0]);
                            Toast.makeText(ActivityDungeonMaster.this, "Current Hp: " +
                                            "Monster - " + terrain.getMonsters()[0].getCharacterSheet().getmaxHealth() +
                                            "; Cleric - " + DnD.getCharacterSheet("Cleric").getmaxHealth() +
                                            "; Ranger - " + DnD.getCharacterSheet("Ranger").getmaxHealth() +
                                            "; Paladin - " + DnD.getCharacterSheet("Paladin").getmaxHealth()
                                    , Toast.LENGTH_LONG).show();
                            Toast.makeText(direction.getContext(), "You are in the mountains. " +
                                            "The coordinates are - (" + x + "," + y + "). " +
                                            "Number of monsters - " + numberOfMonsters + ". "
                                    , Toast.LENGTH_LONG).show();
                        }
                    }
                    else {
                        if (DnD.getCharacterSheet("Cleric").getmaxHealth() <= 0 && DnD.getCharacterSheet("Ranger").getmaxHealth() <= 0 && DnD.getCharacterSheet("Paladin").getmaxHealth() <= 0) {
                            Toast.makeText(ActivityDungeonMaster.this, "The monster uses the sword to behead each one of you. You all die instantaneously. YOU LOSE THE GAME!! Try again next time."
                                    , Toast.LENGTH_LONG).show();
                            Intent intent = new Intent(ActivityDungeonMaster.this, DnD.class);
                            startActivity(intent);
                        }
                        if (numberOfMonsters == 0) {
                            Toast.makeText(direction.getContext(), "You see Oriana standing on a rock. " +
                                    "The cleric grabs her hand, and you and your party find yourself back into the mission giver's home. " +
                                    "The mission giver thanks you for finding his daughter and returning her, gives you some money, and leaves the room. " +
                                    "YOU WIN THE GAME!!"
                                    , Toast.LENGTH_LONG).show();
                            Intent intent = new Intent(ActivityDungeonMaster.this, DnD.class);
                            startActivity(intent);
                        }
                        else {
                            Fighting fighting = dungeonMaster.getFighting();
                            fighting.fighting(terrain.getMonsters()[0]);
                            Toast.makeText(ActivityDungeonMaster.this, "Current Hp: " +
                                            "Monster - " + terrain.getMonsters()[0].getCharacterSheet().getmaxHealth() +
                                            "; Cleric - " + DnD.getCharacterSheet("Cleric").getmaxHealth() +
                                            "; Ranger - " + DnD.getCharacterSheet("Ranger").getmaxHealth() +
                                            "; Paladin - " + DnD.getCharacterSheet("Paladin").getmaxHealth()
                                    , Toast.LENGTH_LONG).show();
                            Toast.makeText(direction.getContext(), "Your party straggles over to Oriana, bleeding. A monster jumps in front of your party, and just before it claws you to death, " +
                                            "Oriana waves her hand, and the monster spontaneously bursts apart in flames, leaving a bloody heap in front of your party. " +
                                            "You nod your head to Oriana, as if to thank her, just as you collapse on the ground, convulsing blood. " +
                                            "The next thing you know, you and your party are back at your mission giver's home, fully healed. " +
                                            "The mission giver says, 'Thank you, kind sir, for finding my daughter and bringing her back to me. " +
                                            "Thou will forever be in our hearts.' " +
                                            "YOU WIN THE GAME!!"
                                    , Toast.LENGTH_LONG).show();
                            Intent intent = new Intent(ActivityDungeonMaster.this, DnD.class);
                            startActivity(intent);
                        }
                    }
                }

                else if (terrain instanceof Forest) {
                    if (DnD.getCharacterSheet("Cleric").getmaxHealth() <= 0 && DnD.getCharacterSheet("Ranger").getmaxHealth() <= 0 && DnD.getCharacterSheet("Paladin").getmaxHealth() <= 0) {
                        Toast.makeText(ActivityDungeonMaster.this, "The monster uses the sword to behead each one of you. You all die instantaneously. YOU LOSE THE GAME!! Try again next time."
                                , Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(ActivityDungeonMaster.this, DnD.class);
                        startActivity(intent);
                    }
                    if (numberOfMonsters == 0) {
                        Toast.makeText(direction.getContext(), "You are in the forest. " +
                                        " The coordinates are - (" + x + "," + y + "). " +
                                        "Number of monsters - " + numberOfMonsters + ". "
                                , Toast.LENGTH_LONG).show();
                    }
                    else {
                        Fighting fighting = dungeonMaster.getFighting();
                        fighting.fighting(terrain.getMonsters()[0]);
                        Toast.makeText(ActivityDungeonMaster.this, "Current Hp: " +
                                        "Monster - " + terrain.getMonsters()[0].getCharacterSheet().getmaxHealth() +
                                        "; Cleric - " + DnD.getCharacterSheet("Cleric").getmaxHealth() +
                                        "; Ranger - " + DnD.getCharacterSheet("Ranger").getmaxHealth() +
                                        "; Paladin - " + DnD.getCharacterSheet("Paladin").getmaxHealth()
                                , Toast.LENGTH_LONG).show();
                        Toast.makeText(direction.getContext(), "You are in the forest. " +
                                        "The coordinates are - (" + x + "," + y + "). " +
                                        "Number of monsters - " + numberOfMonsters + ". "
                                , Toast.LENGTH_LONG).show();
                    }
                }
            }
        });



        Button fightButton = (Button)findViewById(R.id.fightButton);
        fightButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // What happens after clicking the fight button, displaying different things depending on the circumstances.
                if (terrain.getMonsters().length == 0) {
                    Toast.makeText(ActivityDungeonMaster.this, "You take a look around the area, and you don't see any monsters. "
                            , Toast.LENGTH_LONG).show();
                    return;
                }
                if (terrain.getMonsters()[0].getCharacterSheet().getmaxHealth() <= 0) {
                        Toast.makeText(ActivityDungeonMaster.this, "The ranger and paladin shoot the monster with their bows, making a satisfying sound as each arrow strikes the beast's chest. " +
                                "Suddenly, another arrow whistles through the bushes, dealing the death blow to the already moribund monster. " +
                                "The cleric steps out, her bow in hand. "
                                , Toast.LENGTH_LONG).show();
                        return;
                }
                Fighting fighting = dungeonMaster.getFighting();
                fighting.fighting(terrain.getMonsters()[0]);
                if (DnD.getCharacterSheet("Cleric").getmaxHealth() <= 0 && DnD.getCharacterSheet("Ranger").getmaxHealth() <= 0 && DnD.getCharacterSheet("Paladin").getmaxHealth() <= 0) {
                    Toast.makeText(ActivityDungeonMaster.this, "The monster uses the sword to behead each one of you. " +
                            "You all die instantaneously. " +
                            "YOU LOSE THE GAME!! " +
                            "Try again next time."
                            , Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(ActivityDungeonMaster.this, DnD.class);
                    startActivity(intent);
                }
                Toast.makeText(ActivityDungeonMaster.this, "Current Hp: " +
                        "Monster - " + terrain.getMonsters()[0].getCharacterSheet().getmaxHealth() +
                        "; Cleric - " + DnD.getCharacterSheet("Cleric").getmaxHealth() +
                        "; Ranger - " + DnD.getCharacterSheet("Ranger").getmaxHealth() +
                        "; Paladin - " + DnD.getCharacterSheet("Paladin").getmaxHealth()
                        , Toast.LENGTH_LONG).show();
            }
        });

    }


}

