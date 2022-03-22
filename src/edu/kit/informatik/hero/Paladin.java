package edu.kit.informatik.hero;

import java.util.List;

import edu.kit.informatik.abilities.runa.defence.RunaReflect;
import edu.kit.informatik.abilities.runa.phys.RunaSlash;
import edu.kit.informatik.model.Ability;

public class Paladin extends HeroClass {

    private static final String HERO_CLASS_NAME = "Paladin";

    List<Ability> abilities = List.of(new RunaSlash(1),
            new RunaReflect(1));

    @Override
    public List<Ability> getAbilities() {
        return abilities;
    }

    @Override
    public String getHeroName() {
        return HERO_CLASS_NAME;
    }

}
