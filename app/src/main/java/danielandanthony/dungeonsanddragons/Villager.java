package danielandanthony.dungeonsanddragons;

/**
 * This is class Villager. It answers questions from the user interface.
 */
public class Villager extends Character {
    /**
     * Answer to the question "Have you seen Oriana before?"
     */
    private String[] answerToHaveYouSeenOrianaBefore = {
            "Who's Oriana?",
            "Who's Oriana?",
            "Who's Oriana?",
            "Who's Oriana?",
            "Who's Oriana?",
            "Yes.",
            "Yes.",
            "Yes.",
            "Yes.",
            "Yes.",
            "Yes.",
            "Yes.",
            "Yes.",
            "Yes.",
            "Yes.",
            "Yes.",
            "Yes.",
            "Yes.",
            "Yes.",
            "Yes.",
    };
    /**
     * Answer to the question "Where did you last see Oriana?"
     */
    private String[] answerToWhereDidYouLastSeeOriana = {
            "Why should I tell you?",
            "Why should I tell you?",
            "Why should I tell you?",
            "Why should I tell you?",
            "Why should I tell you?",
            "Why should I tell you?",
            "Why should I tell you?",
            "Why should I tell you?",
            "Why should I tell you?",
            "Why should I tell you?",
            "Somewhere in the mountains",
            "Somewhere in the mountains",
            "Somewhere in the mountains",
            "Somewhere in the mountains",
            "Somewhere in the mountains",
            "Somewhere in the mountains",
            "Somewhere in the mountains",
            "Somewhere in the mountains",
            "Somewhere in the mountains",
            "Somewhere in the mountains",
    };
    /**
     * Answer to the question "When did you last see Oriana?"
     */
    private String[] answerToWhenDidYouLastSeeOriana = {
            "Why should I tell you?",
            "Why should I tell you?",
            "Why should I tell you?",
            "Why should I tell you?",
            "Why should I tell you?",
            "A month ago.",
            "A month ago.",
            "A month ago.",
            "A month ago.",
            "A month ago.",
            "A month ago.",
            "A month ago.",
            "A month ago.",
            "A month ago.",
            "A month ago.",
            "A month ago.",
            "A month ago.",
            "A month ago.",
            "A month ago.",
            "A month ago.",
    };
    /**
     * Answer to the question "Tell us what you know about Oriana."
     */
    private String[] answerToTellUsWhatYouKnowAboutOriana = {
            "Why should I tell you?",
            "Why should I tell you?",
            "Why should I tell you?",
            "Why should I tell you?",
            "Why should I tell you?",
            "Why should I tell you?",
            "Why should I tell you?",
            "Why should I tell you?",
            "Why should I tell you?",
            "Why should I tell you?",
            "Why should I tell you?",
            "Why should I tell you?",
            "Why should I tell you?",
            "Why should I tell you?",
            "Why should I tell you?",
            "I've heard that Oriana is a very powerful Cleric, and she dwells up in the mountains, with every monster under her control. Also, she is a very kind and gentle person, " +
                    "although some people are angry at her, because she has hurt some people's families by accident.",
            "I've heard that Oriana is a very powerful Cleric, and she dwells up in the mountains, with every monster under her control. Also, she is a very kind and gentle person, " +
                    "although some people are angry at her, because she has hurt some people's families by accident.",
            "I've heard that Oriana is a very powerful Cleric, and she dwells up in the mountains, with every monster under her control. Also, she is a very kind and gentle person, " +
                    "although some people are angry at her, because she has hurt some people's families by accident.",
            "I've heard that Oriana is a very powerful Cleric, and she dwells up in the mountains, with every monster under her control. Also, she is a very kind and gentle person, " +
                    "although some people are angry at her, because she has hurt some people's families by accident.",
            "I've heard that Oriana is a very powerful Cleric, and she dwells up in the mountains, with every monster under her control. Also, she is a very kind and gentle person, " +
                    "although some people are angry at her, because she has hurt some people's families by accident.",
    };

    /**
     * Answering questions depending on dice roll.
     * @param question The question (from the spinner) asked.
     * @return Either an answer depending on dice roll, or nothing if a different question is asked.
     */
    public String ask (String question) {
        int diceValue = new Dice(20).rollDice();
        if (question.equals("Have you seen Oriana before?")) {
            return answerToHaveYouSeenOrianaBefore[diceValue];
        }
        else if (question.equals("Where did you last see Oriana?")) {
            return answerToWhereDidYouLastSeeOriana[diceValue];
        }
        else if (question.equals("When did you last see Oriana?")) {
            return answerToWhenDidYouLastSeeOriana[diceValue];
        }
        else if (question.equals("Tell us what you know about Oriana.")) {
            return answerToTellUsWhatYouKnowAboutOriana[diceValue];
        }
        return null;
    }
}
