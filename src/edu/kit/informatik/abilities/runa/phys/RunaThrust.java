package edu.kit.informatik.abilities.runa.phys;

import edu.kit.informatik.Runa;
import edu.kit.informatik.model.AttackType;
import edu.kit.informatik.model.CardType;
import edu.kit.informatik.model.Monster;
import edu.kit.informatik.model.Ability;

/**
 * 
 * Offensive Runa Fähigkeitskarte
 * 
 * @author uwhlp
 * @version 1.0.0
 * 
 */

public class RunaThrust extends Ability {

    public RunaThrust(int level) {
        super.init(level, AttackType.PHYS, CardType.OFFENSIVE, false, "Thrust");
    }

    @Override
    public int execute(int dice, Runa runa, Monster monster) {
        int damage = (6 * super.getLevel()) + dice;
        if (dice > 5) {
            damage += (4 * super.getLevel());
        }
        return damage;
    }
}
