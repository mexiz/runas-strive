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
     * Startnachricht
     */
    MESSAGE_START_FIRST("Welcome to Runa's Strive\nSelect Runa's character class"),
    /**
     * zweite Startnachricht
     */
    MESSAGE_START_SECOND(
            "To shuffle ability cards and monsters, enter two seeds"),
    /**
     * Nachricht für die Nummerabfrage
     */
    MESSAGE_NUMBER("Enter number [%d--%d]:"),
    /**
     * Nachricht für die Würfelabfrage
     */
    MESSAGE_DICE("Enter dice roll [%d--%d]:"),
    /**
     * Nachricht für die Würfel verbesserung
     */
    MESSAGE_DICE_UPGRADE("Runa upgrades her die to a d%d"),
    /**
     * Nachricht für die Auswahl der Belohnungen
     */
    MESSAGE_REWARD("Choose Runa's reward\n1) new ability cards\n2) next player dice"),
    /**
     * Trennzeichen
     */
    MESSAGE_LINE_SEPERATOR("----------------------------------------"),
    /**
     * Versus
     */
    MESSAGE_VERSUS("vs."),
    /**
     * Nachricht für die Gegnerauswahl
     */
    MESSAGE_RUNA_TARGET("Select Runa's target."),
    /**
     * Nachricht für die Fokuspunkte
     */
    FOCUSPOINT("%s gains %d focus"),
    /**
     * Nachricht für die Karte die gespielt werden soll
     */
    COMBAT_RUNA_ABILITY("Select card to play"),
    /**
     * Nachricht für die Karte die gespielt wird
     */
    COMBAT_ABILITY_USE("%s uses %s"),
    /**
     * Nachricht für die erhaltene Karte
     */
    REWARD_NEW_ABILITY("Runa gets %s"),
    /**
     * Heilung von Runa
     */
    REWARD_HEAL("Runa gains %d health"),
    /**
     * Schadensausgabe
     */
    MESSAGE_TAKE_DAMAGE("%s takes %d %s damage"),
    /**
     * Raumbeitritts Nachricht
     */
    STAGE_START("Runa enters Stage %d of Level %d"),
    /**
     * Anzahl der Karten die gezogen werden dürfen
     */
    PICK_CARD("Pick %d card(s) as loot"),
    /**
     * Nummereingabe mit Komma
     */
    ENTER_NUMBER("Enter numbers [%d--%d] separated by comma:"),
    /**
     * Seedseingabe mit Komma
     */
    ENTER_SEEDS("Enter seeds [%d--%d] separated by comma:"),
    /**
     * Runa hat gewonnen
     */
    RUNA_WON("Runa won!"),
    /**
     * Ausgabe das man Karten abgeben kann
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