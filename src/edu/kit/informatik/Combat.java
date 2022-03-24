package edu.kit.informatik;

import java.util.List;

import edu.kit.informatik.abilities.EmptyAbility;
import edu.kit.informatik.model.Ability;
import edu.kit.informatik.model.AttackType;
import edu.kit.informatik.model.CardType;
import edu.kit.informatik.model.Monster;

public class Combat {

    private List<Monster> enemies;
    private Runa runa;

    private boolean done;

    public Combat(Runa runa, List<Monster> enemies) {
        this.enemies = enemies;
        this.runa = runa;
        done = false;
    }

    public void setRunasCurrentAbility(Ability ability) {
        if (runa.getCurrentAbility().getCardType().equals(CardType.FOCUS)) {
            runa.setFocus(runa.getFocus() + runa.getCurrentAbility().execute(0, runa, null));
        }
        runa.setCurrentAbility(ability);
    }

    public int attackFromRuna(Ability ability, int target, int dice) {
        setRunasCurrentAbility(ability);
        int damage = 0;
        if (ability.getCardType().equals(CardType.OFFENSIVE)) {
            Monster monster = enemies.get(target);
            damage = runa.getCurrentAbility().execute(dice, runa, monster);
            if (ability.getAttackType().equals(AttackType.MAGIC) && runa.getFocus() > 1) {
                runa.setFocus(runa.getFocus() - 1);
            }

            if (monster.getPrevAbility().getCardType().equals(CardType.DEFENSIV)) {
                if (monster.getPrevAbility().getAttackType().equals(runa.getCurrentAbility().getAttackType())) {

                    int defence = monster.getPrevAbility().execute(0, null, null);
                    damage += defence;
                }
            }
            if (damage > 0) {
                monster.setHealth(monster.getHealth() - damage);
            }
            runa.setCurrentAbility(new EmptyAbility());

        }
        return damage;

    }

    public int attackFromMonster(int monsterInList) {
        Monster monster = enemies.get(monsterInList);
        switch (monster.getPrevAbility().getCardType()) {
            case FOCUS:
                int focuspoints = monster.getPrevAbility().execute(0, null, null);
                monster.setFocusPoints(monster.getFocusPoints() + focuspoints);
                break;
            case DEFENSIV:
                monster.setPrevAbility(new EmptyAbility());
                break;
            default:
                break;
        }
        while (!monster.isAffordable()) {
            monster.changeAbility();
        }

        int damage = 0;
        if (monster.getCurrentAbility().getCardType().equals(CardType.OFFENSIVE)) {
            if (monster.getCurrentAbility().getAttackType().equals(AttackType.MAGIC)) {
                monster.setFocusPoints(monster.getFocusPoints() - monster.getCurrentAbility().getLevel());
            }
            damage = monster.getCurrentAbility().execute(0, runa, monster);
            if (runa.getCurrentAbility().getCardType().equals(CardType.DEFENSIV)) {
                if (monster.getCurrentAbility().getAttackType().equals(runa.getCurrentAbility().getAttackType())) {
                    damage += runa.getCurrentAbility().execute(0, null, null);
                }
            }
        }
        if (damage > 0) {
            runa.setHealth(monster.getHealth() - damage);
        }
        
        return damage;
    }

    public List<Monster> getEnemies() {
        return enemies;
    }

    public boolean finished() {
        for (Monster monster : enemies) {
            done = done && monster.dead();
        }
        return enemies.isEmpty() || runa.dead();
    }

}
