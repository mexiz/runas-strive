package edu.kit.informatik;

import java.util.List;

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
import edu.kit.informatik.hero.Mage;
import edu.kit.informatik.hero.Paladin;
import edu.kit.informatik.hero.Warrior;
import edu.kit.informatik.model.Monster;
import edu.kit.informatik.model.Ability;
import edu.kit.informatik.monster.firstlevel.Spider;

public class Session {

    static List<Ability> runaCards = List.of(new RunaFire(1),
            new RunaIce(1),
            new RunaLightning(1),
            new RunaParry(1),
            new RunaPierce(1),
            new RunaReflect(1),
            new RunaSlash(1),
            new RunaSwing(1),
            new RunaThrust(1),
            new RunaWater(1),
            new RunaFocus(1));

    static List<HeroClass> hero = List.of(new Mage(),
            new Paladin(),
            new Warrior());

    public static void main(String[] args) {
        Runa runa = new Runa(hero.get(0));
        Ability run = new RunaFire(1);
        Monster spider = new Spider();

        run.execute(1, runa, spider);
        
        System.out.println(runa.getHealth());
        System.out.println(spider.getHealth());
    }

}
