package edu.kit.informatik.abilities.monster.defence;

import edu.kit.informatik.Runa;
import edu.kit.informatik.model.AttackType;
import edu.kit.informatik.model.CardType;
import edu.kit.informatik.model.Ability;
import edu.kit.informatik.model.Monster;

/**
 * 
 * Defensive Monster Fähigkeitskarte
 * 
 * @author uwhlp
 * @version 1.0.0
 * 
 */

public class MonsterBlock extends Ability {

    private static final AttackType attackType = AttackType.PHYS;
    private static final CardType cardType = CardType.DEFENSIV;
    private static final boolean BREAK_FOCUS = false;

    private static final String name = "Block";

    private int level;

    public MonsterBlock(int level) {
        this.level = level;
    }

    @Override
    public int execute(int dice, Runa runa, Monster monster) {
        return (-7) * level;
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
