package edu.kit.informatik.model;

import edu.kit.informatik.Runa;

public class MagicAbility extends Ability {

    private static final int MULTIPLIER = 2;
    private static final AttackType ATTACK_TYPE = AttackType.MAGIC;
    private int valueOne;
    private int valueTwo;
    private MonsterType preferredMonster;

    public void setValue(MonsterType preferredMonster, int valueOne, int valueTwo) {
        this.preferredMonster = preferredMonster;
        this.valueOne = valueOne;
        this.valueTwo = valueTwo;
    }

    public AttackType getType() {
        return ATTACK_TYPE;
    }

    @Override
    public int execute(int dice, Runa runa, Monster monster) {
        int damage = (MULTIPLIER * super.getLevel() + valueOne) * runa.getFocus();
        if (monster.getMonsterType().equals(preferredMonster)) {
            damage += MULTIPLIER * super.getLevel();
        }
        return damage + valueTwo;
    }

}
