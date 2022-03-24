package edu.kit.informatik.monster.secondlevel;

import java.util.List;

import edu.kit.informatik.abilities.monster.defence.MonsterDeflect;
import edu.kit.informatik.abilities.monster.defence.MonsterFocus;
import edu.kit.informatik.abilities.monster.magic.MonsterIce;
import edu.kit.informatik.abilities.monster.phys.MonsterBite;
import edu.kit.informatik.abilities.monster.phys.MonsterScratch;
import edu.kit.informatik.model.Monster;
import edu.kit.informatik.model.MonsterType;
import edu.kit.informatik.model.Ability;

public class WildBoar extends Monster {

    private static final MonsterType MONSTER_TYPE = MonsterType.EIS;
    private static final String name = "WildBoar";
    private int health = 27;
    private int countAbility = 0;
    private int focusPoint = 0;

    private List<Ability> abilities = List.of(new MonsterScratch(2),
            new MonsterDeflect(2),
            new MonsterScratch(2));

    private Ability currentAbility = abilities.get(countAbility);
    @Override
    public String getName() {
        return name;
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
