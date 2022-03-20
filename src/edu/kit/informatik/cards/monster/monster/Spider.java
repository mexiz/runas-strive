package edu.kit.informatik.cards.monster.monster;

import java.util.List;

import edu.kit.informatik.cards.model.AttackType;
import edu.kit.informatik.cards.model.CardType;
import edu.kit.informatik.cards.monster.abilities.defence.MonsterBlock;
import edu.kit.informatik.cards.monster.abilities.phys.MonsterScratch;
import edu.kit.informatik.cards.monster.model.Monster;
import edu.kit.informatik.cards.monster.model.MonsterAbilities;
import edu.kit.informatik.cards.monster.model.MonsterType;
import edu.kit.informatik.cards.runa.model.Runa;

public class Spider implements Monster {

    private static final MonsterType MONSTER_TYPE = MonsterType.NONE;

    int health = 15;
    int countAbility = 0;

    List<MonsterAbilities> abilities = List.of(new MonsterScratch(1),
            new MonsterBlock(1));

    MonsterAbilities currentAbility;

    public Spider() {
        currentAbility = abilities.get(countAbility);
    }

    @Override
    public void attack(int dice, boolean breakFocus, Runa runa, Monster monster) {
        if (currentAbility.getCardType().equals(CardType.OFFENSIVE)) {
            currentAbility.attack(dice, breakFocus, runa, monster);
        }
    }

    @Override
    public void defend(AttackType type, boolean breakFocus, int damage) {
        health -= damage;
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

}
