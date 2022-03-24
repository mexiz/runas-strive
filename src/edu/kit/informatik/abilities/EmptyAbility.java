package edu.kit.informatik.abilities;

import edu.kit.informatik.Runa;
import edu.kit.informatik.model.Ability;
import edu.kit.informatik.model.AttackType;
import edu.kit.informatik.model.CardType;
import edu.kit.informatik.model.Monster;

public class EmptyAbility extends Ability {

    private static final AttackType attackType = AttackType.NONE;
    private static final CardType cardType = CardType.NONE;
    private static final String name = "Empty";

    @Override
    public int execute(int dice, Runa runa, Monster monster) {
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

    @Override
    public String getName() {
        return "";
    }

    @Override
    public int getLevel() {
        return 0;
    }

}
