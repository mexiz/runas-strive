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
     * @throws Exception
     */
    public static void main(String[] args) {
        if (args.length != 0) {
            System.err.println("Error, Game does not allow inputs");
            return;
        }
        Game game = new Game();
        game.nextGamePhase();

    }
}
