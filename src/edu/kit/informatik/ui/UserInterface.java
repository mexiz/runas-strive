package edu.kit.informatik.ui;

import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Stream;

import edu.kit.informatik.hero.HeroClass;
import edu.kit.informatik.model.Ability;
import edu.kit.informatik.model.AttackType;
import edu.kit.informatik.model.Monster;

/**
 * 
 * @author uwlhp
 * @version 1.0.0
 */

public class UserInterface {

    private Scanner scanner;
    private boolean quit;

    /**
     * Konstruktor
     */
    public UserInterface() {
        scanner = new Scanner(System.in);
        quit = false;
    }

    /**
     * 
     * 
     * @return
     */

    public boolean quit() {
        return quit;
    }

    /**
     * 
     * 
     * @param message
     * @param numberRangeStart
     * @param numberRangeEnd
     * @return
     */
    private int getUserInput(Message message, int numberRangeStart, int numberRangeEnd) {
        String output = String.format(message.toString(), numberRangeStart, numberRangeEnd);
        while (true) {
            print(output);
            String strgInput = scanner.nextLine();
            if (strgInput.matches("quit")) {
                quit = true;
                scanner.close();
                return 0;
            } else if (strgInput.matches("[0-9]+")) {
                int inputNumber = Integer.parseInt(strgInput);
                if (inputNumber <= numberRangeEnd && inputNumber >= numberRangeStart) {
                    return inputNumber;
                }
            }
        }
    }

    /**
     * 
     * @param minNumbergg
     * @param maxNumber
     * @param message
     * @param start
     * @param end
     * @return
     */
    public int[] getNumbersSeparated(Message message, int min, int max, int start, int end) {
        String output = String.format(message.toString(), start, end);
        do {
            print(output);
            String seedString = scanner.nextLine();
            if (seedString.matches("quit")) {
                scanner.close();
                quit = true;
                return new int[0];
            }
            String[] splited = seedString.split(",");
            if (seedString.matches("[0-9]+([,][0-9]+)*") && splited.length <= max && splited.length >= min
                    && isNumeric(splited, start, end)) {
                int[] out = Stream.of(splited).mapToInt(Integer::parseInt).toArray();
                if (!checkDubicate(out)) {
                    return out;
                }
            }
            if (min == 0 && splited.length == 1 && splited[0].matches("")) {
                return new int[0];
            }
        } while (true);
    }

    /**
     * 
     * @param splited
     * @param start
     * @param end
     * @return
     */

    private boolean isNumeric(String[] splited, int start, int end) {
        for (String string : splited) {
            if (!string.matches("[0-9]+")) {
                return false;
            }
            int number = Integer.parseInt(string);
            if (number < start || number > end) {
                return false;
            }
        }
        return true;
    }

    /**
     * 
     * 
     * @param print
     */
    public void print(String print) {
        System.out.println(print);
    }

    /**
     * 
     */
    public int getStartHero(int start, int end, List<HeroClass> heroClass) {
        print(Message.MESSAGE_START_FIRST.toString());
        printClass(heroClass);
        return getUserInput(Message.MESSAGE_NUMBER, start, end);
    }

    /**
     * 
     * @param start
     * @param end
     * @return
     */
    public int getDice(int start, int end) {
        return getUserInput(Message.MESSAGE_DICE, start, end);
    }

    /**
     * 
     * 
     * @return
     */
    public int[] getSeed() {
        return getNumbersSeparated(Message.MESSAGE_START_SECOND, 2, 2, 1, Integer.MAX_VALUE);
    }

    /**
     * 
     * @param heroClass
     */
    public void printClass(List<HeroClass> heroClass) {
        for (int i = 0; i < heroClass.size(); i++) {
            print((i + 1) + ") " + heroClass.get(i).getHeroName());
        }
    }

    /**
     * 
     * @param health
     * @param maxhealth
     * @param focusPoint
     * @param maxfocusPoint
     */
    public void printRuna(int health, int maxhealth, int focusPoint, int maxfocusPoint) {
        print("Runa (" + health + "/" + maxhealth + " HP, " + focusPoint + "/" + maxfocusPoint + " FP)");
    }

