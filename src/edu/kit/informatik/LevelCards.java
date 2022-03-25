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

public class LevelCards {

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

    private List<Monster> bossMonster = new ArrayList<>(List.of(new SpiderKing(), new MegaSaurus()));
    private List<Monster> monsterLevel;
    private Monster boss;
    private List<Ability> runaAbility;

    public LevelCards(int[] seed, int level, HeroClass heroclass) {
        List<List<Monster>> current = new ArrayList<>();
        current.add(monsterLevelOne);
        current.add(monsterLevelTwo);

        monsterLevel = current.get(level - 1);
        boss = bossMonster.get(level - 1);
        runaAbility = initRunaAbiility(level, heroclass.getAbilities());

        Collections.shuffle(monsterLevel, new Random(seed[1]));
        Collections.shuffle(runaAbility, new Random(seed[0]));
    }

    /**
     * @return List<Monster>
     */
    public List<Monster> pullBoss() {
        List<Monster> bossList = new ArrayList<>();
        bossList.add(boss);
        return bossList;
    }

    /**
     * @param count
     * @return List<Monster>
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
     * @param count
     * @return List<Ability>
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
     * @param level
     * @param removeAbility
     * @return List<Ability>
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
                new RunaLightning(level)
        ));
        ability.removeAll(removeAbility);
        return ability;
    }

}
