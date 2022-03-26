package edu.kit.informatik;

import java.util.List;

import edu.kit.informatik.abilities.EmptyAbility;
import edu.kit.informatik.model.Ability;
import edu.kit.informatik.model.AttackType;
import edu.kit.informatik.model.CardType;
import edu.kit.informatik.model.Monster;

/**
 * Die Klasse für einen Kampf
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
     * Führt die Fokusfähigkeit von Runa aus
     * 
     * @return Wert der Fokuspunkte
     */
    public int handleFokus() {
        int focusPoint = 0;
        if (runa.getCurrentAbility().getCardType().equals(CardType.FOCUS)) {
            focusPoint = runa.getCurrentAbility().execute(0, runa, null);
            runa.setFocus(runa.getFocus() + focusPoint);
        }
        return focusPoint;
    }

    /**
     * Führt Runaszug aus
     * 
     * @param ability die ausgewählte Fähigkeit 
     * @param target das Monster in der List
     * @param dice der Würfelwert
     * @return int Schaden von Runa auf das Monster
     */
    public int runaAttacks(Ability ability, int target, int dice) {
        if (ability.isBreakFocus() && enemies.get(target).getPrevAbility().getCardType().equals(CardType.FOCUS)) {
            enemies.get(target).setPrevAbility(new EmptyAbility());
        }
        int damage = 0;
        Monster monster = enemies.get(target);
        damage = ability.execute(dice, runa, monster);
        if (ability.getAttackType().equals(AttackType.MAGIC) && ability.getCardType().equals(CardType.OFFENSIVE)
                && runa.getFocus() > 1) {
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
     * Führt die Fokusfähigkeit vom Monster aus
     * 
     * @param monsterInList nummer vom Monster in der Liste
     * @return die anzahl der addierten Fokuspunkte
     */
    public int monsterFocusPoints(int monsterInList) {
        Monster monster = enemies.get(monsterInList);
        if (monster.getPrevAbility().getCardType().equals(CardType.FOCUS)) {
            int focuspoints = monster.getPrevAbility().execute(0, null, null);
            monster.setFocusPoints(monster.getFocusPoints() + focuspoints);
            return focuspoints;
        }
        return 0;
    }

    /**
     * Führt den Zug des Monster zu
     * 
     * @param monsterInList die Nummmer des Monster
     * @return int die Anzahl des verursachten Schadens
     */
    public int attackFromMonster(int monsterInList) {
        Monster monster = enemies.get(monsterInList);

        while (!monster.isAffordable()) {
            monster.changeAbility();
        }

        Ability currentAbility = monster.getCurrentAbility();

        monster.setPrevAbility(currentAbility);

        int damage = 0;
        if (currentAbility.getCardType().equals(CardType.OFFENSIVE)) {
            // Fokuspunkte abfragen
            if (currentAbility.getAttackType().equals(AttackType.MAGIC)) {
                monster.setFocusPoints(monster.getFocusPoints() - currentAbility.getLevel());
            }
            damage = currentAbility.execute(0, runa, monster);
            if (runa.getCurrentAbility().getCardType().equals(CardType.DEFENSIV)
                    && currentAbility.getAttackType().equals(runa.getCurrentAbility().getAttackType())) {
                damage += runa.getCurrentAbility().execute(0, null, null);
            }
        }

        if (currentAbility.isBreakFocus() && runa.getCurrentAbility().getCardType().equals(CardType.FOCUS)) {
            runa.setCurrentAbility(new EmptyAbility());
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
