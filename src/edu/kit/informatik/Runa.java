package edu.kit.informatik;

import java.util.ArrayList;
import java.util.List;

import edu.kit.informatik.abilities.EmptyAbility;
import edu.kit.informatik.hero.HeroClass;
import edu.kit.informatik.model.Ability;

/**
 * Klasse für die Heldin Runa
 * 
 * @author uwlhp
 * @version 1.0.0
 */
public class Runa {

    private List<Ability> abilities;
    private HeroClass hero;

    private int dice;
    private GameData data = GameData.getInstance();

    private int health = data.getMaxHealth();
    private int focus = 1;

    private int diceUpgradeValue = data.getUpgradeDice();
    private int maxDice = data.getMaxDice();

    private Ability currentAbility;

    /**
     * Konstruktor
     * 
     * @param runaClass  die Klasse des Heldens
     * @param startLevel das Startlevel
     */
    public Runa(HeroClass runaClass, int startLevel) {
        dice = data.getStartDice();
        this.hero = runaClass;
        this.abilities = new ArrayList<>();
        this.abilities = runaClass.getAbilities(startLevel);
        this.currentAbility = new EmptyAbility();
    }

    /**
     * Werten den Würfel auf
     * 
     */
    public void changeDice() {
        if (dice < maxDice) {
            dice += diceUpgradeValue;
        }
    }

    /**
     * Abfrage ob der Würfel maximal groß ist
     * 
     * @return true wenn der Würfel maximal groß ist
     */
    public boolean upgradeDice() {
        return dice < maxDice;
    }

    /**
     * Getter für den Würfel
     * 
     * @return int der Würfel
     */
    public int getDice() {
        return dice;
    }

    /**
     * Getter für die aktuelle Fähigkeit
     * 
     * @return Ability die Fähigkeit
     */
    public Ability getCurrentAbility() {
        return currentAbility;
    }

    /**
     * Setter für die Fähigkeit
     * 
     * @param ability die Fähigkeit
     */
    public void setCurrentAbility(Ability ability) {
        this.currentAbility = ability;
    }

    /**
     * Abfrage ob Runa tot ist
     * 
     * @return boolean true wenn Runa tot
     */
    public boolean dead() {
        return this.getHealth() <= 0;
    }

    /**
     * Getter für die Klasse von Runa
     * 
     * @return HeroClass die Klasse
     */
    public HeroClass getHeroClass() {
        return hero;
    }

    /**
     * 
     * Getter für die Liste der Fähikeiten
     * 
     * @return List<Ability> Liste der Fäigkeiten
     */
    public List<Ability> getAbilities() {
        return abilities;
    }

    /**
     * 
     * Fügt eine Fähigkeit hinzu
     * 
     * @param ability die Fähigkeit
     */
    public void addAbility(Ability ability) {
        this.abilities.add(ability);
    }

    /**
     * Setter für die Klasse der Heldin
     * 
     * @param hero die Heldenklasse
     */
    public void setHeroClass(HeroClass hero) {
        this.hero = hero;
    }

    /**
     * Getter für die Leben
     * 
     * @return int die Leben
     */
    public int getHealth() {
        return health;
    }

    /**
     * Setter für die Leben
     * 
     * @param health die Leben
     */
    public void setHealth(int health) {
        this.health = health;
    }

    /**
     * Getter für die Fokuspunkte
     * 
     * @return int die Fokuspunkte
     */
    public int getFocus() {
        return focus;
    }

    /**
     * Setter für die Fokuspunkte
     * 
     * @param focus die Fokuspunkte
     */
    public void setFocus(int focus) {
        this.focus = focus;
    }
}
