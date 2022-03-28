package edu.kit.informatik.phase;

import edu.kit.informatik.Combat;
import edu.kit.informatik.Game;
import edu.kit.informatik.model.GamePhase;
import edu.kit.informatik.model.QuitException;
import edu.kit.informatik.ui.UserInterface;
import edu.kit.informatik.util.GameData;
import edu.kit.informatik.util.Level;

/**
 * 
 * Die Klasse ändert den Raum bzw. das Level
 * 
 * @author uwlhp
 * @version 1.0.0
 * 
 */

public class ChangeStagePhase implements GamePhase {

    private Game game;
    private UserInterface input;

    private GameData data = GameData.getInstance();

    /**
     * Konstruktor
     * 
     * @param game  das Spiel
     * @param input das Inputobjekt
     */
    public ChangeStagePhase(Game game, UserInterface input) {
        this.game = game;
        this.input = input;
    }

    @Override
    public void start() throws QuitException {
        Combat combat;
        if (game.getLevel() >= data.getMaxLevel() && game.getStage() == data.getMaxStage()) {
            game.setGamePhase(new FinishedPhase());
            return;
        }
        game.setStage(game.getStage() + 1);
        int monsterCount = data.getMonsterCount(game.getStage());
        if (game.getStage() < data.getMaxStage()) {
            combat = new Combat(game.getRuna(), game.getCard().pullMonster(monsterCount));
            game.setGamePhase(new CombatPhase(game, input, combat));
        } else if (game.getStage() == data.getMaxStage()) {
            combat = new Combat(game.getRuna(), game.getCard().pullBoss());
            game.setGamePhase(new CombatPhase(game, input, combat));
        } else {
            game.setStage(1);
            game.setLevel(game.getLevel() + 1);
            int[] seeds = input.getSeed();
            Level levelCards = new Level(seeds, game.getLevel(), game.getRuna().getHeroClass(),
                    data);
            game.setCard(levelCards);
            monsterCount = data.getMonsterCount(game.getStage());
            Combat newCombat = new Combat(game.getRuna(), game.getCard().pullMonster(monsterCount));
            game.setGamePhase(new CombatPhase(game, input, newCombat));
        }

        input.printLevel(game.getStage(), game.getLevel());
        game.nextGamePhase();

    }
}
