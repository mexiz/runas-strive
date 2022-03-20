package edu.kit.informatik.cards.monster.model;

import edu.kit.informatik.cards.model.AttackType;
import edu.kit.informatik.cards.runa.model.Runa;

public interface Monster {

    void attack(int dice, boolean breakFocus, Runa runa, Monster monster);

    void defend(AttackType type, boolean breakFocus, int damage);

    MonsterType getMonsterType();

    int getHealth();

}
