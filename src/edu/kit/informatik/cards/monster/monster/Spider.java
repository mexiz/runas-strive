package edu.kit.informatik.cards.monster.monster;

import java.util.List;

import edu.kit.informatik.cards.monster.abilities.defence.MonsterBlock;
import edu.kit.informatik.cards.monster.abilities.phys.MonsterScratch;
import edu.kit.informatik.cards.monster.model.Monster;
import edu.kit.informatik.cards.monster.model.MonsterAbilities;
import edu.kit.informatik.cards.monster.model.MonsterType;

public class Spider implements Monster {

    private static final MonsterType MONSTER_TYPE = MonsterType.NONE;

    int health = 15;
    int countAbility = 0;
    int focusPoint = 0;

    List<MonsterAbilities> abilities = List.of(new MonsterScratch(1),
            new MonsterBlock(1));

    MonsterAbilities currentAbility;

    public Spider() {
        currentAbility = abilities.get(countAbility);
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    @Override
    public MonsterType getMonsterType() {
        return MONSTER_TYPE;
    }

    @Override
    public int getFocusPoints() {
        return focusPoint;
    }

    @Override
    public void setFocusPoints(int focusPoint) {
        this.focusPoint = focusPoint;
    }

}
