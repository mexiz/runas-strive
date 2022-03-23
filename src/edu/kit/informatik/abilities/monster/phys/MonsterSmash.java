package edu.kit.informatik.abilities.monster.phys;

import edu.kit.informatik.Runa;
import edu.kit.informatik.model.AttackType;
import edu.kit.informatik.model.CardType;
import edu.kit.informatik.model.Ability;
import edu.kit.informatik.model.Monster;

public class MonsterSmash extends Ability {

    public MonsterSmash(int level) {
        super.setLevel(level);
        super.setAttackType(AttackType.PHYS);
        super.setCardType(CardType.OFFENSIVE);
        super.setBreakFocus(false);
        super.setName("Smash");
    }

    @Override
    public int execute(int dice, Runa runa, Monster monster) {
        return 8 * super.getLevel();
    }

}
