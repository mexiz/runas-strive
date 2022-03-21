package edu.kit.informatik.cards.runa.model;

import java.util.List;

import edu.kit.informatik.cards.model.AttackType;
import edu.kit.informatik.cards.monster.model.Monster;
import edu.kit.informatik.hero.HeroClass;

public class Runa {

    List<RunaAbilities> abilities;

    RunaAbilities currenAbilities;

    int health = 50;
    int focus = 1;

    public Runa(HeroClass runaClass) {
        runaClass.getAbilities();
    }

    public void executeAbility(int dice, Monster monster) {
        currenAbilities.execute(dice, this, monster);
    }

    public int defend(int damage, boolean breakFocus, AttackType type) {

        health -= damage;
        return 0;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getFocus() {
        return focus;
    }

    public void setFocus(int focus) {
        this.focus = focus;
    }

}
