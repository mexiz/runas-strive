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

public class MonsterDeflect implements Ability {

    private static final AttackType attackType = AttackType.MAGIC;
    private static final CardType cardType = CardType.DEFENSIV;
    private static final boolean BREAK_FOCUS = false;

    private int level;

    public MonsterDeflect(int level) {
        this.level = level;
    }

    @Override
    public int execute(int dice, Runa runa, Monster monster) {
        return ((-11) * level) + 2;
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
