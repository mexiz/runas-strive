package edu.kit.informatik;

import java.util.ArrayList;
import java.util.List;

import edu.kit.informatik.level.Stage;
import edu.kit.informatik.monster.firstlevel.Rat;
import edu.kit.informatik.monster.firstlevel.Spider;

public class Session {

    public static void main(String[] args) {
        Game game = new Game();
        game.setStage(new Stage(new ArrayList<>(List.of(new Spider(), new Rat()))));
        game.nextGamePhase();
    }
}