    /**
     * 
     * @param name
     * @param ability
     * @param health
     * @param focusPoint
     */
    public void printMonster(String name, String ability, int health, int focusPoint) {
        print(name + "(" + health + " HP, " + focusPoint + " FP): attempts " + ability + " next");
    }

    /**
     * 
     * @param target
     * @param damage
     * @param type
     */
    public void printDamge(String target, int damage, AttackType type) {
        String typ = "";
        if (type.equals(AttackType.MAGIC)) {
            typ = "mag.";
        } else if (type.equals(AttackType.PHYS)) {
            typ = "phy.";
        }
        String message = String.format(Message.MESSAGE_TAKE_DAMAGE.toString(), target, damage, typ);
        print(message);
    }

    /**
     * 
     * @param ability
     * @return
     */
    public int getRunaAbility(List<Ability> ability) {
        print(Message.MESSAGE_RUNA_ABILITY.toString());
        for (int i = 0; i < ability.size(); i++) {
            print((i + 1) + ") " + ability.get(i).getName());
        }
        return getUserInput(Message.MESSAGE_NUMBER, 1, ability.size());
    }

    /**
     * 
     * @param monster
     * @return
     */
    public int getTargetMonster(List<Monster> monster) {
        print(Message.MESSAGE_RUNA_TARGET.toString());
        for (int i = 0; i < monster.size(); i++) {
            print((i + 1) + ") " + monster.get(i).getName());
        }
        return getUserInput(Message.MESSAGE_NUMBER, 1, monster.size());
    }

    /**
     * 
     * @param target
     * @param ability
     */
    public void printUsedAbility(String target, Ability ability) {
        String message = String.format(Message.MESSAGE_ABILITY_USE.toString(), target,
                ability.getName() + "(" + ability.getLevel() + ")");
        print(message);
    }

    public void printNewAbility(Ability ability) {
        String message = String.format(Message.MESSAGE_NEW_ABILITY.toString(),
                ability.getName() + "(" + ability.getLevel() + ")");
        print(message);
    }

    /**
     * 
     * @param stage
     * @param level
     */
    public void printLevel(int stage, int level) {
        String message = String.format(Message.MESSAGE_LEVEL.toString(), stage, level);
        print(message);
    }

    public void printStatus(List<Monster> enemies, int runahealth, int runaFocus) {
        print(Message.MESSAGE_LINE_SEPERATOR.toString());
        printRuna(runahealth, 50, runahealth, 4);
        print(Message.MESSAGE_VERSUS.toString());
        for (Monster monster : enemies) {
            printMonster(monster.getName(), monster.getCurrentAbility().getName(),
                    monster.getHealth(),
                    monster.getFocusPoints());
        }
        print(Message.MESSAGE_LINE_SEPERATOR.toString());
    }

    /**
     * 
     * @param name
     */
    public void printDies(String name) {
        print(name + " dies");
    }

    /**
     * 
     * @return
     */
    public int getReward() {
        return getUserInput(Message.MESSAGE_REWARD, 1, 2);
    }

    public int[] getReward(List<Ability> newAbilities, int number) {
        String output = String.format(Message.PICK_CARD.toString(), number);
        print(output);
        for (int i = 0; i < newAbilities.size(); i++) {
            print((i + 1) + ") " + newAbilities.get(i).getName());
        }
        return getNumbersSeparated(Message.ENTER_NUMBER, number, number, 1, newAbilities.size());
    }

    /**
     * 
     * @param health
     * @param maxHealth
     * @param runasAbility
     */
    public int[] getHeal(int health, int maxHealth, List<Ability> runasAbility) {
        String message = String.format(Message.MESSAGE_RUNA_HEALING.toString(), health, maxHealth);
        print(message);
        for (int i = 0; i < runasAbility.size(); i++) {
            print((i + 1) + ") " + runasAbility.get(i).getName());
        }
        return getNumbersSeparated(Message.ENTER_NUMBER, 0, runasAbility.size(), 1, runasAbility.size());
    }

    private boolean checkDubicate(int[] array) {
        Set<Integer> check = new HashSet<>();
        for (int i : array) {
            if (!check.add(i)) {
                return true;
            }
        }
        return false;
    }

}
