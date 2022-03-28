package edu.kit.informatik.phase;

import java.util.ArrayList;
import java.util.List;

import edu.kit.informatik.Game;
import edu.kit.informatik.model.GamePhase;
import edu.kit.informatik.model.QuitException;
import edu.kit.informatik.model.ability.Ability;
import edu.kit.informatik.ui.UserInterface;
import edu.kit.informatik.util.GameData;

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

    private GameData data = GameData.getInstance();

    /**
     * Konstruktor
     * 
     * @param game  das Spiel
     * @param input das Inputobjekt
     */
    public RewardPhase(Game game, UserInterface input) {
        this.game = game;
        this.input = input;
    }

    @Override
    public void start() throws QuitException {
        if (game.getLevel() == data.getMaxLevel() && game.getStage() == data.getMaxStage()) {
            input.printWon();
            game.setGamePhase(new FinishedPhase());
            return;
        }

        int rewardNumber = 1;

        if (game.getStage() == data.getMaxStage()) {
            rewardNumber = 3;
        } else if (game.getRuna().upgradeDice()) {
            rewardNumber = input.selectRewardType();
        }

        switch (rewardNumber) {
            case 1:
                int countCards = data.getMonsterCount(game.getStage());
                List<Ability> newAbility = game.getCard().pullAbility(2 * countCards);
                int[] choosed = input.selectReward(newAbility, countCards);
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
            case 3:
                List<Ability> upgradeAbility = game.getRuna().getHeroClass().getAbilities(game.getLevel() + 1);
                for (Ability ability : upgradeAbility) {
                    input.printNewAbility(ability);
                    game.getRuna().addAbility(ability);
                }
                break;
            default:
                break;
        }

        if (game.getRuna().getAbilities().size() > 1 && game.getRuna().getHealth() != data.getMaxHealth()) {
            heal();
        }
        game.setGamePhase(new ChangeStagePhase(game, input));
        game.nextGamePhase();
    }

    /**
     * Führt die Heilung aus
     * 
     * @return ob die Heilung ausgeführt wurde
     */
    private void heal() throws QuitException {

        int[] remove = input.selectCardsToHeal(game.getRuna().getHealth(), data.getMaxHealth(),
                game.getRuna().getAbilities());

        if (remove.length == 0) {
            return;
        }

        List<Ability> test = new ArrayList<>();
        for (int i = 0; i < remove.length; i++) {
            test.add(game.getRuna().getAbilities().get(remove[i] - 1));
        }
        game.getRuna().getAbilities().removeAll(test);
        int heal = remove.length * data.getHealPerCard();
        int countToFullHealth = data.getMaxHealth() - game.getRuna().getHealth();
        if (countToFullHealth < heal) {
            heal = countToFullHealth;
        }

        game.getRuna().setHealth(game.getRuna().getHealth() + heal);
        input.printHeal(heal);
    }
}