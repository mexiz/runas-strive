package edu.kit.informatik.cards.runa.abilities.phys;

import edu.kit.informatik.cards.model.AttackType;
import edu.kit.informatik.cards.model.CardType;
import edu.kit.informatik.cards.monster.model.Monster;
import edu.kit.informatik.cards.runa.model.Runa;
import edu.kit.informatik.cards.runa.model.RunaAbilities;

/**
 * 
 * Offensive Runa Fähigkeitskarte
 * 
 * @author uwhlp
 * @version 1.0.0
 * 
 */

public class RunaThrust implements RunaAbilities {

    private static final AttackType attackType = AttackType.PHYS;
    private static final CardType cardType = CardType.OFFENSIVE;
    private static final boolean BREAK_FOCUS = false;
    private int level;

    public RunaThrust(int level) {
        this.level = level;
    }

    @Override
    public int execute(int dice, Runa runa, Monster monster) {
        int damage = (6 * this.level) + dice;
        if (dice > 5) {
            damage += (4 * this.level);
        }
        return damage;
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
