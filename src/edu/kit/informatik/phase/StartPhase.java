package edu.kit.informatik.phase;

import edu.kit.informatik.Game;
import edu.kit.informatik.GameData;
import edu.kit.informatik.Level;
import edu.kit.informatik.Runa;
import edu.kit.informatik.model.GamePhase;
import edu.kit.informatik.ui.UserInterface;

/**
 * 
 * Die Klasse wird einemal am Anfang erzeugt und ausgeführt
 * 
 * @author uwlhp
 * @version 1.0.0
 * 
 */

public class StartPhase implements GamePhase {

    private Game game;
    private UserInterface input;

    private GameData data = GameData.getInstance();

    /**
     * Konstruktor
     * 
     * @param game  das Spiel
     * @param input Inputobjekt
     */
    public StartPhase(Game game, UserInterface input) {
        this.game = game;
        this.input = input;
    }

    @Override
    public void start() {
        int choosedNumber = input.getStartHero(1, data.getHeroclass().size(), data.getHeroclass());
        if (input.quit()) {
            game.setFinished(true);
            return;
        }
        game.setRuna(new Runa(data.getHeroclass().get(choosedNumber - 1), 1));
        int[] seeds = input.getSeed();
        if (input.quit()) {
            game.setFinished(true);
            return;
        }
        Level levelCards = new Level(seeds, game.getLevel(), game.getRuna().getHeroClass(), data);
        game.setCard(levelCards);
        game.setGamePhase(new ChangeStagePhase(game, input));
    }

}
