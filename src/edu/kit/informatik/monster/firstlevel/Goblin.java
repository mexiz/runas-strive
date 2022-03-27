package edu.kit.informatik.monster.firstlevel;

import java.util.List;

import edu.kit.informatik.abilities.monster.defence.MonsterDeflect;
import edu.kit.informatik.abilities.monster.phys.MonsterSmash;
import edu.kit.informatik.model.Ability;
import edu.kit.informatik.model.Monster;
import edu.kit.informatik.model.MonsterType;

/**
 * Das Monster
 * 
 * @author uwlhp
 * @version 1.0.0
 */
public class Goblin extends Monster {

    private static final MonsterType MONSTER_TYPE = MonsterType.NONE;
    private static final String NAME = "Goblin";
    private static final int HEALTH = 12;

    private List<Ability> abilities = List.of(new MonsterSmash(1),
            new MonsterDeflect(1));

    /**
     * no
     */
    public Goblin() {
        super.init(NAME, HEALTH, abilities, MONSTER_TYPE);
    }
}
