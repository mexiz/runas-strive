
package edu.kit.informatik.abilities.monster.defence;

import edu.kit.informatik.Runa;
import edu.kit.informatik.model.AttackType;
import edu.kit.informatik.model.CardType;
import edu.kit.informatik.model.Ability;
import edu.kit.informatik.model.Monster;

public class MonsterFocus extends Ability {

    public MonsterFocus(int level) {
        super.setLevel(level);
        super.setAttackType(AttackType.NONE);
        super.setCardType(CardType.FOCUS);
        super.setBreakFocus(false);
        super.setName("Focus");
    }

    @Override
    public int execute(int dice, Runa runa, Monster monster) {
        return super.getLevel();
    }
}
