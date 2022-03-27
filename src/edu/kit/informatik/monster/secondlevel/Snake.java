package edu.kit.informatik.monster.secondlevel;

import java.util.List;

import edu.kit.informatik.abilities.monster.defence.MonsterFocus;
import edu.kit.informatik.abilities.monster.magic.MonsterIce;
import edu.kit.informatik.abilities.monster.phys.MonsterBite;
import edu.kit.informatik.model.Ability;
import edu.kit.informatik.model.Monster;
import edu.kit.informatik.model.MonsterType;

/**
 * Das Monster
 * 
 * @author uwlhp
 * @version 1.0.0
 */
public class Snake extends Monster {

    private static final MonsterType MONSTER_TYPE = MonsterType.ICE;
    private static final String NAME = "Snake";
    private int health = 31;
    private int countAbility = 0;
    private int focusPoint = 0;

    private List<Ability> abilities = List.of(new MonsterBite(2),
            new MonsterFocus(2),
            new MonsterIce(2));

    private Ability currentAbility = abilities.get(countAbility);

    @Override
    public String getName() {
        return NAME;
    }

    @Override
    public MonsterType getMonsterType() {
        return MONSTER_TYPE;
    }

    @Override
    public int getFocusPoints() {
        return focusPoint;
    }

    @Override
    public void setFocusPoints(int focusPoint) {
        this.focusPoint = focusPoint;
    }

    @Override
    public int getHealth() {
        return health;
    }

    @Override
    public Ability getCurrentAbility() {
        return currentAbility;
    }

    @Override
    public void setHealth(int health) {
        this.health = health;
    }

    @Override
    public void setCurrentAbility(Ability abilities) {
        this.currentAbility = abilities;

    }

    @Override
    public void changeAbility() {
        countAbility++;
        if (countAbility > abilities.size() - 1) {
            countAbility = 0;
        }
        currentAbility = abilities.get(countAbility);
    }
}