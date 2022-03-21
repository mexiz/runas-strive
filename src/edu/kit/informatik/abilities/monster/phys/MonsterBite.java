package edu.kit.informatik.abilities.monster.phys;

import edu.kit.informatik.Runa;
import edu.kit.informatik.model.AttackType;
import edu.kit.informatik.model.CardType;
import edu.kit.informatik.model.Ability;
import edu.kit.informatik.model.Monster;

/**
 * 
 * offensive Monster Fähigkeitskarte
 * 
 * @author uwhlp
 * @version 1.0.0
 * 
 */

public class MonsterBite implements Ability {

    private static final AttackType attackType = AttackType.PHYS;
    private static final CardType cardType = CardType.OFFENSIVE;
    private static final boolean BREAK_FOCUS = false;

    private int level;

    public MonsterBite(int level) {
        this.level = level;
    }

    @Override
    public int execute(int dice, Runa runa, Monster monster) {
        return 10 * level;
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
