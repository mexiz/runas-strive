package edu.kit.informatik;

import java.util.List;
import java.util.Scanner;

import javax.xml.namespace.QName;

import edu.kit.informatik.cards.monster.model.Monster;
import edu.kit.informatik.cards.monster.monster.Spider;
import edu.kit.informatik.cards.runa.abilities.RunaFocus;
import edu.kit.informatik.cards.runa.abilities.defence.RunaParry;
import edu.kit.informatik.cards.runa.abilities.defence.RunaReflect;
import edu.kit.informatik.cards.runa.abilities.magic.RunaFire;
import edu.kit.informatik.cards.runa.abilities.magic.RunaIce;
import edu.kit.informatik.cards.runa.abilities.magic.RunaLightning;
import edu.kit.informatik.cards.runa.abilities.magic.RunaWater;
import edu.kit.informatik.cards.runa.abilities.phys.RunaPierce;
import edu.kit.informatik.cards.runa.abilities.phys.RunaSlash;
import edu.kit.informatik.cards.runa.abilities.phys.RunaSwing;
import edu.kit.informatik.cards.runa.abilities.phys.RunaThrust;
import edu.kit.informatik.cards.runa.model.Runa;
import edu.kit.informatik.cards.runa.model.RunaAbilities;
import edu.kit.informatik.hero.HeroClass;
import edu.kit.informatik.hero.Mage;
import edu.kit.informatik.hero.Paladin;
import edu.kit.informatik.hero.Warrior;

public class Session {

    static List<RunaAbilities> runaCards = List.of(new RunaFire(1),
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
        RunaAbilities run = new RunaFire(1);
        Monster spider = new Spider();

        run.attack(1, runa, spider);

        spider.attack(1, false, runa, spider);

        System.out.println(runa.getHealth());
        System.out.println(spider.getHealth());
    }

}
