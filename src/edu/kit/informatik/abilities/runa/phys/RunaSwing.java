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

public class RunaSwing extends Ability {

    private static final int ABILITY_VALUE = 5;

    /**
     * Konstruktor
     * 
     * @param level das Level
     */
    public RunaSwing(int level) {
        super.init(level, AttackType.PHYS, CardType.OFFENSIVE, true, "Swing");
    }

    @Override
    public int execute(int dice, Runa runa, Monster monster) {
        return (ABILITY_VALUE * super.getLevel()) + dice;
    }
}
