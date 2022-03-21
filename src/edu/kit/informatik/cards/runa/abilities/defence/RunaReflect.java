package edu.kit.informatik.cards.runa.abilities.defence;

import edu.kit.informatik.cards.model.AttackType;
import edu.kit.informatik.cards.model.CardType;
import edu.kit.informatik.cards.monster.model.Monster;
import edu.kit.informatik.cards.runa.model.Runa;
import edu.kit.informatik.cards.runa.model.RunaAbilities;

/**
 * 
 * Defensive Runa Fähigkeitskarte
 * 
 * @author uwhlp
 * @version 1.0.0
 * 
 */

public class RunaReflect implements RunaAbilities {

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
