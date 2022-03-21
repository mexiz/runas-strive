package edu.kit.informatik.cards.monster.model;

public interface Monster {

    MonsterType getMonsterType();

    int getFocusPoints();

    void setFocusPoints(int focusPoint);

    int getHealth();

}
