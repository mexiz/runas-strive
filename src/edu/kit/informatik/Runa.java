package edu.kit.informatik;

import java.util.ArrayList;
import java.util.List;

import edu.kit.informatik.abilities.EmptyAbility;
import edu.kit.informatik.hero.HeroClass;
import edu.kit.informatik.model.Ability;

public class Runa {

    private List<Ability> abilities;
    private HeroClass hero;

    private int dice;

    private int health = 50;
    private int focus = 1;

    private Ability currentAbility;

    public Runa(HeroClass runaClass) {
        dice = 4;
        this.hero = runaClass;
        this.abilities = new ArrayList<>();
        this.abilities = runaClass.getAbilities();
        this.currentAbility = new EmptyAbility();
    }

    /**
     * Werten den Würfel auf
     * 
     * @return true wenn er verändert werden kann
     */
    public void changeDice() {
        if (dice < 12) {
            dice += 2;
        }
    }

    /**
     * Abfrage ob der Würfel maximal groß ist
     * 
     * @return true wenn der Würfel maximal groß ist
     */
    public boolean isMaxDice() {
        return dice < 12;
    }

    /**
     * @return int
     */
    public int getDice() {
        return dice;
    }

    /**
     * @param dice
     */
    public void setDice(int dice) {
        this.dice = dice;
    }

    /**
     * @return Ability
     */
    public Ability getCurrentAbility() {
        return currentAbility;
    }

    /**
     * @param ability
     */
    public void setCurrentAbility(Ability ability) {
        this.currentAbility = ability;
    }

    /**
     * @return boolean
     */
    public boolean dead() {
        return this.getHealth() < 0;
    }

    /**
     * @return HeroClass
     */
    public HeroClass getHeroClass() {
        return hero;
    }

    /**
     * @return List<Ability>
     */
    public List<Ability> getAbilities() {
        return abilities;
    }

    /**
     * @param ability
     */
    public void addAbility(Ability ability) {
        this.abilities.add(ability);
    }

    /**
     * @param hero
     */
    public void setHeroClass(HeroClass hero) {
        this.hero = hero;
    }

    /**
     * @return int
     */
    public int getHealth() {
        return health;
    }

    /**
     * @param health
     */
    public void setHealth(int health) {
        this.health = health;
    }

    /**
     * @return int
     */
    public int getFocus() {
        return focus;
    }

    /**
     * @param focus
     */
    public void setFocus(int focus) {
        this.focus = focus;
    }

}
