package edu.kit.informatik.monster.secondlevel;

import java.util.List;

import edu.kit.informatik.abilities.monster.defence.MonsterBlock;
import edu.kit.informatik.abilities.monster.phys.MonsterBite;
import edu.kit.informatik.abilities.monster.phys.MonsterScratch;
import edu.kit.informatik.model.Ability;
import edu.kit.informatik.model.Monster;
import edu.kit.informatik.model.MonsterType;

/**
 * Das Monster
 * 
 * @author uwlhp
 * @version 1.0.0
 */
public class Tarantula extends Monster {

    private static final MonsterType MONSTER_TYPE = MonsterType.NONE;
    private static final String NAME = "Tarantula";
    private static final int HEALTH = 33;

    private List<Ability> abilities = List.of(new MonsterBite(2),
            new MonsterBlock(2),
            new MonsterScratch(2));

    /**
     * no
     */
    public Tarantula() {
        super.init(NAME, HEALTH, abilities, MONSTER_TYPE);
    }
}
