package edu.kit.informatik;

import java.util.List;

import edu.kit.informatik.abilities.EmptyAbility;
import edu.kit.informatik.model.Ability;
import edu.kit.informatik.model.AttackType;
import edu.kit.informatik.model.CardType;
import edu.kit.informatik.model.Monster;

/**
 * 
 * @author uwlhp
 * @version 1.0.0
 */

public class Combat {

    private List<Monster> enemies;
    private Runa runa;

    private boolean done;

    public Combat(Runa runa, List<Monster> enemies) {
        this.enemies = enemies;
        this.runa = runa;
        done = false;
    }

    /**
     * 
     */
    public void handleFokus(Ability ability) {
        if (runa.getPrevAbility().getCardType().equals(CardType.FOCUS)) {
            runa.setFocus(runa.getFocus() + runa.getPrevAbility().execute(0, runa, null));
        }
        runa.setCurrentAbility(ability);
    }

    /**
     * @param ability
     * @param target
     * @param dice
     * @return int
     */
    public int runaAttacks(Ability ability, int target, int dice) {
        if (ability.isBreakFocus() && enemies.get(target).getPrevAbility().getCardType().equals(CardType.FOCUS)) {
            enemies.get(target).setPrevAbility(new EmptyAbility());
        }
        int damage = 0;

        Monster monster = enemies.get(target);
        damage = ability.execute(dice, runa, monster);
        if (ability.getAttackType().equals(AttackType.MAGIC) && runa.getFocus() > 1) {
            runa.setFocus(runa.getFocus() - 1);
        }
        CardType prevMonsterCardType = monster.getPrevAbility().getCardType();
        if (prevMonsterCardType.equals(CardType.DEFENSIV)
                && monster.getPrevAbility().getAttackType().equals(ability.getAttackType())) {
            damage += monster.getPrevAbility().execute(0, null, null);
        }
        if (damage > 0) {
            monster.setHealth(monster.getHealth() - damage);
        }
        return damage;

    }

    /**
     * @param monsterInList
     * @return int
     */
    public int attackFromMonster(int monsterInList) {
        Monster monster = enemies.get(monsterInList);

        // Fokuspunkte berechnen und alte Defensekarte löschen
        switch (monster.getPrevAbility().getCardType()) {
            case FOCUS:
                int focuspoints = monster.getPrevAbility().execute(0, null, null);
                monster.setFocusPoints(monster.getFocusPoints() + focuspoints);
                break;
            case DEFENSIV:
                // monster.setPrevAbility(new EmptyAbility());
                break;
            default:
                break;
        }

        // While da immer ein Ability in Monster ist die keine Fokuspunkte benötigt
        while (!monster.isAffordable()) {
            monster.changeAbility();
        }

        // Brechen von Runas Fokuskarte
        if (monster.getCurrentAbility().isBreakFocus()
                && runa.getPrevAbility().getCardType().equals(CardType.FOCUS)) {
            runa.setCurrentAbility(new EmptyAbility());
        }

        // Schadensberechnung
        int damage = 0;
        if (monster.getCurrentAbility().getCardType().equals(CardType.OFFENSIVE)) {
            if (monster.getCurrentAbility().getAttackType().equals(AttackType.MAGIC)) {
                monster.setFocusPoints(monster.getFocusPoints() - monster.getCurrentAbility().getLevel());
            }
            damage = monster.getCurrentAbility().execute(0, runa, monster);
            if (runa.getPrevAbility().getCardType().equals(CardType.DEFENSIV)) {
                if (monster.getCurrentAbility().getAttackType().equals(runa.getPrevAbility().getAttackType())) {
                    damage += runa.getPrevAbility().execute(0, null, null);
                }
            }
        }
        if (damage > 0) {
            runa.setHealth(runa.getHealth() - damage);
        }

        return damage;
    }

    /**
     * Gibt die Monster des Kampfes zurück
     * 
     * @return die Monster des Kampfes
     */

    public List<Monster> getEnemies() {
        return enemies;
    }

    /**
     * Abfrage ob der Kampf zuende ist
     * 
     * @return True wenn der Kampf zuende ist
     */

    public boolean finished() {
        for (Monster monster : enemies) {
            done = done && monster.dead();
        }
        return enemies.isEmpty() || runa.dead();
    }

}
