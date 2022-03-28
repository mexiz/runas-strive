package edu.kit.informatik.character.firstlevel;

import java.util.List;

import edu.kit.informatik.abilities.monster.defence.MonsterBlock;
import edu.kit.informatik.abilities.monster.phys.MonsterClaw;
import edu.kit.informatik.model.Monster;
import edu.kit.informatik.model.MonsterType;
import edu.kit.informatik.model.ability.Ability;

/**
 * Das Monster
 * 
 * @author uwlhp
 * @version 1.0.0
 */
public class Rat extends Monster {

    private static final MonsterType MONSTER_TYPE = MonsterType.NONE;
    private static final String NAME = "Rat";
    private static final int HEALTH = 14;

    private List<Ability> abilities = List.of(new MonsterBlock(1),
            new MonsterClaw(1));

    /**
     * Konstruktor
     */
    public Rat() {
        super.init(NAME, HEALTH, abilities, MONSTER_TYPE);
    }
}
