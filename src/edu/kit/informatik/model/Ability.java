package edu.kit.informatik.model;

import edu.kit.informatik.Runa;

/**
 * 
 * Abstrakte Klasse für die Fähigkeiten
 * 
 * @author uwhlp
 * @version 1.0.0
 * 
 */

public abstract class Ability {

    private String name;
    private int level;
    private AttackType attackType;
    private CardType cardType;
    private boolean breakFocus;

    /**
     * Initialisierung der Fähigkeiten
     * 
     * @param level      Level der Fähikeit
     * @param name       Name der Fähigkeit
     * @param attackType Attacktyp der Fähigkeit
     * @param breakFocus Ob die Fähigkeit Fokus bricht
     * @param cardType   CardType der Fähigkeit
     */
    public void init(int level, AttackType attackType, CardType cardType, boolean breakFocus, String name) {
        this.level = level;
        this.name = name;
        this.attackType = attackType;
        this.breakFocus = breakFocus;
        this.cardType = cardType;
    }

    /**
     * Den Wert von der Fähigkeit
     * 
     * @param dice    die Würfelzahl
     * @param runa    das Objekt des Angreifers
     * @param monster das Objekt des Opfers
     */

    public abstract int execute(int dice, Runa runa, Monster monster);

    /**
     * @param obj
     * @return boolean
     */
    @Override
    public boolean equals(Object obj) {
        if (obj != null && getClass() == obj.getClass())
            return true;
        return super.equals(obj);
    }

    /**
     * @return int
     */
    @Override
    public int hashCode() {
        return super.hashCode();
    }

    /**
     * Gibt zurück ob die Fähigkeit den Fokus bricht
     * 
     * @return true wenn er gebrochen wird
     */
    public boolean isBreakFocus() {
        return breakFocus;
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
     * Gibt den Angriffstypen zurück
     * 
     * @return den Angriffstypen (physisch oder magisch)
     */
    public AttackType getAttackType() {
        return attackType;
    }

    /**
     * Gibt den Namen der Fähigkeit zurück
     * 
     * @return den Name der Fähigkeit
     */
    public String getName() {
        return name;
    }

}
