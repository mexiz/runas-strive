package edu.kit.informatik.hero;

import java.util.List;

import edu.kit.informatik.cards.runa.abilities.defence.RunaParry;
import edu.kit.informatik.cards.runa.abilities.phys.RunaThrust;
import edu.kit.informatik.cards.runa.model.RunaAbilities;

public class Warrior implements HeroClass {

    private static final String HERO_CLASS_NAME = "Warrior";

    List<RunaAbilities> abilities = List.of(new RunaThrust(1),
            new RunaParry(1));

    @Override
    public List<RunaAbilities> getAbilities() {
        return abilities;
    }

    @Override
    public String getHeroName() {
        return HERO_CLASS_NAME;
    }

}