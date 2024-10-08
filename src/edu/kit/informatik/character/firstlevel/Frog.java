package edu.kit.informatik.character.firstlevel;

import java.util.List;

import edu.kit.informatik.abilities.monster.defence.MonsterFocus;
import edu.kit.informatik.abilities.monster.magic.MonsterWater;
import edu.kit.informatik.model.Monster;
import edu.kit.informatik.model.MonsterType;
import edu.kit.informatik.model.ability.Ability;

/**
 * Das Monster Frog
 * 
 * @author uwlhp
 * @version 1.0.0
 */

public class Frog extends Monster {

    private static final MonsterType MONSTER_TYPE = MonsterType.WATER;

    private static final String NAME = "Frog";

    private static final int HEALTH = 16;

    /**
     * Konstruktor
     */
    public Frog() {
        List<Ability> abilities = List.of(new MonsterFocus(1),
                new MonsterWater(1));
        super.init(NAME, HEALTH, abilities, MONSTER_TYPE);
    }

}
