package edu.kit.informatik.ui;

/**
 * Enum für die Kommandozeilenausgaben
 * 
 * @author uwhlp
 * @version 1.0.0
 * 
 */

public enum Message {
    /**
     * 
     */
    MESSAGE_START_FIRST("Welcome to Runa's Strive\nSelect Runa's character class"),
    /**
     * 
     */
    MESSAGE_START_SECOND(
            "To shuffle ability cards and monsters, enter two seeds\nEnter seeds [%d--%d] separated by comma:"),
    /**
     * 
     */
    MESSAGE_NUMBER("Enter number [%d--%d]:"),
    /**
     * 
     */
    MESSAGE_DICE("Enter dice roll [%d--%d]:"),
    /**
     * 
     */
    MESSAGE_DICE_UPGRADE("Runa upgrades her die to a d%d"),
    /**
     * 
     */
    MESSAGE_REWARD("Choose Runa's reward\n1) new ability cards\n2) next player dice"),
    /**
     * 
     */
    MESSAGE_LINE_SEPERATOR("----------------------------------------"),
    /**
     * 
     */
    MESSAGE_VERSUS("vs."),
    /**
    * 
    */
    MESSAGE_RUNA_TARGET("Select Runa's target."),
    /**
    * 
    */
    FOCUSPOINT("%s gains %d focus"),
    /**
    * 
    */
    COMBAT_RUNA_ABILITY("Select card to play"),
    /**
    * 
    */
    COMBAT_ABILITY_USE("%s uses %s"),
    /**
    * 
    */
    REWARD_NEW_ABILITY("Runa gets %s"),
    /**
    * 
    */
    REWARD_HEAL("Runa gains %d health"),
    /**
    * 
    */
    MESSAGE_TAKE_DAMAGE("%s takes %d %s damage"),
    /**
    * 
    */
    STAGE_START("Runa enters Stage %d of Level %d"),
    /**
    * 
    */
    PICK_CARD("Pick %d card(s) as loot"),
    /**
    * 
    */
    ENTER_NUMBER("Enter numbers [%d--%d] separated by comma:"),
    /**
    * 
    */
    REWARD_RUNA_HEALING("Runa (%d/%d HP) can discard ability cards for healing (or none)");

    private String outputMessage;

    private Message(final String message) {
        this.outputMessage = message;
    }

    /**
     * Formatiert die Nachrichten
     * 
     * @param args die Argumente
     * @return gibt den String mit den Argumenten zurück
     */
    public String formatted(Object... args) {
        return String.format(outputMessage, args);
    }

    @Override
    public String toString() {
        return outputMessage;
    }
}