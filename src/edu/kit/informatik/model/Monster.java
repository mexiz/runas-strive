package edu.kit.informatik.model;

import edu.kit.informatik.abilities.EmptyAbility;

public abstract class Monster {

    private Ability prevAbility = new EmptyAbility();

    public Ability getPrevAbility() {
        return prevAbility;
    }

    public void setPrevAbility(Ability prevAbility) {
        this.prevAbility = prevAbility;
    }

    public boolean dead() {
        return this.getHealth() < 0;
    }

    public boolean isAffordable() {
        if (this.getCurrentAbility().getAttackType().equals(AttackType.MAGIC)) {
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
