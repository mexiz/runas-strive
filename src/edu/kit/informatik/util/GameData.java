package edu.kit.informatik.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import edu.kit.informatik.abilities.runa.defence.RunaFocus;
import edu.kit.informatik.abilities.runa.defence.RunaParry;
import edu.kit.informatik.abilities.runa.defence.RunaReflect;
import edu.kit.informatik.abilities.runa.magic.RunaFire;
import edu.kit.informatik.abilities.runa.magic.RunaIce;
import edu.kit.informatik.abilities.runa.magic.RunaLightning;
import edu.kit.informatik.abilities.runa.magic.RunaWater;
import edu.kit.informatik.abilities.runa.phys.RunaPierce;
import edu.kit.informatik.abilities.runa.phys.RunaSlash;
import edu.kit.informatik.abilities.runa.phys.RunaSwing;
import edu.kit.informatik.abilities.runa.phys.RunaThrust;
import edu.kit.informatik.character.firstlevel.Frog;
import edu.kit.informatik.character.firstlevel.Ghost;
import edu.kit.informatik.character.firstlevel.Goblin;
import edu.kit.informatik.character.firstlevel.Gorgon;
import edu.kit.informatik.character.firstlevel.Mushroomlin;
import edu.kit.informatik.character.firstlevel.Rat;
import edu.kit.informatik.character.firstlevel.Skeleton;
import edu.kit.informatik.character.firstlevel.Spider;
import edu.kit.informatik.character.firstlevel.SpiderKing;
import edu.kit.informatik.character.secondlevel.Bear;
import edu.kit.informatik.character.secondlevel.DarkElf;
import edu.kit.informatik.character.secondlevel.Hornet;
import edu.kit.informatik.character.secondlevel.MegaSaurus;
import edu.kit.informatik.character.secondlevel.Mushroomlon;
import edu.kit.informatik.character.secondlevel.ShadomBlade;
import edu.kit.informatik.character.secondlevel.Snake;
import edu.kit.informatik.character.secondlevel.Tarantula;
import edu.kit.informatik.character.secondlevel.WildBoar;
import edu.kit.informatik.hero.HeroClass;
import edu.kit.informatik.hero.Mage;
import edu.kit.informatik.hero.Paladin;
import edu.kit.informatik.hero.Warrior;
import edu.kit.informatik.model.Monster;
import edu.kit.informatik.model.ability.Ability;

/**
 * Die Klasse enthält alle Spieldaten
 * 
 * @author uwlhp
 * @version 1.0.0
 */

public final class GameData {

    private static final GameData GAME_DATA = new GameData();

    private static List<HeroClass> heroclass = new ArrayList<>(List.of(new Warrior(),
            new Mage(),
            new Paladin()));

    private final int maxHealth = 50;
    private final int startDice = 4;
    private final int maxDice = 12;
    private final int upgradeDice = 2;
    private final int maxLevel = 2;
    private final int maxStage = 4;
    private final int healPerCard = 10;

    private List<Monster> monsterLevelOne = new ArrayList<>(List.of(new Frog(),
            new Ghost(),
            new Gorgon(),
            new Skeleton(),
            new Spider(),
            new Goblin(),
            new Rat(),
            new Mushroomlin()));

    private List<Monster> monsterLevelTwo = new ArrayList<>(List.of(new Snake(),
            new DarkElf(),
            new ShadomBlade(),
            new Hornet(),
            new Tarantula(),
            new Bear(),
            new Mushroomlon(),
            new WildBoar()));

    private Monster bossLevelOne = new SpiderKing();
    private Monster bossLevelTwo = new MegaSaurus();

    private Map<Integer, Integer> monsterPerStage;

    private List<List<Monster>> allMonster;
    private List<Monster> bossLevel;

    /**
     * Konstruktor
     * 
     */
    private GameData() {
        bossLevel = new ArrayList<>();
        bossLevel.add(bossLevelOne);
        bossLevel.add(bossLevelTwo);

        allMonster = new ArrayList<>();
        allMonster.add(monsterLevelOne);
        allMonster.add(monsterLevelTwo);

        monsterPerStage = new HashMap<>();
        monsterPerStage.put(1, 1);
        monsterPerStage.put(2, 2);
        monsterPerStage.put(3, 2);
        monsterPerStage.put(maxStage, 1);
    }

    /**
     * Gibt das Objekt aus
     * 
     * @return das Objekt der GameData Klasse
     */
    public static GameData getInstance() {
        return GAME_DATA;
    }

    /**
     * Gibt die Liste der Monster Levels aus
     * 
     * @param level das Level
     * @return die Liste der Monster
     */
    public List<Monster> getMonster(int level) {
        if (allMonster.size() >= level) {
            return allMonster.get(level - 1);
        }
        return new ArrayList<>();
    }

    /**
     * Gibt den Endgegner des Levels zurück
     * 
     * @param level das Level
     * @return der Endgegner
     */
    public Monster getBoss(int level) {
        if (bossLevel.size() >= level) {
            return bossLevel.get(level - 1);
        }
        return null;
    }

    /**
     * Anzahl der Monster des Raumes
     * 
     * @param stage der Raum
     * @return die Anzahl der Monster
     */
    public int getMonsterCount(int stage) {
        if (stage <= monsterPerStage.size() && stage >= 1) {
            return monsterPerStage.get(stage);
        }
        return 0;
    }

    /**
     * Getter für die Klassen der Heldinen
     * 
     * @return die Liste der Klassen
     */
    public static List<HeroClass> getHeroclass() {
        return heroclass;
    }

    /**
     * Getter für die maximale Anzahl an Leben von Runa
     * 
     * @return die maximale Anzahl an Leben
     */
    public int getMaxHealth() {
        return maxHealth;
    }

    /**
     * Getter für das maximale Levle
     * 
     * @return das Level
     */
    public int getMaxLevel() {
        return maxLevel;
    }

    /**
     * Getter für den maximalen Raum
     * 
     * @return der Raum
     */
    public int getMaxStage() {
        return maxStage;
    }

    /**
     * Getter für den Wert der pro Karte an heilung gegeben wird
     * 
     * @return der Wert pro Karte
     */
    public int getHealPerCard() {
        return healPerCard;
    }

    /**
     * Getter für den Startwert des Würfels
     * 
     * @return dem Startwert
     */
    public int getStartDice() {
        return startDice;
    }

    /**
     * Getter für die maximale Würfelzahl
     * 
     * @return die maximale Würfelzahl
     */
    public int getMaxDice() {
        return maxDice;
    }

    /**
     * Getter für den der Verbesserung des Würfels
     * 
     * @return der Wert
     */
    public int getUpgradeDice() {
        return upgradeDice;
    }

    /**
     * Gibt eine Liste mit den Fähigkeiten aus für die Level Klasse
     * 
     * @param level         das Level der Fähigkeiten
     * @param removeAbility die Liste mit den Fähigkeiten der Klasse
     * @return List<Ability> die Liste der Fähigkeiten
     */
    public List<Ability> initRunaAbiility(int level, List<Ability> removeAbility) {
        List<Ability> ability;
        ability = new ArrayList<>(List.of(new RunaSlash(level),
                new RunaSwing(level),
                new RunaThrust(level),
                new RunaPierce(level),
                new RunaParry(level),
                new RunaFocus(level),
                new RunaReflect(level),
                new RunaWater(level),
                new RunaIce(level),
                new RunaFire(level),
                new RunaLightning(level)));
        ability.removeAll(removeAbility);
        return ability;
    }

}
