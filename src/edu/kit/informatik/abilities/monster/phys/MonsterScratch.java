package edu.kit.informatik.abilities.monster.phys;

import edu.kit.informatik.Runa;
import edu.kit.informatik.model.AttackType;
import edu.kit.informatik.model.CardType;
import edu.kit.informatik.model.Ability;
import edu.kit.informatik.model.Monster;

public class MonsterScratch implements Ability {

    private static final AttackType attackType = AttackType.PHYS;
    private static final CardType cardType = CardType.OFFENSIVE;
    private static final boolean BREAK_FOCUS = true;

    private int level;

    public MonsterScratch(int level) {
        this.level = level;
    }

    @Override
    public int execute(int dice, Runa runa, Monster monster) {
        return  5 * level;
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
