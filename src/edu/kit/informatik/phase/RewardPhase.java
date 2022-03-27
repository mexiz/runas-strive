package edu.kit.informatik.phase;

import java.util.ArrayList;
import java.util.List;

import edu.kit.informatik.Game;
import edu.kit.informatik.GameData;
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
    
    private GameData data = GameData.getInstance();

    public RewardPhase(Game game, UserInterface input) {
        this.game = game;
        this.input = input;
    }

    @Override
    public void start() {
        if (game.getLevel() == maxLevel && game.getStage() == maxStage) {
            game.setFinished(true);
            return;
        }else if (game.getStage() == 4) {
            List<Ability> upgradeAbility = game.getRuna().getHeroClass().getAbilities(game.getLevel() + 1);
            for (Ability ability : upgradeAbility) {
                input.printNewAbility(ability);
                game.getRuna().addAbility(ability);
            }
            heal();
            game.setGamePhase(new ChangeStagePhase(game, input));
            return;
        }

        int rewardNumber = 1;

        if (game.getRuna().upgradeDice()) {
            rewardNumber = input.selectRewardType();
            if (input.quit()) {
                game.setFinished(true);
                return;
            }
        }
        switch (rewardNumber) {
            case 1:
                int countCards = data.getMonsterCount(game.getStage());
                List<Ability> newAbility = game.getCard().pullAbility(2 * countCards);
                int[] choosed = input.selectReward(newAbility, countCards);
                if (input.quit()) {
                    game.setFinished(true);
                    return;
                }
                for (int i = 0; i < choosed.length; i++) {
                    Ability ability = newAbility.get(choosed[i] - 1);
                    game.getRuna().addAbility(ability);
                    input.printNewAbility(ability);
                }
                break;
            case 2:
                game.getRuna().changeDice();
                input.print("Runa upgrades her die to a d" + game.getRuna().getDice());
                break;
            default:
                break;
        }

        

        heal();
        game.setGamePhase(new ChangeStagePhase(game, input));
        
    }

    /**
     * FÜhrt die Heilung aus
     * 
     * @return ob die Heilung ausgeführt wurde
     */
    private boolean heal() {
        if (game.getRuna().getHealth() == 50) {
            return false;
        }
        int[] remove = input.selectCardsToHeal(game.getRuna().getHealth(), 50, game.getRuna().getAbilities());
        if (input.quit()) {
            game.setFinished(true);
            return false;
        }
        List<Ability> test = new ArrayList<>();
        for (int i = 0; i < remove.length; i++) {
            test.add(game.getRuna().getAbilities().get(remove[i] - 1));
        }
        game.getRuna().getAbilities().removeAll(test);
        int heal = remove.length * 10;
        game.getRuna().setHealth(game.getRuna().getHealth() + heal);
        input.printHeal(heal);
        return true;

    }
}