package edu.kit.informatik.cards.runa.abilities.magic;

import edu.kit.informatik.cards.model.AttackType;
import edu.kit.informatik.cards.model.CardType;
import edu.kit.informatik.cards.monster.model.Monster;
import edu.kit.informatik.cards.monster.model.MonsterType;
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

public class RunaIce implements RunaAbilities {

    private static final AttackType attackType = AttackType.PHYS;
    private static final CardType cardType = CardType.OFFENSIVE;
    private static final boolean BREAK_FOCUS = false;
    private int level;

    public RunaIce(int level) {
        this.level = level;
    }

    @Override
    public int execute(int dice, Runa runa, Monster monster) {

        if (runa.getFocus() < 1) {
            return 0;
        }
        int damage = (2 * this.level) + 4;
        damage *= runa.getFocus();
        damage += 2;
        if (monster.getMonsterType().equals(MonsterType.WASSER)) {
            damage += 2 * this.level;
        }
        runa.setFocus(runa.getFocus() - 1);
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
