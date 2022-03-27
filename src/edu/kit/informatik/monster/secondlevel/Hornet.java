package edu.kit.informatik.monster.secondlevel;

import java.util.List;

import edu.kit.informatik.abilities.monster.defence.MonsterFocus;
import edu.kit.informatik.abilities.monster.magic.MonsterFire;
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
public class Hornet extends Monster {

    private static final MonsterType MONSTER_TYPE = MonsterType.FIRE;
    private static final String NAME = "Hornet";
    private static final int HEALTH = 32;

    private List<Ability> abilities = List.of(new MonsterScratch(2),
            new MonsterFocus(2),
            new MonsterFire(1),
            new MonsterFire(2));

    /**
     * no
     */
    public Hornet() {
        super.init(NAME, HEALTH, abilities, MONSTER_TYPE);
    }
}
