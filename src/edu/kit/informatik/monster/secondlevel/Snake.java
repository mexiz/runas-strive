package edu.kit.informatik.monster.secondlevel;

import java.util.List;

import edu.kit.informatik.abilities.monster.defence.MonsterFocus;
import edu.kit.informatik.abilities.monster.magic.MonsterIce;
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
public class Snake extends Monster {

    private static final MonsterType MONSTER_TYPE = MonsterType.ICE;
    private static final String NAME = "Snake";
    private static final int HEALTH = 31;

    private List<Ability> abilities = List.of(new MonsterBite(2),
            new MonsterFocus(2),
            new MonsterIce(2));

    /**
     * no
     */
    public Snake() {
        super.init(NAME, HEALTH, abilities, MONSTER_TYPE);
    }
}