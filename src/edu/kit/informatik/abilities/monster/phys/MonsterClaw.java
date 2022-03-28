package edu.kit.informatik.abilities.monster.phys;

import edu.kit.informatik.character.Runa;
import edu.kit.informatik.model.Monster;
import edu.kit.informatik.model.ability.Ability;
import edu.kit.informatik.model.ability.AttackType;
import edu.kit.informatik.model.ability.CardType;

/**
 * 
 * offensive Monster Fähigkeitskarte
 * 
 * @author uwhlp
 * @version 1.0.0
 * 
 */

public class MonsterClaw extends Ability {

    private static final int ABILITY_VALUE = 6;

    /**
     * Konstruktor
     * 
     * @param level das Level
     */
    public MonsterClaw(int level) {
        super.init(level, AttackType.PHYS, CardType.OFFENSIVE, true, "Claw");
    }

    @Override
    public int execute(int dice, Runa runa, Monster monster) {
        return (ABILITY_VALUE * super.getLevel());
    }

}