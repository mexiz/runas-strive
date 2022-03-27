package edu.kit.informatik.monster.firstlevel;

import java.util.List;

import edu.kit.informatik.abilities.monster.defence.MonsterFocus;
import edu.kit.informatik.abilities.monster.magic.MonsterFire;
import edu.kit.informatik.model.Ability;
import edu.kit.informatik.model.Monster;
import edu.kit.informatik.model.MonsterType;

/**
 * Das Monster
 * 
 * @author uwlhp
 * @version 1.0.0
 */
public class Gorgon extends Monster {

    private static final MonsterType MONSTER_TYPE = MonsterType.FIRE;
    private static final String NAME = "Gorgon";
    private static final int HEALTH = 13;

    private List<Ability> abilities = List.of(new MonsterFocus(1),
            new MonsterFire(1));

    /**
     * no
     */
    public Gorgon() {
        super.init(NAME, HEALTH, abilities, MONSTER_TYPE);
    }

}
