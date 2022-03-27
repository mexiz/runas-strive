package edu.kit.informatik.phase;

import edu.kit.informatik.Combat;
import edu.kit.informatik.Game;
import edu.kit.informatik.model.Ability;
import edu.kit.informatik.model.AttackType;
import edu.kit.informatik.model.CardType;
import edu.kit.informatik.model.GamePhase;
import edu.kit.informatik.model.Monster;
import edu.kit.informatik.ui.UserInterface;

/**
 * 
 * Die Klasse führt eine Kampf zwischen Runa und den Monstern aus
 * 
 * @author uwlhp
 * @version 1.0.0
 * 
 */

public class CombatPhase implements GamePhase {

    private Game game;
    private UserInterface input;
    private Combat combat;

    /**
     * Konstruktor
     * 
     * @param game   das Spiel
     * @param input  das Inputobjekt
     * @param combat der Kampf
     */
    public CombatPhase(Game game, UserInterface input, Combat combat) {
        this.game = game;
        this.input = input;
        this.combat = combat;
    }

    @Override
    public void start() {
        input.printStatus(combat.getEnemies(), game.getRuna().getHealth(), game.getRuna().getFocus(),
                game.getRuna().getDice());

        int index = input.selectRunasAbility(game.getRuna().getAbilities());
        if (input.quit()) {
            game.setFinished(true);
            return;
        }

        Ability choosedAbility = game.getRuna().getAbilities().get(index - 1);
        game.getRuna().setCurrentAbility(choosedAbility);

        if (!choosedAbility.getCardType().equals(CardType.OFFENSIVE)) {
            input.printUsedAbility("Runa", choosedAbility);
        }
        if (choosedAbility.getCardType().equals(CardType.OFFENSIVE) && !executeRuna(choosedAbility)) {
            game.setFinished(true);
            return;
        }
        for (int i = 0; i < combat.getEnemies().size(); i++) {
            int focus = combat.monsterFocusPoints(i);
            if (focus > 0) {
                input.printFocusPoint(combat.getEnemies().get(i).getName(), focus);
            }
        }
        if (!executeMonster()) {
            game.setFinished(true);
            return;
        }
        int focusPoint = combat.handleFokus();
        if (focusPoint > 0) {
            input.printFocusPoint("Runa", focusPoint);
        }

        if (combat.finished()) {
            game.setGamePhase(new RewardPhase(game, input));
        }

    }

    /**
     * Führt Runaszug aus
     * 
     * @param choosedAbility die gewählte Fähigkeit
     * @return ob Runaszug ausgeführt wurde
     */
    private boolean executeRuna(Ability choosedAbility) {
        // target
        int runaAttackTarget = 0;
        if (combat.getEnemies().size() != 1) {
            runaAttackTarget = input.selectTarget(combat.getEnemies()) - 1;
        }
        if (input.quit()) {
            return false;
        }
        // uses
        input.printUsedAbility("Runa", choosedAbility);
        // dice
        int dice = 0;
        if (choosedAbility.getAttackType().equals(AttackType.PHYS)) {
            dice = input.getDice(1, game.getRuna().getDice());
            if (input.quit()) {
                game.setFinished(true);
                return false;
            }
        }

        // execute
        int damageMonster = combat.runaAttacks(choosedAbility, runaAttackTarget, dice);

        Monster runaEnemie = combat.getEnemies().get(runaAttackTarget);
        input.printDamge(runaEnemie.getName(), damageMonster, choosedAbility.getAttackType());
        if (runaEnemie.dead()) {
            input.printDies(runaEnemie.getName());
            combat.getEnemies().remove(runaAttackTarget);
        }
        return true;
    }

    /**
     * Führt die Züge der Monster aus
     *
     * @return ob die Züge der Monster ausgeführt wurden
     */
    private boolean executeMonster() {

        for (int i = 0; i < combat.getEnemies().size(); i++) {

            int damageToRuna = combat.attackFromMonster(i);
            if (input.quit()) {
                game.setFinished(true);
                return false;
            }
            input.printUsedAbility(combat.getEnemies().get(i).getName(),
                    combat.getEnemies().get(i).getCurrentAbility());
            if (damageToRuna > 0) {
                input.printDamge("Runa", damageToRuna, combat.getEnemies().get(i).getCurrentAbility().getAttackType());
            }
            if (game.getRuna().dead()) {
                input.printDies("Runa");
                game.setCard(null);
                return false;
            }
            combat.getEnemies().get(i).changeAbility();
        }
        return true;
    }

}
