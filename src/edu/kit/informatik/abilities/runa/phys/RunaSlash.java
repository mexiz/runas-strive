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

public class RunaSlash extends Ability {

    private static final int ABILITY_VALUE = 4;

    /**
     * Konstruktor
     * 
     * @param level das Level
     */
    public RunaSlash(int level) {
        super.init(level, AttackType.PHYS, CardType.OFFENSIVE, true, "Slash");
    }

    @Override
    public int execute(int dice, Runa runa, Monster monster) {
        return (ABILITY_VALUE * super.getLevel()) + dice;
    }
}
