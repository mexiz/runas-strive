package edu.kit.informatik.abilities.runa.magic;

import edu.kit.informatik.Runa;
import edu.kit.informatik.model.AttackType;
import edu.kit.informatik.model.CardType;
import edu.kit.informatik.model.Monster;
import edu.kit.informatik.model.Ability;
import edu.kit.informatik.monster.MonsterType;

/**
 * 
 * Offensive Runa Fähigkeitskarte
 * 
 * @author uwhlp
 * @version 1.0.0
 * 
 */

public class RunaWater extends Ability {

    public RunaWater(int level) {
        super.setLevel(level);
        super.setAttackType(AttackType.PHYS);
        super.setCardType(CardType.OFFENSIVE);
        super.setBreakFocus(false);
        super.setName("Water");
    }

    @Override
    public int execute(int dice, Runa runa, Monster monster) {
        int damage = (2 * super.getLevel() + 4) * runa.getFocus();
        if (monster.getMonsterType().equals(MonsterType.BLITZ)) {
            damage += 2 * super.getLevel();
        }
        return damage;
    }
}
