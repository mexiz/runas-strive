package edu.kit.informatik.phase;

import edu.kit.informatik.Game;
import edu.kit.informatik.LevelCards;
import edu.kit.informatik.Runa;
import edu.kit.informatik.model.GamePhase;
import edu.kit.informatik.ui.UserInterface;

public class StartPhase extends GamePhase {

    private Game game;
    private UserInterface input;

    public StartPhase(Game game, UserInterface input) {
        this.game = game;
        this.input = input;
    }

    @Override
    public void start() {
        int choosedNumber = input.getStartHero(1, game.getHeroclass().size(), game.getHeroclass());
        if (input.quit()) {
            return;
        }
        game.setRuna(new Runa(game.getHeroclass().get(choosedNumber - 1)));
        int[] seeds = input.getSeed();
        if (input.quit()) {
            return;
        }
        LevelCards levelCards = new LevelCards(seeds, game.getLevel(), game.getRuna().getHeroClass());
        game.setCard(levelCards);
        game.setGamePhase(new StageChangePhase(game, input));
        game.nextGamePhase();
    }

}
