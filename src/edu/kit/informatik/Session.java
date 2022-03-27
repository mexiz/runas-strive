package edu.kit.informatik;

/**
 * Die Main-Klasse
 * 
 * @author uwlhp
 * @version 1.0.0
 */
public final class Session {

    private Session() {

    }

    /**
     * Main-Methode
     * 
     * @param args Argumente
     */
    public static void main(String[] args) {
        Game game = new Game();

        while (!game.isFinished()) {
            game.nextGamePhase();
        }
    }
}
