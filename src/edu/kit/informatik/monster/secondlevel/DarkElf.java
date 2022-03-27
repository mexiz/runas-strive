package edu.kit.informatik.monster.secondlevel;

import java.util.List;

import edu.kit.informatik.abilities.monster.defence.MonsterFocus;
import edu.kit.informatik.abilities.monster.magic.MonsterLightning;
import edu.kit.informatik.abilities.monster.magic.MonsterWater;
import edu.kit.informatik.model.Ability;
import edu.kit.informatik.model.Monster;
import edu.kit.informatik.model.MonsterType;

/**
 * Das Monster
 * 
 * @author uwlhp
 * @version 1.0.0
 */
public class DarkElf extends Monster {

    private static final MonsterType MONSTER_TYPE = MonsterType.NONE;
    private static final String NAME = "Dark Elf";
    private static final int HEALTH = 34;

    private List<Ability> abilities = List.of(new MonsterFocus(2),
            new MonsterWater(1),
            new MonsterLightning(1));

    /**
     * no
     */
    public DarkElf() {
        super.init(NAME, HEALTH, abilities, MONSTER_TYPE);
    }
}
