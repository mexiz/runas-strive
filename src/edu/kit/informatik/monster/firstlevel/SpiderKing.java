package edu.kit.informatik.monster.firstlevel;

import java.util.List;

import edu.kit.informatik.abilities.monster.defence.MonsterBlock;
import edu.kit.informatik.abilities.monster.defence.MonsterFocus;
import edu.kit.informatik.abilities.monster.magic.MonsterLightning;
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
public class SpiderKing extends Monster {

    private static final MonsterType MONSTER_TYPE = MonsterType.NONE;
    private static final String NAME = "Spider King";
    private static final int HEALTH = 50;

    private List<Ability> abilities = List.of(new MonsterBite(1),
            new MonsterBlock(1),
            new MonsterFocus(1),
            new MonsterLightning(1));

    /**
     * no
     */
    public SpiderKing() {
        super.init(NAME, HEALTH, abilities, MONSTER_TYPE);
    }
}
