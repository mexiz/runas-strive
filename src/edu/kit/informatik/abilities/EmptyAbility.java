package edu.kit.informatik.abilities;

import edu.kit.informatik.Runa;
import edu.kit.informatik.model.Ability;
import edu.kit.informatik.model.AttackType;
import edu.kit.informatik.model.CardType;
import edu.kit.informatik.model.Monster;

/**
 * Die leere Fähigkeitsklasse
 * 
 * @author uwlhp
 * @version 1.0.0
 */
public class EmptyAbility extends Ability {

    /**
     * Konstruktor
     * 
     */
    public EmptyAbility() {
        super.init(0, AttackType.NONE, CardType.NONE, false, "Empty");
    }

    @Override
    public int execute(int dice, Runa runa, Monster monster) {
        return 0;
    }
}
