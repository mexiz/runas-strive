package edu.kit.informatik.abilities.monster.defence;

import edu.kit.informatik.Runa;
import edu.kit.informatik.model.AttackType;
import edu.kit.informatik.model.CardType;
import edu.kit.informatik.model.Ability;
import edu.kit.informatik.model.Monster;

public class MonsterFocus implements Ability {

    private static final AttackType attackType = AttackType.PHYS;
    private static final CardType cardType = CardType.OFFENSIVE;
    private static final boolean BREAK_FOCUS = false;

    private int level;

    public MonsterFocus(int level) {
        this.level = level;
    }

    @Override
    public int execute(int dice, Runa runa, Monster monster) {
        return 1;
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
