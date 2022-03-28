package edu.kit.informatik.character.secondlevel;

import java.util.List;

import edu.kit.informatik.abilities.monster.defence.MonsterFocus;
import edu.kit.informatik.abilities.monster.magic.MonsterLightning;
import edu.kit.informatik.abilities.monster.phys.MonsterScratch;
import edu.kit.informatik.model.Monster;
import edu.kit.informatik.model.MonsterType;
import edu.kit.informatik.model.ability.Ability;

/**
 * Das Monster
 * 
 * @author uwlhp
 * @version 1.0.0
 */
public class ShadomBlade extends Monster {

    private static final MonsterType MONSTER_TYPE = MonsterType.LIGHTNING;
    private static final String NAME = "Shadow Blade";
    private static final int HEALTH = 27;
    private List<Ability> abilities = List.of(new MonsterScratch(2),
            new MonsterFocus(2),
            new MonsterLightning(2));

    /**
     * Konstruktor
     */
    public ShadomBlade() {
        super.init(NAME, HEALTH, abilities, MONSTER_TYPE);
    }
}
