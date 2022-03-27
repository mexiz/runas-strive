package edu.kit.informatik.monster.secondlevel;

import java.util.List;

import edu.kit.informatik.abilities.monster.defence.MonsterBlock;
import edu.kit.informatik.abilities.monster.defence.MonsterDeflect;
import edu.kit.informatik.abilities.monster.phys.MonsterClaw;
import edu.kit.informatik.model.Ability;
import edu.kit.informatik.model.Monster;
import edu.kit.informatik.model.MonsterType;

/**
 * Das Monster
 * 
 * @author uwlhp
 * @version 1.0.0
 */
public class Bear extends Monster {

    private static final MonsterType MONSTER_TYPE = MonsterType.NONE;
    private static final String NAME = "Bear";
    private static final int HEALTH = 40;

    private List<Ability> abilities = List.of(new MonsterClaw(2),
            new MonsterDeflect(2),
            new MonsterBlock(2));

    /**
     * no
     */
    public Bear() {
        super.init(NAME, HEALTH, abilities, MONSTER_TYPE);
    }

}