package edu.kit.informatik.model;

import edu.kit.informatik.Runa;

/**
 * 
 * Interface für die Fähigkeiten von Runa
 * 
 * @author uwhlp
 * @version 1.0.0
 */

public interface Ability {

    /**
     * Den Wert von der Fähigkeit
     * 
     * @param dice    die Würfelzahl
     * @param runa    das Objekt des Angreifers
     * @param monster das Objekt des Opfers
     */

    int execute(int dice, Runa runa, Monster monster);

    /**
     * Gibt den Typ der Karte zurück
     * 
     * @return den Kartentype(Offensive, Defensiv)
     */

    CardType getCardType();

    /**
     * Gibt den Angriffstypen zurück
     * 
     * @return den Angriffstypen (physisch oder magisch)
     */
    AttackType getAttackType();

}
