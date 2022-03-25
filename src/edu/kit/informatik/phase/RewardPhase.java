package edu.kit.informatik.phase;

import java.util.ArrayList;
import java.util.List;

import edu.kit.informatik.Game;
import edu.kit.informatik.model.Ability;
import edu.kit.informatik.model.GamePhase;
import edu.kit.informatik.ui.UserInterface;

/**
 * 
 * Die Klasse gibt Runa ihre Belohunung
 * 
 * @author uwlhp
 * @version 1.0.0
 * 
 */

public class RewardPhase implements GamePhase {

    private Game game;
    private UserInterface input;
    private int maxLevel = 2;
    private int maxStage = 4;

    public RewardPhase(Game game, UserInterface input) {
        this.game = game;
        this.input = input;
    }

    @Override
    public void start() {
        if (game.getLevel() == maxLevel && game.getStage() == maxStage) {
            game.setFinished(true);
            return;
        }
        int rewardNumber = 1;
        if (game.getRuna().isMaxDice()) {
            rewardNumber = input.selectRewardType();
        }

        if (rewardNumber == 1) {
            int countCards = game.monsterPerStage.get(game.getStage());
            List<Ability> newAbility = game.getCard().pullAbility(2 * countCards);

            int[] choosed = input.selectReward(newAbility, countCards);
            for (int i = 0; i < choosed.length; i++) {
                Ability ability = newAbility.get(choosed[i] - 1);
                game.getRuna().addAbility(ability);
                input.printNewAbility(ability);
            }
        }
        if (rewardNumber == 2) {
            game.getRuna().changeDice();
            input.print("Runa upgrades her die to a d" + game.getRuna().getDice());
        }

        int[] remove = input.selectCardsToHeal(game.getRuna().getHealth(), 50, game.getRuna().getAbilities());
        List<Ability> test = new ArrayList<>();
        for (int i = 0; i < remove.length; i++) {
            test.add(game.getRuna().getAbilities().get(remove[i] - 1));
        }
        game.getRuna().getAbilities().removeAll(test);
        int heal = remove.length * 10;
        game.getRuna().setHealth(game.getRuna().getHealth() + heal);
        input.printHeal(heal);
        game.setGamePhase(new StageChangePhase(game, input));
        game.nextGamePhase();
    }
}