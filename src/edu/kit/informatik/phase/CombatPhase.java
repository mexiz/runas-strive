package edu.kit.informatik.phase;

import java.util.Iterator;

import edu.kit.informatik.Combat;
import edu.kit.informatik.Game;
import edu.kit.informatik.model.GamePhase;
import edu.kit.informatik.model.Monster;
import edu.kit.informatik.model.QuitException;
import edu.kit.informatik.model.ability.Ability;
import edu.kit.informatik.model.ability.AttackType;
import edu.kit.informatik.model.ability.CardType;
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
    public void start() throws QuitException {
        input.printStatus(combat.getEnemies(), game.getRuna().getHealth(), game.getRuna().getFocus(),
                game.getRuna().getDice());

        int index = input.selectRunasAbility(game.getRuna().getAbilities());

        Ability choosedAbility = game.getRuna().getAbilities().get(index - 1);
        game.getRuna().setCurrentAbility(choosedAbility);

        if (!choosedAbility.getCardType().equals(CardType.OFFENSIVE)) {
            input.printUsedAbility("Runa", choosedAbility);
        }
        if (choosedAbility.getCardType().equals(CardType.OFFENSIVE)) {
            executeRuna(choosedAbility);
        }
        for (int i = 0; i < combat.getEnemies().size(); i++) {
            int focus = combat.monsterFocusPoints(i);
            if (focus > 0) {
                input.printFocusPoint(combat.getEnemies().get(i).getName(), focus);
            }
        }

        if (executeMonster()) {
            game.setGamePhase(new FinishedPhase());
            return;
        }

        int focusPoint = combat.handleFokus();
        if (focusPoint > 0 && !combat.finished()) {
            input.printFocusPoint("Runa", focusPoint);
        }

        if (combat.finished()) {
            game.setGamePhase(new RewardPhase(game, input));
        }
        game.nextGamePhase();
    }

    /**
     * Führt Runaszug aus
     * 
     * @param choosedAbility die gewählte Fähigkeit
     * @return ob Runaszug ausgeführt wurde
     */
    private void executeRuna(Ability choosedAbility) throws QuitException {
        // target
        int runaAttackTarget = 0;
        if (combat.getEnemies().size() != 1) {
            runaAttackTarget = input.selectTarget(combat.getEnemies()) - 1;
        }
        // uses
        input.printUsedAbility("Runa", choosedAbility);
        // dice
        int dice = 0;
        if (choosedAbility.getAttackType().equals(AttackType.PHYS)) {
            dice = input.getDice(1, game.getRuna().getDice());
        }

        // execute
        int damageMonster = combat.runaAttacks(choosedAbility, runaAttackTarget, dice);
        if (damageMonster <= 0) {
            return;
        }

        Monster runaEnemie = combat.getEnemies().get(runaAttackTarget);
        input.printDamge(runaEnemie.getName(), damageMonster, choosedAbility.getAttackType());
        if (runaEnemie.dead()) {
            input.printDies(runaEnemie.getName());
            combat.getEnemies().remove(runaAttackTarget);
        }
    }

    /**
     * Führt die Züge der Monster aus
     *
     * @return ob die Züge der Monster ausgeführt wurden
     */
    private boolean executeMonster() {

        for (int i = 0; i < combat.getEnemies().size(); i++) {

            int[] damage = combat.attackFromMonster(i);

            input.printUsedAbility(combat.getEnemies().get(i).getName(),
                    combat.getEnemies().get(i).getCurrentAbility());

            if (damage[0] > 0) {
                input.printDamge("Runa", damage[0], combat.getEnemies().get(i).getCurrentAbility().getAttackType());
            }
            if (game.getRuna().dead()) {
                input.printDies("Runa");
                game.setCard(null);
                return true;
            }

            if (damage[1] > 0) {
                input.printDamge(combat.getEnemies().get(i).getName(), damage[1],
                        combat.getEnemies().get(i).getCurrentAbility().getAttackType());
            }
            if (combat.getEnemies().get(i).dead()) {
                input.printDies(combat.getEnemies().get(i).getName());
            }
            combat.getEnemies().get(i).changeAbility();

        }

        Iterator<Monster> iter = combat.getEnemies().iterator();
        while (iter.hasNext()) {
            Monster monster = iter.next();
            if (monster.dead()) {
                iter.remove();
            }
        }
        return false;
    }

}
