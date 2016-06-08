        package danielandanthony.dungeonsanddragons;

        /**
         * This class is what sets each part of the character sheet to a variable.
         */
        public class CharacterSheet {

            String currentCharacter;

            private String name;
            // Default values for all characters not set in the program.
            int maxHealth = 14;
            int armorClass = 14;
            int con = 14;
            // For Health
            int str = 14;
            // For Attack (Sword)
            int dex = 14;
            // For Attack (Bow)
            int inT = 14;
            // For Knowledge - THE POWER OF THE UNIVERSE (IF YOU HAVE TOO MUCH, YOUR
            // BRAIN WILL EXPLODE)
            int wis = 14;
            // For Spells
            int cha = 14;
            // For Communication
            int conMod = ((con - 10) / 2);
            int strMod = ((str - 10) / 2);
            int dexMod = ((dex - 10) / 2);
            int intMod = ((inT - 10) / 2);
            int wisMod = ((wis - 10) / 2);
            int chaMod = ((cha - 10) / 2);
            int swordAttackBonus = 2;
            // Amount Added to Sword Attacks
            int bowAttackBonus = 2;
            // Amount Added to Bow Attacks
            int spellDamageBonus = 2;
            // Amount of Damage Spell Cast By Certain Character Deals
            int swordDamageBonus = 2;
            // Amount of Damage Sword Used By Certain Character Deals
            int bowDamageBonus = 2;
            // Amount of Damage Arrow Shot By Certain Character Deals
            int spellHealingBonus = 2;
            // Amount of Health Restored By Cleric's Magic
            int arrows = 2;
            // Amount of Arrows the Character Has
            int spellsPerDay = 2;
            // Amount of Spells the Character May Cast Per Day

            /**
             * The gets and sets for each character sheet value.
             */
            public CharacterSheet(String name) {
                this.name = name;
            }

            public void setspellsPerDay(int spellsPerDay) {
                this.spellsPerDay = spellsPerDay;
            }

            public int getspellsPerDay() {
                return this.spellsPerDay;
            }

            public void setarrows(int arrows) {
                this.arrows = arrows;
            }

            public int getarrows() {
                return this.arrows;
            }

            public void setspellHealingBonus(int spellHealingBonus) {
                this.spellHealingBonus = spellHealingBonus;
            }

            public int getspellHealingBonus() {
                return this.spellHealingBonus;
            }

            public void setbowDamageBonus(int bowDamageBonus) {
                this.bowDamageBonus = bowDamageBonus;
            }

            public int getbowDamageBonus() {
                return this.bowDamageBonus;
            }

            public void setswordDamageBonus(int swordDamageBonus) {
                this.swordDamageBonus = swordDamageBonus;
            }

            public int getswordDamageBonus() {
                return this.swordDamageBonus;
            }

            public void setspellDamageBonus(int spellDamageBonus) {
                this.spellDamageBonus = spellDamageBonus;
            }

            public int getspellDamageBonus() {
                return this.spellDamageBonus;
            }

            public void setbowAttackBonus(int bowAttackBonus) {
                this.bowAttackBonus = bowAttackBonus;
            }

            public int getbowAttackBonus() {
                return this.bowAttackBonus;
            }

            public void setswordAttackBonus(int swordAttackBonus) {
                this.swordAttackBonus = swordAttackBonus;
            }

            public int getswordAttackBonus() {
                return this.swordAttackBonus;
            }

            public void setchaMod(int chaMod) {
                this.chaMod = chaMod;
            }

            public int getchaMod() {
                return this.chaMod;
            }

            public void setwisMod(int wisMod) {
                this.wisMod = wisMod;
            }

            public int getwisMod() {
                return this.wisMod;
            }

            public void setintMod(int intMod) {
                this.intMod = intMod;
            }

            public int getintMod() {
                return this.intMod;
            }

            public void setstrMod(int strMod) {
                this.strMod = strMod;
            }

            public int getstrMod() {
                return this.strMod;
            }

            public void setdexMod(int dexMod) {
                this.dexMod = dexMod;
            }

            public int getdexMod() {
                return this.dexMod;
            }

            public void setconMod(int conMod) {
                this.conMod = conMod;
            }

            public int getconMod() {
                return this.conMod;
            }

            public void setwis(int wis) {
                this.wis = wis;
            }

            public int getwis() {
                return this.wis;
            }

            public void setinT(int inT) {
                this.inT = inT;
            }

            public int getinT() {
                return this.inT;
            }

            public void setcha(int cha) {
                this.cha = cha;
            }

            public int getcha() {
                return this.cha;
            }

            public void setstr(int str) {
                this.str = str;
            }

            public int getstr() {
                return this.str;
            }

            public void setdex(int dex) {
                this.dex = dex;
            }

            public int getdex() {
                return this.dex;
            }

            public void setcon(int con) {
                this.con = con;
            }

            public int getcon() {
                return this.con;
            }

            public void setarmorClass(int armorClass) {
                this.armorClass = armorClass;
            }

            public int getarmorClass() {
                return this.armorClass;
            }

            public void setmaxHealth(int maxHealth) {
                this.maxHealth = maxHealth;
            }

            public int getmaxHealth() {
                return this.maxHealth;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getName() {
                return this.name;
            }

        }