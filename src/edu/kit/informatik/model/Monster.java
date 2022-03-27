package edu.kit.informatik.model;

import java.util.List;

import edu.kit.informatik.abilities.EmptyAbility;

/**
 * Abstrakteklasse für die Monster
 * 
 * @author uwlhp
 * @version 1.0.0
 * 
 */

public abstract class Monster {

    private String name;

    private int health;
    private int countAbility;
    private int focusPoint;

    private MonsterType monsterType;
    private List<Ability> abilities;

    private Ability currentAbility;
    private Ability prevAbility;

    /**
     * Initialisierung des Monsters
     * 
     * @param name      der Name
     * @param health    die Leben
     * @param abilities die Fähigkeiten
     * @param type      der Monstertyp
     */
    public void init(String name, int health, List<Ability> abilities, MonsterType type) {
        this.name = name;
        this.health = health;
        this.abilities = abilities;
        this.monsterType = type;
        this.prevAbility = new EmptyAbility();
        currentAbility = abilities.get(countAbility);
    }

    /**
     * Gibt die vorherige Fähigkeit aus
     * 
     * @return Ability die Fähigkeit
     */
    public Ability getPrevAbility() {
        return prevAbility;
    }

    /**
     * Setzt die vorherige Fähigkeit
     * 
     * @param prevAbility die zusetzende Fähigkeit
     */
    public void setPrevAbility(Ability prevAbility) {
        this.prevAbility = prevAbility;
    }

    /**
     * Abfrage ob der Monster tot ist
     * 
     * @return boolean true wenn das Monster tot ist
     */
    public boolean dead() {
        return this.getHealth() < 0;
    }

    /**
     * Wenn die Karte eine magische Karte ist wird abgefragt ob der Monster genügend
     * Fokuspunkte hat
     * 
     * @return boolean true wenn der Monster genügend Fokuspunkte hat oder phsische
     *         Karte
     */
    public boolean isAffordable() {
        if (this.getCurrentAbility().getAttackType().equals(AttackType.MAGIC)
                && this.getCurrentAbility().getCardType().equals(CardType.OFFENSIVE)) {
            return (this.getFocusPoints() >= this.getCurrentAbility().getLevel());
        }
        return true;
    }

    /**
     * Ändert die Fähigkeit zur nächsten in der Liste
     * 
     */
    public void changeAbility() {
        countAbility++;
        if (countAbility > abilities.size() - 1) {
            countAbility = 0;
        }
        currentAbility = abilities.get(countAbility);
    }

    /**
     * Setzt die aktuelle Fähikeit
     * 
     * @param abilities die Fähigkeit
     */
    public void setCurrentAbility(Ability abilities) {
        this.currentAbility = abilities;
    }

    /**
     * Gibt den Typ des Monsters zurück
     * 
     * @return den Typ des Monsters
     */
    public MonsterType getMonsterType() {
        return monsterType;
    }

    /**
     * Gibt die aktuelle Fähigkeit zurück
     * 
     * @return gibt die Fähigkeit
     */
    public Ability getCurrentAbility() {
        return currentAbility;
    }

    /**
     * Gibt die Fokuspunkte zurück
     * 
     * @return die Fokuspunkte
     */
    public int getFocusPoints() {
        return focusPoint;
    }

    /**
     * Setzt die Fokuspunkte
     * 
     * @param focusPoint die Fokuspunkte
     */
    public void setFocusPoints(int focusPoint) {
        this.focusPoint = focusPoint;
    }

    /**
     * Gitb die Leben zurück
     * 
     * @return die Leben
     */
    public int getHealth() {
        return health;
    }

    /**
     * Setzt die Leben
     * 
     * @param health die Leben
     */
    public void setHealth(int health) {
        this.health = health;
    }

    /**
     * Gibt den Namen zurück
     * 
     * @return den Namen
     */
    public String getName() {
        return name;
    }

}
