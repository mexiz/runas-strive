package edu.kit.informatik.hero;

import java.util.List;

import edu.kit.informatik.cards.runa.abilities.defence.RunaReflect;
import edu.kit.informatik.cards.runa.abilities.phys.RunaSlash;
import edu.kit.informatik.cards.runa.model.RunaAbilities;

public class Paladin implements HeroClass {

    private static final String HERO_CLASS_NAME = "Paladin";

    List<RunaAbilities> abilities = List.of(new RunaSlash(1),
            new RunaReflect(1));

    @Override
    public List<RunaAbilities> getAbilities() {
        return abilities;
    }

    @Override
    public String getHeroName() {
        return HERO_CLASS_NAME;
    }

}
