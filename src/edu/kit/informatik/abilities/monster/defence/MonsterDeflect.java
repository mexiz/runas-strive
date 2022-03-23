package edu.kit.informatik.abilities.monster.defence;

import edu.kit.informatik.Runa;
import edu.kit.informatik.model.AttackType;
import edu.kit.informatik.model.CardType;
import edu.kit.informatik.model.Ability;
import edu.kit.informatik.model.Monster;

/**
 * 
 * Defensive Monster Fähigkeitskarte
 * 
 * @author uwhlp
 * @version 1.0.0
 * 
 */

public class MonsterDeflect extends Ability {

    public MonsterDeflect(int level) {
        super.setLevel(level);
        super.setAttackType(AttackType.MAGIC);
        super.setCardType(CardType.DEFENSIV);
        super.setBreakFocus(false);
        super.setName("Deflect");

    }

    @Override
    public int execute(int dice, Runa runa, Monster monster) {
        return (-1) * ((11 * super.getLevel()) + 2);
    }

}
