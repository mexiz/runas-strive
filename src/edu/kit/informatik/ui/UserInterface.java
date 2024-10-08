package edu.kit.informatik.ui;

import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Stream;

import edu.kit.informatik.hero.HeroClass;
import edu.kit.informatik.model.Monster;
import edu.kit.informatik.model.QuitException;
import edu.kit.informatik.model.ability.Ability;

/**
 * Die Klasse kümmert sich um die Usereingaben
 * 
 * @author uwlhp
 * @version 1.0.0
 */

public class UserInterface extends UserOutput {

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
     * Gibt zurück ob das Spiel beendet ist
     * 
     * @return true wenn Spiel beendet
     */

    public boolean quit() {
        return quit;
    }

    /**
     * Die Methode wird solange aufgerufen bis quit oder eine richtige Zahl
     * eingegeben wird
     * 
     * @param message          die Nachricht
     * @param numberRangeStart Start des Eingabebereichs
     * @param numberRangeEnd   Ende des Eingabebereichs
     * @return die eingegebene Zahl
     */
    private int getUserInput(Message message, int numberRangeStart, int numberRangeEnd) throws QuitException {
        String output = String.format(message.toString(), numberRangeStart, numberRangeEnd);
        while (!quit) {
            print(output);
            String strgInput = scanner.nextLine();
            if (strgInput.matches("quit")) {
                quit = true;
                scanner.close();
                throw new QuitException();
            }
            if (isInt(strgInput)) {
                int inputNumber = Integer.parseInt(strgInput);
                if (inputNumber <= numberRangeEnd && inputNumber >= numberRangeStart) {
                    return inputNumber;
                }
            }
        }
        return 0;
    }

