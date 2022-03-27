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
     * a
     */
    MESSAGE_START_FIRST("Welcome to Runa's Strive\nSelect Runa's character class"),
    /**
     * a
     */
    MESSAGE_START_SECOND(
            "To shuffle ability cards and monsters, enter two seeds\nEnter seeds [%d--%d] separated by comma:"),
    /**
     * a
     */
    MESSAGE_NUMBER("Enter number [%d--%d]:"),
    /**
     * a
     */
    MESSAGE_DICE("Enter dice roll [%d--%d]:"),
    /**
     * a
     */
    MESSAGE_DICE_UPGRADE("Runa upgrades her die to a d%d"),
    /**
     * a
     */
    MESSAGE_REWARD("Choose Runa's reward\n1) new ability cards\n2) next player dice"),
    /**
     * a
     */
    MESSAGE_LINE_SEPERATOR("----------------------------------------"),
    /**
     * a
     */
    MESSAGE_VERSUS("vs."),
    /**
     * a
     */
    MESSAGE_RUNA_TARGET("Select Runa's target."),
    /**
     * a
     */
    FOCUSPOINT("%s gains %d focus"),
    /**
     * a
     */
    COMBAT_RUNA_ABILITY("Select card to play"),
    /**
     * a
     */
    COMBAT_ABILITY_USE("%s uses %s"),
    /**
     * a
     */
    REWARD_NEW_ABILITY("Runa gets %s"),
    /**
     * a
     */
    REWARD_HEAL("Runa gains %d health"),
    /**
     * a
     */
    MESSAGE_TAKE_DAMAGE("%s takes %d %s damage"),
    /**
     * a
     */
    STAGE_START("Runa enters Stage %d of Level %d"),
    /**
     * a
     */
    PICK_CARD("Pick %d card(s) as loot"),
    /**
     * a
     */
    ENTER_NUMBER("Enter numbers [%d--%d] separated by comma:"),
    /**
     * a
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