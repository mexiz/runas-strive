package edu.kit.informatik.hero;

import java.util.ArrayList;
import java.util.List;

import edu.kit.informatik.abilities.runa.defence.RunaParry;
import edu.kit.informatik.abilities.runa.phys.RunaThrust;
import edu.kit.informatik.model.Ability;

public class Warrior extends HeroClass {

    private static final String HERO_CLASS_NAME = "Warrior";

    /**
     * @return Lis t<Ability>
     */
    @Override
    public List<Ability> getAbilities(int level) {
        List<Ability> abilities = new ArrayList<>();
        abilities.add(new RunaThrust(level));
        abilities.add(new RunaParry(level));
        return abilities;
    }

    /**
     * @return String
     */
    @Override
    public String getHeroName() {
        return HERO_CLASS_NAME;
    }

}