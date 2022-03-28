package edu.kit.informatik;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import edu.kit.informatik.hero.HeroClass;
import edu.kit.informatik.model.Ability;
import edu.kit.informatik.model.Monster;

/**
 * Die Klasse kümmert sich um die Monster und die neuen Fähigkeiten des Levels
 * 
 * @author uwlhp
 * @version 1.0.0
 */

public class Level {

    private List<Monster> monsterLevel;
    private List<Ability> runaAbility;
    private Monster boss;

    /**
     * Konstruktor
     * 
     * @param seed      die Nummer zum Mischen
     * @param level     das Level
     * @param heroClass die Klasse der Heldin
     * @param data      die Spieldaten
     */
    public Level(int[] seed, int level, HeroClass heroClass, GameData data) {

        monsterLevel = data.getMonster(level);
        boss = data.getBoss(level);
        runaAbility = data.initRunaAbiility(level, heroClass.getAbilities(level));

        Collections.shuffle(monsterLevel, new Random(seed[1]));
        Collections.shuffle(runaAbility, new Random(seed[0]));
    }

    /**
     * Holt sich den/die Endgegner des Levels
     * 
     * @return List<Monster> Liste mit den Endgegenern
     */
    public List<Monster> pullBoss() {
        List<Monster> bossList = new ArrayList<>();
        bossList.add(boss);
        return bossList;
    }

    /**
     * Holt sich Monster aus der Liste
     * 
     * @param count die Anzahl der Monster
     * @return List<Monster> Liste mit den Monstern
     */
    public List<Monster> pullMonster(int count) {
        List<Monster> returnList = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            Monster monster = monsterLevel.remove(0);
            returnList.add(monster);
        }
        return returnList;
    }

    /**
     * Holt sich Fähigkeiten aus der Liste
     * 
     * @param count die Anzahl an Fähigkeiten
     * @return List<Ability> die Liste mit Fähigkeiten
     */
    public List<Ability> pullAbility(int count) {
        int outputAbilities = count;
        List<Ability> returnList = new ArrayList<>();
        if (runaAbility.size() <= count) {
            outputAbilities = runaAbility.size();
        }
        for (int i = 0; i < outputAbilities; i++) {
            Ability ability = runaAbility.remove(0);
            returnList.add(ability);
        }
        return returnList;
    }

}
