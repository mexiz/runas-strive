package edu.kit.informatik.hero;

import java.util.List;

import edu.kit.informatik.abilities.runa.defence.RunaParry;
import edu.kit.informatik.abilities.runa.phys.RunaThrust;
import edu.kit.informatik.model.Ability;

public class Warrior implements HeroClass {

    private static final String HERO_CLASS_NAME = "Warrior";

    List<Ability> abilities = List.of(new RunaThrust(1),
            new RunaParry(1));

    @Override
    public List<Ability> getAbilities() {
        return abilities;
    }

    @Override
    public String getHeroName() {
        return HERO_CLASS_NAME;
    }

}