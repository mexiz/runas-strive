package edu.kit.informatik.character.secondlevel;

import java.util.List;

import edu.kit.informatik.abilities.monster.defence.MonsterBlock;
import edu.kit.informatik.abilities.monster.defence.MonsterFocus;
import edu.kit.informatik.abilities.monster.magic.MonsterFire;
import edu.kit.informatik.abilities.monster.magic.MonsterLightning;
import edu.kit.informatik.abilities.monster.phys.MonsterBite;
import edu.kit.informatik.model.Monster;
import edu.kit.informatik.model.MonsterType;
import edu.kit.informatik.model.ability.Ability;

/**
 * Das Monster
 * 
 * @author uwlhp
 * @version 1.0.0
 */
public class MegaSaurus extends Monster {

    private static final MonsterType MONSTER_TYPE = MonsterType.NONE;
    private static final String NAME = "Mega Saurus";
    private static final int HEALTH = 100;

    private List<Ability> abilities = List.of(new MonsterBite(2),
            new MonsterBlock(2),
            new MonsterFocus(2),
            new MonsterFire(1),
            new MonsterLightning(1));

    /**
     * Konstruktor
     */
    public MegaSaurus() {
        super.init(NAME, HEALTH, abilities, MONSTER_TYPE);
    }
}
