package edu.kit.informatik.abilities.runa.magic;

import edu.kit.informatik.Runa;
import edu.kit.informatik.model.AttackType;
import edu.kit.informatik.model.CardType;
import edu.kit.informatik.model.Monster;
import edu.kit.informatik.model.Ability;
import edu.kit.informatik.monster.MonsterType;

/**
 * 
 * Offensive Runa Fähigkeitskarte
 * 
 * @author uwhlp
 * @version 1.0.0
 * 
 */

public class RunaFire implements Ability {

    private static final AttackType attackType = AttackType.MAGIC;
    private static final CardType cardType = CardType.OFFENSIVE;
    private static final boolean BREAK_FOCUS = false;

    private int level;

    public RunaFire(int level) {
        this.level = level;
    }

    @Override
    public int execute(int dice, Runa runa, Monster monster) {
        if (runa.getFocus() < 1) {
            return 0;
        }

        int damage = (2 * this.level) + 5;
        damage *= runa.getFocus();
        if (monster.getMonsterType().equals(MonsterType.EIS)) {
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
