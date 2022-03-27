package edu.kit.informatik.monster.firstlevel;

import java.util.List;

import edu.kit.informatik.abilities.monster.defence.MonsterFocus;
import edu.kit.informatik.abilities.monster.magic.MonsterIce;
import edu.kit.informatik.model.Ability;
import edu.kit.informatik.model.Monster;
import edu.kit.informatik.model.MonsterType;

/**
 * Das Monster
 * 
 * @author uwlhp
 * @version 1.0.0
 */

public class Ghost extends Monster {

    private static final MonsterType MONSTER_TYPE = MonsterType.ICE;
    private static final String NAME = "Ghost";

    private static final int HEALTH = 15;

    private List<Ability> abilities = List.of(new MonsterFocus(1),
            new MonsterIce(1));

    /**
     * no
     */
    public Ghost() {
        super.init(NAME, HEALTH, abilities, MONSTER_TYPE);
    }

}
