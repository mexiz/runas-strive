package edu.kit.informatik;

import edu.kit.informatik.model.GamePhase;
import edu.kit.informatik.phase.StartPhase;
import edu.kit.informatik.ui.UserInterface;

/**
 * Das Spiel
 * 
 * @author uwlhp
 * @version 1.0.0
 */

public class Game {

    private GamePhase gamePhase;

    private Runa runa;

    private Level levelCards;

    private int currentLevel;
    private int currentStage;

    /**
     * Konstruktor
     */
    public Game() {
        this.gamePhase = new StartPhase(this, new UserInterface());
        this.currentLevel = 1;
        this.currentStage = 0;
    }

    /**
     * Getter für das Spiellevel
     * 
     * @return int das Level
     */
    public int getLevel() {
        return currentLevel;
    }

    /**
     * Setzt das Level des Spiels
     * 
     * @param level das Spiellevel
     */
    public void setLevel(int level) {
        this.currentLevel = level;
    }

    /**
     * Getter für die Raumnummer
     * 
     * @return int die Raumnummer
     */
    public int getStage() {
        return currentStage;
    }

    /**
     * Setzt den Raum des Spiels
     * 
     * @param stage der Raum des Spiels
     */
    public void setStage(int stage) {
        this.currentStage = stage;
    }

    /**
     * Setzt Runa
     * 
     * @param runa Runa
     */
    public void setRuna(Runa runa) {
        this.runa = runa;
    }

    /**
     * Getter für Runa
     * 
     * 
     * @return Runa Runa
     */
    public Runa getRuna() {
        return runa;
    }

    /**
     * Die Karten des Spieles
     * 
     * @return LevelCards die Karten des Spieles
     */
    public Level getCard() {
        return levelCards;
    }

    /**
     * Setzt die Karten des Spieles
     * 
     * @param card die Karte des Spieles
     */
    public void setCard(Level card) {
        this.levelCards = card;
    }

    /**
     * Führt die nächste Phase des Spiels aus
     * 
     */
    public void nextGamePhase() {
        if (gamePhase != null) {
            try {
                gamePhase.start();
            } catch (QuitException e) {
                return;
            }
        }

    }

    /**
     * Setzt die Spielphase
     * 
     * @param gamePhase die Spielphase
     */
    public void setGamePhase(GamePhase gamePhase) {
        this.gamePhase = gamePhase;
    }

}
