package edu.kit.informatik;

import java.util.List;

import edu.kit.informatik.hero.HeroClass;
import edu.kit.informatik.model.AttackType;
import edu.kit.informatik.model.CardType;
import edu.kit.informatik.model.Monster;
import edu.kit.informatik.model.Ability;

public class Runa {

    List<Ability> abilities;

    Ability choosedAbilities;

    int health = 50;
    int focus = 1;

    public Runa(HeroClass runaClass) {
        this.abilities = runaClass.getAbilities();
    }

    public void test(Ability abilities) {
        choosedAbilities = abilities;
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
