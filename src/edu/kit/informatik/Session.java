package edu.kit.informatik;

import java.util.ArrayList;
import java.util.List;

import edu.kit.informatik.abilities.EmptyAbility;
import edu.kit.informatik.abilities.monster.defence.MonsterBlock;
import edu.kit.informatik.abilities.monster.defence.MonsterDeflect;
import edu.kit.informatik.abilities.monster.defence.MonsterFocus;
import edu.kit.informatik.abilities.monster.magic.MonsterWater;
import edu.kit.informatik.abilities.runa.defence.RunaFocus;
import edu.kit.informatik.abilities.runa.defence.RunaReflect;
import edu.kit.informatik.abilities.runa.magic.RunaFire;
import edu.kit.informatik.abilities.runa.phys.RunaSlash;
import edu.kit.informatik.hero.Warrior;
import edu.kit.informatik.monster.firstlevel.Rat;
import edu.kit.informatik.monster.firstlevel.Spider;

public class Session {

    public static void main(String[] args) {
         Game game = new Game();
         game.nextGamePhase();
    }
}