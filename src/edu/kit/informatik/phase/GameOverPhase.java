package edu.kit.informatik.phase;

import edu.kit.informatik.Game;
import edu.kit.informatik.model.GamePhase;
import edu.kit.informatik.ui.UserInterface;

public class GameOverPhase extends GamePhase {

    private Game game;
    private UserInterface input;

    public GameOverPhase(Game game, UserInterface input) {
        this.game = game;
        this.input = input;
    }

    @Override
    public void start() {
        System.out.println("TODO");

    }

}
