package edu.kit.informatik;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

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
import edu.kit.informatik.hero.HeroClass;
import edu.kit.informatik.model.Ability;
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
 * Die Klasse kümmert sich um die Monster und die neuen Fähigkeiten des Levels 
 *  
 * @author uwlhp
 * @version 1.0.0
 */

public class Level {

    private List<Monster> monsterLevel;
    private List<Ability> runaAbility;
    private Monster boss;

    public Level(int[] seed, int level, HeroClass heroClass, GameData data) {

        monsterLevel = data.getMonster(level);
        boss = data.getBoss(level);
        runaAbility = initRunaAbiility(level, heroClass.getAbilities(level));

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
        List<Ability> returnList = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            Ability ability = runaAbility.remove(0);
            returnList.add(ability);
        }
        return returnList;
    }

    /**
     * CHANGE LATER 
     * 
     * @param level d
     * @param removeAbility d
     * @return List<Ability> d
     */
    private List<Ability> initRunaAbiility(int level, List<Ability> removeAbility) {
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
