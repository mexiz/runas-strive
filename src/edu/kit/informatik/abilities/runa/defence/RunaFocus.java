package edu.kit.informatik.abilities.runa.defence;

import edu.kit.informatik.Runa;
import edu.kit.informatik.model.AttackType;
import edu.kit.informatik.model.CardType;
import edu.kit.informatik.model.Monster;
import edu.kit.informatik.model.Ability;

//TODO

public class RunaFocus extends Ability {

    private static final AttackType attackType = AttackType.MAGIC;
    private static final CardType cardType = CardType.OFFENSIVE;
    private static final boolean BREAK_FOCUS = false;
    private static final String name = "Focus";
    private int level;

    public RunaFocus(int level) {
        this.level = level;
    }

    @Override
    public int execute(int dice, Runa runa, Monster monster) {
        // TODO Auto-generated method stub
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
        return name + "(" + level + ")";
    }

}