    /**
     * Überprüft ob der String in int umgewandelt werden kann
     * 
     * @param number String der Nummer
     * @return true wenn es umgewandelt werden kann
     */
    private boolean isInt(String number) {
        try {
            Integer.parseInt(number);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    /**
     * Die Methode wird solange aufgerufen bis quit oder eine richtige Zahl
     * eingegeben wird
     * 
     * @param message       die Nachricht
     * @param min           Mindestanzahl an ausgewählten Zahlen
     * @param max           maximale Anzahl an ausgewählten Zahlen
     * @param start         Start des Eingabebereichs
     * @param end           Ende des Eingabebereichs
     * @param allowDuplicat Ob doppelte Zahlen erlaubt sind
     * @return die eingegebenen Zahl
     */
    public int[] getNumbersSeparated(Message message, int min, int max, int start, int end, boolean allowDuplicat)
            throws QuitException {
        String output = String.format(message.toString(), start, end);
        while (!quit) {
            print(output);
            String seedString = scanner.nextLine();
            if (seedString.matches("quit")) {
                scanner.close();
                quit = true;
                throw new QuitException();
            }
            String[] splited = seedString.split(",");
            if (seedString.matches("[0-9]+([,][0-9]+)*") && splited.length <= max && splited.length >= min
                    && isNumeric(splited, start, end)) {
                int[] out = Stream.of(splited).mapToInt(Integer::parseInt).toArray();
                if (allowDuplicat || !checkDubicate(out)) {
                    return out;
                }
            }
            if (min == 0 && splited.length == 1 && splited[0].matches("")) {
                return new int[0];
            }
        }
        return new int[0];
    }

    /**
     * Abfrage nach der Klasse des Heldens
     * 
     * @param start     Start des Eingabebereichs
     * @param end       Ende des Eingabebereichs
     * @param heroClass Die Heldenklassen
     * @return die eingegebene Zahl
     */
    public int getStartHero(int start, int end, List<HeroClass> heroClass) throws QuitException {
        print(Message.MESSAGE_START_FIRST.toString());
        printClass(heroClass);
        return getUserInput(Message.MESSAGE_NUMBER, start, end);
    }

    /**
     * Gibt die gewürdelte Zahl zurück
     * 
     * @param start Start des Eingabebereichs
     * @param end   Ende des Eingabebereichs
     * @return die gewürfelte Zahl
     */
    public int getDice(int start, int end) throws QuitException {
        return getUserInput(Message.MESSAGE_DICE, start, end);
    }

    /**
     * Fragt nach den Seed und gibt den eingegeben Seed aus
     * 
     * @return den Seed
     */
    public int[] getSeed() throws QuitException {
        print(Message.MESSAGE_START_SECOND.toString());
        return getNumbersSeparated(Message.ENTER_SEEDS, 2, 2, 1, Integer.MAX_VALUE, true);
    }

    /**
     * Fragt nach der zuverwendende Fähigkeit
     * 
     * @param ability die Fähigkeiten von Runa
     * @return die gewählte Zahl der Fähigkeit
     */
    public int selectRunasAbility(List<Ability> ability) throws QuitException {
        print(Message.COMBAT_RUNA_ABILITY.toString());
        for (int i = 0; i < ability.size(); i++) {
            print((i + 1) + ") " + ability.get(i).getName() + "(" + ability.get(i).getLevel() + ")");
        }
        return getUserInput(Message.MESSAGE_NUMBER, 1, ability.size());
    }

    /**
     * Auswahl des Ziels de
     * 
     * @param enemies List mit den enemies
     * @return die Nummer des Ziels
     */
    public int selectTarget(List<Monster> enemies) throws QuitException {
        print(Message.MESSAGE_RUNA_TARGET.toString());
        for (int i = 0; i < enemies.size(); i++) {
            print((i + 1) + ") " + enemies.get(i).getName());
        }
        return getUserInput(Message.MESSAGE_NUMBER, 1, enemies.size());
    }

    /**
     * Auswahl der Belohnung
     * 
     * @return die Zahl der Belohnung
     */
    public int selectRewardType() throws QuitException {
        print(Message.MESSAGE_REWARD.toString());
        return getUserInput(Message.MESSAGE_NUMBER, 1, 2);
    }

    /**
     * Auswahl der Karten der Belohnunh
     * 
     * @param newAbilities die Karten
     * @param number       Anzahl der Karten
     * @return array mit den ausgewählten Karten
     */
    public int[] selectReward(List<Ability> newAbilities, int number) throws QuitException {
        String output = String.format(Message.PICK_CARD.toString(), number);
        print(output);
        for (int i = 0; i < newAbilities.size(); i++) {
            print((i + 1) + ") " + newAbilities.get(i).getName() + "(" + newAbilities.get(i).getLevel() + ")");
        }
        if (number == 1) {
            return getNumbersSeparated(Message.MESSAGE_NUMBER, number, number, 1, newAbilities.size(), false);
        }
        return getNumbersSeparated(Message.ENTER_NUMBER, number, number, 1, newAbilities.size(), false);
    }

    /**
     * Auswahl der Karten die entfernt werden sollen fürs heilen
     * 
     * @param health       Aktuelle Lebel
     * @param maxHealth    Maximale Lebem
     * @param runasAbility Runas Fähigkeitskarten
     * @return array mit den ausgewählten Karten
     */
    public int[] selectCardsToHeal(int health, int maxHealth, List<Ability> runasAbility) throws QuitException {
        String message = String.format(Message.REWARD_RUNA_HEALING.toString(), health, maxHealth);
        print(message);
        for (int i = 0; i < runasAbility.size(); i++) {
            print((i + 1) + ") " + runasAbility.get(i).getName() + "(" + runasAbility.get(i).getLevel() + ")");
        }
        if (runasAbility.size() == 2) {
            return getNumbersSeparated(Message.MESSAGE_NUMBER, 0, runasAbility.size() - 1, 1, runasAbility.size(),
                    false);
        }
        return getNumbersSeparated(Message.ENTER_NUMBER, 0, runasAbility.size() - 1, 1, runasAbility.size(), false);
    }

    /**
     * Überprüft ob ein Element zweimal drinnen ist
     * 
     * @param array zuüberprüfender Array
     * @return true wenn ein element zweimal vorkommt
     */

    private boolean checkDubicate(int[] array) {
        Set<Integer> check = new HashSet<>();
        for (int i : array) {
            if (!check.add(i)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Überprüft ob jedes Element aus dem Array eine Zahl ist
     * 
     * @param splited Der Array
     * @param start   Start des Eingabebereichs
     * @param end     Ende des Eingabebereichs
     * @return true wenn jedes Element eine Zahl ist
     */

    private boolean isNumeric(String[] splited, int start, int end) {
        for (String string : splited) {
            if (!string.matches("[0-9]+")) {
                return false;
            }
            try {
                int number = Integer.parseInt(string);
                if (number < start || number > end) {
                    return false;
                }
            } catch (NumberFormatException e) {
                return false;
            }
        }
        return true;
    }

}
