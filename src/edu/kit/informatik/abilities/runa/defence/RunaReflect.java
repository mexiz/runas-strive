package edu.kit.informatik.abilities.runa.defence;

import edu.kit.informatik.Runa;
import edu.kit.informatik.model.AttackType;
import edu.kit.informatik.model.CardType;
import edu.kit.informatik.model.Monster;
import edu.kit.informatik.model.Ability;

/**
 * 
 * Defensive Runa Fähigkeitskarte
 * 
 * @author uwhlp
 * @version 1.0.0
 * 
 */

public class RunaReflect implements Ability {

    private static final AttackType attackType = AttackType.MAGIC;
    private static final CardType cardType = CardType.DEFENSIV;
    private static final boolean BREAK_FOCUS = false;

    private int level;

    public RunaReflect(int level) {
        this.level = level;
    }

    @Override
    public int execute(int dice, Runa runa, Monster monster) {
        return (-10) * level;
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
