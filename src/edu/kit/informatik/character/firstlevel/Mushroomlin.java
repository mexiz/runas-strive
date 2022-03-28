package edu.kit.informatik.character.firstlevel;

import java.util.List;

import edu.kit.informatik.abilities.monster.defence.MonsterDeflect;
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
public class Mushroomlin extends Monster {

    private static final MonsterType MONSTER_TYPE = MonsterType.NONE;
    private static final String NAME = "Mushroomlin";
    private static final int HEALTH = 20;

    private List<Ability> abilities = List.of(new MonsterDeflect(1),
            new MonsterScratch(1));

    /**
     * Konstruktor
     */
    public Mushroomlin() {
        super.init(NAME, HEALTH, abilities, MONSTER_TYPE);
    }

}
