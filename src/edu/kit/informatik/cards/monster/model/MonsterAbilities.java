package edu.kit.informatik.cards.monster.model;

import edu.kit.informatik.cards.model.AttackType;
import edu.kit.informatik.cards.model.CardType;
import edu.kit.informatik.cards.runa.model.Runa;

public interface MonsterAbilities {

        abstract CardType getCardType();

        abstract AttackType getAttackType();

        abstract void attack(int dice, boolean breakFocus, Runa runa, Monster monster);

}
