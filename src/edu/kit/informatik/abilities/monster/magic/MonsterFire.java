package edu.kit.informatik.abilities.monster.magic;

import edu.kit.informatik.Runa;
import edu.kit.informatik.model.AttackType;
import edu.kit.informatik.model.CardType;
import edu.kit.informatik.model.Ability;
import edu.kit.informatik.model.Monster;

public class MonsterFire implements Ability {

    private static final AttackType attackType = AttackType.MAGIC;
    private static final CardType cardType = CardType.OFFENSIVE;
    private static final boolean BREAK_FOCUS = false;

    private int level;

    public MonsterFire(int level) {
        this.level = level;
    }

    @Override
    public int execute(int dice, Runa runa, Monster monster) {
        if (monster.getFocusPoints() > level - 1) {

            int damage = 12 * level;
            damage += 2;
            monster.setFocusPoints(monster.getFocusPoints() - level);
            return damage;
        }
        return 0;
    }

    @Override
    public CardType getCardType() {
        return cardType;
    }

    @Override
    public AttackType getAttackType() {
        return attackType;
    }

}
