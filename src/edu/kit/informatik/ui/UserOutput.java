package edu.kit.informatik.ui;

import java.util.List;

import edu.kit.informatik.hero.HeroClass;
import edu.kit.informatik.model.Monster;
import edu.kit.informatik.model.ability.Ability;
import edu.kit.informatik.model.ability.AttackType;
import edu.kit.informatik.util.GameData;

/**
 * Klasse für die Konsolenausgabe
 * 
 * @author uwlhp
 * @version 1.0.0
 */

public class UserOutput {

    /**
     * Gibt den String aus
     * 
     * @param print der String zum Ausgeben
     */
    public void print(String print) {
        System.out.println(print);
    }

    /**
     * Gibt die Heldenklassen aus
     * 
     * @param heroClass die Heldenklassen
     */
    public void printClass(List<HeroClass> heroClass) {
        for (int i = 0; i < heroClass.size(); i++) {
            print((i + 1) + ") " + heroClass.get(i).getHeroName());
        }
    }

    /**
     * Gibt den Schaden aus
     * 
     * @param target Name vom Gegner
     * @param damage Schaden
     * @param type   Art des Angriffs
     */
    public void printDamge(String target, int damage, AttackType type) {
        String typ = "";
        if (type.equals(AttackType.MAGIC)) {
            typ = "mag.";
        } else if (type.equals(AttackType.PHYS)) {
            typ = "phy.";
        }
        print(Message.MESSAGE_TAKE_DAMAGE.formatted(target, damage, typ));
    }

    /**
     * Gibt die benutzte Fähigkeit aus
     * 
     * @param target  Name vom Gegner
     * @param ability die Fähigkeit
     */
    public void printUsedAbility(String target, Ability ability) {
        String message = ability.getName() + "(" + ability.getLevel() + ")";
        print(Message.COMBAT_ABILITY_USE.formatted(target, message));
    }

    /**
     * Gibt die neue Fähigkeit aus
     * 
     * @param ability die Fähigkeit
     */
    public void printNewAbility(Ability ability) {
        print(Message.REWARD_NEW_ABILITY.formatted(ability.getName() + "(" + ability.getLevel() + ")"));
    }

    /**
     * Gibt die erworbenen Fokuspunkte aus
     * 
     * @param name   der Name
     * @param points die Punkte
     */
    public void printFocusPoint(String name, int points) {
        print(Message.FOCUSPOINT.formatted(name, points));
    }

    /**
     * Gibt den Status(Anfang jedes Kampfes)
     * 
     * @param enemies      die Gegner
     * @param runahealth   Runas Leben
     * @param runaFocus    Runas Fokuspunkte
     * @param runaMaxFocus die maximalen Fokuspunkte
     */
    public void printStatus(List<Monster> enemies, int runahealth, int runaFocus, int runaMaxFocus) {
        print(Message.MESSAGE_LINE_SEPERATOR.toString());
        printRuna(runahealth, GameData.getInstance().getMaxHealth(), runaFocus, runaMaxFocus);
        print(Message.MESSAGE_VERSUS.toString());
        for (Monster monster : enemies) {
            printMonster(monster.getName(), monster.getCurrentAbility(),
                    monster.getHealth(),
                    monster.getFocusPoints());
        }
        print(Message.MESSAGE_LINE_SEPERATOR.toString());
    }

    /**
     * Gibt Runa aus
     * 
     * @param health
     * @param maxhealth     Runas Leben
     * @param focusPoint    Runas Fokuspunkte
     * @param maxfocusPoint Runas maximale Fokuspunkte
     */
    public void printRuna(int health, int maxhealth, int focusPoint, int maxfocusPoint) {
        print("Runa (" + health + "/" + maxhealth + " HP, " + focusPoint + "/" + maxfocusPoint + " FP)");
    }

    /**
     * Gibt den Monster aus
     * 
     * @param name       der Name des Monsters
     * @param ability    die Fähigkeit
     * @param health     Anzahl an Leben
     * @param focusPoint die Fokuspuntke
     */
    public void printMonster(String name, Ability ability, int health, int focusPoint) {
        print(name + " (" + health + " HP, " + focusPoint + " FP): attempts " + ability.getName() + "("
                + ability.getLevel() + ")" + " next");
    }

    /**
     * Gibt den Raum und das Level aus
     * 
     * @param stage der Raum
     * @param level das Level
     */
    public void printLevel(int stage, int level) {
        print(Message.STAGE_START.formatted(stage, level));
    }

    /**
     * Gibt aus den gestorbenen Charakter aus
     * 
     * @param name der Name des Charakters
     */
    public void printDies(String name) {
        print(name + " dies");
    }

    /**
     * Gibt den Heilungswert aus
     * 
     * @param health Wert der Heilung
     */

    public void printHeal(int health) {
        print(Message.REWARD_HEAL.formatted(health));
    }

    /**
     * Runa hat gewonnen
     * 
     */

    public void printWon() {
        print(Message.RUNA_WON.toString());
    }
}
