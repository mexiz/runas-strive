package edu.kit.informatik.cards.monster.abilities.magic;

import edu.kit.informatik.cards.model.AttackType;
import edu.kit.informatik.cards.model.CardType;
import edu.kit.informatik.cards.monster.model.Monster;
import edu.kit.informatik.cards.monster.model.MonsterAbilities;
import edu.kit.informatik.cards.runa.model.Runa;

public class MonsterFire implements MonsterAbilities {

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
