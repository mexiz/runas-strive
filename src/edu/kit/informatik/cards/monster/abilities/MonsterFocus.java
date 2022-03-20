package edu.kit.informatik.cards.monster.abilities;

import edu.kit.informatik.cards.model.AttackType;
import edu.kit.informatik.cards.model.CardType;
import edu.kit.informatik.cards.monster.model.Monster;
import edu.kit.informatik.cards.monster.model.MonsterAbilities;
import edu.kit.informatik.cards.runa.model.Runa;

public class MonsterFocus implements MonsterAbilities {

    private static final AttackType attackType = AttackType.PHYS;
    private static final CardType cardType = CardType.OFFENSIVE;

    private int level;

    public MonsterFocus(int level) {
        this.level = level;
    }

    @Override
    public void attack(int dice, boolean breakFocus, Runa runa, Monster monster) {
        // TODO Auto-generated method stub

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
