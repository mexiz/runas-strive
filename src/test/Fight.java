package test;


import edu.kit.informatik.Runa;
import edu.kit.informatik.hero.Mage;
import edu.kit.informatik.model.AttackType;
import edu.kit.informatik.model.CardType;
import edu.kit.informatik.model.Monster;
import edu.kit.informatik.monster.secondlevel.Bear;

/**
 * Fight
 */
public class Fight {

    // Monster monster = new Bear();
    // Runa runa = new Runa(new Mage());

    // public void execute(int dice, Runa runa) {
    //     if (!monster.getAbility().getCardType().equals(CardType.DEFENSIV)) {
    //         //runa.defend(monster.getAbility().getAttackType(), monster.getAbility().execute(dice, runa, monster));
    //         monster.changeAbility();
    //     }
    // }

    // public void defend(AttackType type, int damage) {
    //     int newDamage = damage;
    //     if (monster.getAbility().getCardType().equals(CardType.DEFENSIV)
    //             && monster.getAbility().getAttackType().equals(type)) {
    //         newDamage += monster.getAbility().execute(0, null, null);
    //     }
    //     if (newDamage > 0) {
    //         monster.setHealth(monster.getHealth() - newDamage);
    //     }
    // }

    // public void executeRuna(int dice, Monster monster) {
    //     //monster.defend(runa.choosedAbilities.getAttackType(), runa.choosedAbilities.execute(dice, this, monster));
    // }

    // public void defendRUNA(AttackType type, int damage) {
    //     int newDamage = damage;
    //     if (runa.choosedAbilities.getCardType().equals(CardType.DEFENSIV)

    //             && runa.choosedAbilities.getAttackType().equals(type)) {
    //         newDamage -= runa.choosedAbilities.execute(0, null, null);
    //     }
    //     if (newDamage > 0) {
    //         runa.setHealth(runa.getHealth() - newDamage);
    //     }
    // }
}