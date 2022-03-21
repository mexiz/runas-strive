package edu.kit.informatik.cards.monster.model;

import edu.kit.informatik.cards.model.AttackType;
import edu.kit.informatik.cards.model.CardType;
import edu.kit.informatik.cards.runa.model.Runa;

public interface MonsterAbilities {

        int execute(int dice, Runa runa, Monster monster);

        CardType getCardType();

        AttackType getAttackType();

}
