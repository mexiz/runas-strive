package edu.kit.informatik.model;

import edu.kit.informatik.monster.MonsterType;

public interface Monster {

    public abstract void changeAbility();

    public abstract void setAbility(Ability abilities);

    public abstract MonsterType getMonsterType();

    public abstract Ability getAbility();

    public abstract int getFocusPoints();

    public abstract void setFocusPoints(int focusPoint);

    public abstract int getHealth();

    public abstract void setHealth(int health);

}
