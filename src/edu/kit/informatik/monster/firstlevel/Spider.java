package edu.kit.informatik.monster.firstlevel;

import java.util.List;

import edu.kit.informatik.abilities.monster.defence.MonsterBlock;
import edu.kit.informatik.abilities.monster.phys.MonsterBite;
import edu.kit.informatik.model.Ability;
import edu.kit.informatik.model.Monster;
import edu.kit.informatik.model.MonsterType;

/**
 * Das Monster
 * 
 * @author uwlhp
 * @version 1.0.0
 */
public class Spider extends Monster {

    private static final MonsterType MONSTER_TYPE = MonsterType.NONE;
    private static final String NAME = "Spider";
    private static final int HEALTH = 15;

    private List<Ability> abilities = List.of(new MonsterBite(1),
            new MonsterBlock(1));

    /**
     * no
     */
    public Spider() {
        super.init(NAME, HEALTH, abilities, MONSTER_TYPE);
    }
}
