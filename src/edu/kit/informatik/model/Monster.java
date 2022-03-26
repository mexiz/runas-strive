package edu.kit.informatik.model;

import edu.kit.informatik.abilities.EmptyAbility;

/**
 * Abstrakteklasse für die Monster
 * 
 * @author uwlhp
 * @version 1.0.0
 * 
 */

public abstract class Monster {

    private Ability prevAbility = new EmptyAbility();

    /**
     * @return Ability
     */
    public Ability getPrevAbility() {
        return prevAbility;
    }

    /**
     * @param prevAbility
     */
    public void setPrevAbility(Ability prevAbility) {
        this.prevAbility = prevAbility;
    }

    /**
     * @return boolean
     */
    public boolean dead() {
        return this.getHealth() < 0;
    }

    /**
     * 
     * Wenn die Karte eine magische Karte ist wird abgefragt ob der Monster genügend
     * Fokuspunkte hat
     * 
     * @return boolean true wenn der Monster genügend Fokuspunkte hat oder phsische
     *         Karte
     */
    public boolean isAffordable() {
        if (this.getCurrentAbility().getAttackType().equals(AttackType.MAGIC)
                && this.getCurrentAbility().getCardType().equals(CardType.OFFENSIVE)) {
            return (this.getFocusPoints() >= this.getCurrentAbility().getLevel());
        }
        return true;
    }

    public abstract void changeAbility();

    public abstract void setCurrentAbility(Ability abilities);

    public abstract MonsterType getMonsterType();

    public abstract Ability getCurrentAbility();

    public abstract int getFocusPoints();

    public abstract void setFocusPoints(int focusPoint);

    public abstract int getHealth();

    public abstract void setHealth(int health);

    public abstract String getName();

}
