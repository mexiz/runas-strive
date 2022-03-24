package edu.kit.informatik.phase;

import edu.kit.informatik.Combat;
import edu.kit.informatik.Game;
import edu.kit.informatik.model.Ability;
import edu.kit.informatik.model.CardType;
import edu.kit.informatik.model.GamePhase;
import edu.kit.informatik.model.Monster;
import edu.kit.informatik.ui.UserInterface;

public class CombatPhase extends GamePhase {

    private Game game;
    private UserInterface input;
    private Combat combat;

    public CombatPhase(Game game, UserInterface input, Combat combat) {
        this.game = game;
        this.input = input;
        this.combat = combat;
    }

    @Override
    public void start() {
        status();

        // AUSWAHL RUNA ATTAACK
        int index = input.getRunaAbility(game.getRuna().getAbilities());
        if (input.quit()) {
            return;
        }
        Ability choosedAbility = game.getRuna().getAbilities().get(index - 1);
        // RUNA
        if (choosedAbility.getCardType().equals(CardType.OFFENSIVE)) {
            // target
            int runaAttackTarget = 0;
            if (combat.getEnemies().size() != 1) {
                runaAttackTarget = input.getTargetMonster(combat.getEnemies()) - 1;
                if (input.quit()) {
                    return;
                }
            }
            // uses
            input.printUsedAbility("Runa", choosedAbility);
            // dice
            int dice = input.getDice(1, 4);
            if (input.quit()) {
                return;
            }
            // execute
            int damageMonster = combat.attackFromRuna(choosedAbility, runaAttackTarget, dice);

            Monster runaEnemie = combat.getEnemies().get(runaAttackTarget);
            input.printDamge(runaEnemie.getName(), damageMonster, choosedAbility.getAttackType());
            if (runaEnemie.dead()) {
                input.printDies(runaEnemie.getName());
                combat.getEnemies().remove(runaAttackTarget);
            }
        } else {
            combat.setRunasCurrentAbility(choosedAbility);
            input.printUsedAbility("Runa", choosedAbility);
        }
        // MONSTER
        for (int i = 0; i < combat.getEnemies().size(); i++) {
            int damageToRuna = combat.attackFromMonster(i);
            if (input.quit()) {
                return;
            }
            input.printUsedAbility(combat.getEnemies().get(i).getName(),
                    combat.getEnemies().get(i).getCurrentAbility());
            if (damageToRuna > 0) {
                input.printDamge("Runa", damageToRuna, combat.getEnemies().get(i).getCurrentAbility().getAttackType());
            }
            combat.getEnemies().get(i).changeAbility();
        }
        if (combat.finished()) {
            game.setGamePhase(new RewardPhase(game, input));
        }
        game.nextGamePhase();
    }

    private void status() {
        input.printStatus(combat.getEnemies(), game.getRuna().getHealth(), game.getRuna().getFocus());
    }

}
