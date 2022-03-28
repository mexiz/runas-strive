package edu.kit.informatik.abilities;

import edu.kit.informatik.character.Runa;
import edu.kit.informatik.model.Monster;
import edu.kit.informatik.model.ability.Ability;
import edu.kit.informatik.model.ability.AttackType;
import edu.kit.informatik.model.ability.CardType;

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
