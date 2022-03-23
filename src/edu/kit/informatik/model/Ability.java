package edu.kit.informatik.model;

import edu.kit.informatik.Runa;

/**
 * 
 * Abstrakte Klasse für die Fähigkeiten
 * 
 * @author uwhlp
 * @version 1.0.0
 */

public abstract class Ability {

    private String name;
    private int level;
    private int health;
    private AttackType attackType;
    private CardType cardType;
    private boolean breakFocus;

    /**
     * Den Wert von der Fähigkeit
     * 
     * @param dice    die Würfelzahl
     * @param runa    das Objekt des Angreifers
     * @param monster das Objekt des Opfers
     */

    public abstract int execute(int dice, Runa runa, Monster monster);

    @Override
    public boolean equals(Object obj) {
        if (obj != null && getClass() == obj.getClass())
            return true;
        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    /**
     * Das Level von der Fähigkeit
     * 
     * @return das Level
     */

    public int getLevel() {
        return level;
    }

    /**
     * Setzt das Level der Fähigkeit
     * 
     * @param level das Level
     */
    public void setLevel(int level) {
        this.level = level;
    }

    /**
     * Gibt den Typ der Karte zurück
     * 
     * @return den Kartentype(Offensive, Defensiv)
     */

    public CardType getCardType() {
        return cardType;
    }

    /**
     * Setzt den Typ der Karte      
     * 
     * @param cardType der Typ der Karte
     */
    public void setCardType(CardType cardType) {
        this.cardType = cardType;
    }

    /**
     * Gibt den Angriffstypen zurück
     * 
     * @return den Angriffstypen (physisch oder magisch)
     */
    public AttackType getAttackType() {
        return attackType;
    }

    /**
     * Setzt den Angriffstypen
     * 
     * @param attackType der Angriffstyp
     */
    public void setAttackType(AttackType attackType) {
        this.attackType = attackType;
    }

    /**
     * Gibt den Namen der Fähigkeit zurück
     * 
     * @return den Name der Fähigkeit
     */
    public String getName() {
        return name;
    }

    /**
     * Setzt den Namen der Fähigkeit
     * 
     * @param name der Name der Fähigkeit
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Setzt ob die Fähigkeit den Fokus bricht
     * 
     * @param breakFocus true, wenn er ihn bricht
     */
    public void setBreakFocus(boolean breakFocus) {
        this.breakFocus = breakFocus;
    }

}
