package edu.kit.informatik.phase;

import edu.kit.informatik.Combat;
import edu.kit.informatik.Game;
import edu.kit.informatik.GameData;
import edu.kit.informatik.Level;
import edu.kit.informatik.model.GamePhase;
import edu.kit.informatik.ui.UserInterface;

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
    public void start() {
        Combat combat;
        game.setStage(game.getStage() + 1);

        if (game.getLevel() >= data.getMaxLevel() && game.getStage() == data.getMaxStage()) {
            // game.setGamePhase(new GameOverPhase(game, input));
            // game.nextGamePhase();
            game.setGamePhase(null);
            return;
        }
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
            if (input.quit()) {
                game.setFinished(true);
                return;
            }
            Level levelCards = new Level(seeds, game.getLevel(), game.getRuna().getHeroClass(),
                    data);
            game.setCard(levelCards);
            monsterCount = data.getMonsterCount(game.getStage());
            Combat newCombat = new Combat(game.getRuna(), game.getCard().pullMonster(monsterCount));
            game.setGamePhase(new CombatPhase(game, input, newCombat));
        }

        input.printLevel(game.getStage(), game.getLevel());

    }
}
