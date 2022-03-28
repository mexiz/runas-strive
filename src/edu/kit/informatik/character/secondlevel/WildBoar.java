package edu.kit.informatik.character.secondlevel;

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
public class WildBoar extends Monster {

    private static final MonsterType MONSTER_TYPE = MonsterType.ICE;
    private static final String NAME = "Wild Boar";
    private static final int HEALTH = 27;

    private List<Ability> abilities = List.of(new MonsterScratch(2),
            new MonsterDeflect(2),
            new MonsterScratch(2));

    /**
     * Konstruktor
     */
    public WildBoar() {
        super.init(NAME, HEALTH, abilities, MONSTER_TYPE);
    }
}
