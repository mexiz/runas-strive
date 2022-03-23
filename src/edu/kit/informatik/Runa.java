package edu.kit.informatik;

import java.util.List;

import edu.kit.informatik.abilities.EmptyAbility;
import edu.kit.informatik.hero.HeroClass;
import edu.kit.informatik.hero.Mage;
import edu.kit.informatik.hero.Paladin;
import edu.kit.informatik.hero.Warrior;
import edu.kit.informatik.model.Ability;

public class Runa {

    private List<Ability> abilities;
    private HeroClass hero;

    private int health = 50;
    private int focus = 1;

    private Ability currentAbility;

    public Runa(HeroClass runaClass) {
        this.abilities = runaClass.getAbilities();
        this.currentAbility = new EmptyAbility();
    }

    public Ability getCurrentAbility() {
        return currentAbility;
    }

    public void setCurrentAbility(Ability ability) {
        this.currentAbility = ability;
    }

    public boolean dead() {
        return this.getHealth() < 0;
    }

    public HeroClass getHeroClass() {
        return hero;
    }

    public List<Ability> getAbilities() {
        return abilities;
    }

    public void setHeroClass(HeroClass hero) {
        this.hero = hero;
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
