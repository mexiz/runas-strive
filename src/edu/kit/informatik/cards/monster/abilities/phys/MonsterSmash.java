package edu.kit.informatik.cards.monster.abilities.phys;

import edu.kit.informatik.cards.model.AttackType;
import edu.kit.informatik.cards.model.CardType;
import edu.kit.informatik.cards.monster.model.Monster;
import edu.kit.informatik.cards.monster.model.MonsterAbilities;
import edu.kit.informatik.cards.runa.model.Runa;

public class MonsterSmash implements MonsterAbilities {

    private static final AttackType attackType = AttackType.PHYS;
    private static final CardType cardType = CardType.OFFENSIVE;
    private static final boolean BREAK_FOCUS = false;

    private int level;

    public MonsterSmash(int level) {
        this.level = level;
    }

    @Override
    public int execute(int dice, Runa runa, Monster monster) {
        return 8 * level;
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
