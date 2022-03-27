package edu.kit.informatik.monster.secondlevel;

import java.util.List;

import edu.kit.informatik.abilities.monster.defence.MonsterDeflect;
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
public class WildBoar extends Monster {

    private static final MonsterType MONSTER_TYPE = MonsterType.ICE;
    private static final String NAME = "WildBoar";
    private static final int HEALTH = 27;

    private List<Ability> abilities = List.of(new MonsterScratch(2),
            new MonsterDeflect(2),
            new MonsterScratch(2));

    /**
     * no
     */
    public WildBoar() {
        super.init(NAME, HEALTH, abilities, MONSTER_TYPE);
    }
}
