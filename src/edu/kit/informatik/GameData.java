package edu.kit.informatik;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import edu.kit.informatik.hero.HeroClass;
import edu.kit.informatik.hero.Mage;
import edu.kit.informatik.hero.Paladin;
import edu.kit.informatik.hero.Warrior;
import edu.kit.informatik.model.Monster;
import edu.kit.informatik.monster.firstlevel.Frog;
import edu.kit.informatik.monster.firstlevel.Ghost;
import edu.kit.informatik.monster.firstlevel.Goblin;
import edu.kit.informatik.monster.firstlevel.Gorgon;
import edu.kit.informatik.monster.firstlevel.Mushroomlin;
import edu.kit.informatik.monster.firstlevel.Rat;
import edu.kit.informatik.monster.firstlevel.Skeleton;
import edu.kit.informatik.monster.firstlevel.Spider;
import edu.kit.informatik.monster.firstlevel.SpiderKing;
import edu.kit.informatik.monster.secondlevel.Bear;
import edu.kit.informatik.monster.secondlevel.DarkElf;
import edu.kit.informatik.monster.secondlevel.Hornet;
import edu.kit.informatik.monster.secondlevel.MegaSaurus;
import edu.kit.informatik.monster.secondlevel.Mushroomlon;
import edu.kit.informatik.monster.secondlevel.ShadomBlade;
import edu.kit.informatik.monster.secondlevel.Snake;
import edu.kit.informatik.monster.secondlevel.Tarantula;
import edu.kit.informatik.monster.secondlevel.WildBoar;

/**
 * Die Klasse enthält alle Spieldaten
 * 
 * @author uwlhp
 * @version 1.0.0
 */

public final class GameData {
    
    private static final GameData GAME_DATA = new GameData();
    private static final int MAX_HEALTH = 50;
    private static final int MAX_LEVEL = 2;
    private static final int MAX_STAGE = 4;
    private static final int HEAL_PER_CARD = 10;
    
    private static List<HeroClass> heroclass = new ArrayList<>(List.of(new Warrior(),
            new Mage(),
            new Paladin()));

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
        monsterPerStage.put(4, 1);
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
        if (stage <= monsterPerStage.size()) {
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
    public static int getMaxHealth() {
        return MAX_HEALTH;
    }

    /**
     * Getter für das maximale Levle
     * 
     * @return das Level
     */
    public static int getMaxLevel() {
        return MAX_LEVEL;
    }

    /**
     * Getter für den maximalen Raum 
     *  
     * @return der Raum
     */
    public static int getMaxStage() {
        return MAX_STAGE;
    }

    /**
     * Getter für den Wert der pro Karte an heilung gegeben wird
     * 
     * @return der Wert pro Karte
     */
    public static int getHealPerCard() {
        return HEAL_PER_CARD;
    }

    

    
}
