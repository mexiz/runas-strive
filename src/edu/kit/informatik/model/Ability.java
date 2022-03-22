package edu.kit.informatik.model;

import edu.kit.informatik.Runa;

/**
 * 
 * Interface für die Fähigkeiten von Runa
 * 
 * @author uwhlp
 * @version 1.0.0
 */

public abstract class Ability {

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
     * Den Wert von der Fähigkeit
     * 
     * @param dice    die Würfelzahl
     * @param runa    das Objekt des Angreifers
     * @param monster das Objekt des Opfers
     */

    public abstract int execute(int dice, Runa runa, Monster monster);

    /**
     * Gibt den Typ der Karte zurück
     * 
     * @return den Kartentype(Offensive, Defensiv)
     */

    public abstract CardType getCardType();

    /**
     * Gibt den Angriffstypen zurück
     * 
     * @return den Angriffstypen (physisch oder magisch)
     */
    public abstract AttackType getAttackType();

    /**
     * gibt den Namen der Fähigkeit zurück
     * 
     * @return den Name der Fähigkeit (physisch oder magisch)
     */
    public abstract String getName();

}
