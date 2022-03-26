package edu.kit.informatik.hero;

import java.util.ArrayList;
import java.util.List;

import edu.kit.informatik.abilities.runa.defence.RunaReflect;
import edu.kit.informatik.abilities.runa.phys.RunaSlash;
import edu.kit.informatik.model.Ability;

public class Paladin extends HeroClass {

    private static final String HERO_CLASS_NAME = "Paladin";
    
    @Override
    public List<Ability> getAbilities(int level) {
        List<Ability> abilities = new ArrayList<>();
        abilities.add(new RunaSlash(level));
        abilities.add(new RunaReflect(level));
        return abilities;
    }

    @Override
    public String getHeroName() {
        return HERO_CLASS_NAME;
    }

}
