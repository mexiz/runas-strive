package edu.kit.informatik.phase;

import edu.kit.informatik.Combat;
import edu.kit.informatik.Game;
import edu.kit.informatik.LevelCards;
import edu.kit.informatik.model.GamePhase;
import edu.kit.informatik.ui.UserInterface;

public class StageChangePhase extends GamePhase {

    private Game game;
    private UserInterface input;
    private int maxLevel = 2;

    public StageChangePhase(Game game, UserInterface input) {
        this.game = game;
        this.input = input;
    }

    @Override
    public void start(){
        Combat combat;
        game.setStage(game.getStage() + 1);

        if (game.getLevel() >= maxLevel && game.getStage() == 4) {
            game.setGamePhase(new GameOverPhase(game, input));
            game.nextGamePhase();
            return;
        }

        switch (game.getStage()) {
            case 1:
                combat = new Combat(game.getRuna(), game.getCard().pullMonster(1));
                game.setGamePhase(new CombatPhase(game, input, combat));
                break;
            case 2:
                combat = new Combat(game.getRuna(), game.getCard().pullMonster(2));
                game.setGamePhase(new CombatPhase(game, input, combat));
                break;
            case 3:
                combat = new Combat(game.getRuna(), game.getCard().pullMonster(2));
                game.setGamePhase(new CombatPhase(game, input, combat));
                break;
            case 4:
                combat = new Combat(game.getRuna(), game.getCard().pullBoss());
                game.setGamePhase(new CombatPhase(game, input, combat));
                break;
            case 5:
                game.setStage(0);
                game.setLevel(game.getLevel() + 1);
                int[] seeds = input.getSeed();
                if (input.quit()) {
                    return;
                }
                LevelCards levelCards = new LevelCards(seeds, game.getLevel(), game.getRuna().getHeroClass());
                game.setCard(levelCards);
                combat = new Combat(game.getRuna(), game.getCard().pullBoss());
                game.setGamePhase(new CombatPhase(game, input, combat));
                break;
            default:
                break;
        }

        input.printLevel(game.getStage(), game.getLevel());
        game.nextGamePhase();

    }


}
