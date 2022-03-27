package edu.kit.informatik.model;

import edu.kit.informatik.abilities.EmptyAbility;

/**
 * Abstrakteklasse für die Monster
 * 
 * @author uwlhp
 * @version 1.0.0
 * 
 */

public abstract class Monster {

    private Ability prevAbility = new EmptyAbility();

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
    public abstract void changeAbility();

    /**
     * Setzt die aktuelle Fähikeit
     * 
     * @param abilities die Fähigkeit
     */
    public abstract void setCurrentAbility(Ability abilities);

    /**
     * Gibt den Typ des Monsters zurück
     * 
     * @return den Typ des Monsters
     */
    public abstract MonsterType getMonsterType();

    /**
     * Gibt die aktuelle Fähigkeit zurück
     * 
     * @return gibt die Fähigkeit
     */
    public abstract Ability getCurrentAbility();

    /**
     * Gibt die Fokuspunkte zurück
     * 
     * @return die Fokuspunkte
     */
    public abstract int getFocusPoints();

    /**
     * Setzt die Fokuspunkte
     * 
     * @param focusPoint die Fokuspunkte
     */
    public abstract void setFocusPoints(int focusPoint);

    /**
     * Gitb die Leben zurück
     * 
     * @return die Leben
     */
    public abstract int getHealth();

    /**
     * Setzt die Leben
     * 
     * @param health die Leben
     */
    public abstract void setHealth(int health);

    /**
     * Gibt den Namen zurück
     * 
     * @return den Namen
     */
    public abstract String getName();

}
