package edu.kit.informatik.hero;

import java.util.List;

import edu.kit.informatik.cards.runa.abilities.defence.RunaFocus;
import edu.kit.informatik.cards.runa.abilities.magic.RunaWater;
import edu.kit.informatik.cards.runa.model.RunaAbilities;

public class Mage implements HeroClass {

    private static final String HERO_CLASS_NAME = "Mage";

    List<RunaAbilities> abilities = List.of(new RunaFocus(1),
            new RunaWater(1));

    @Override
    public List<RunaAbilities> getAbilities() {
        return abilities;
    }

    @Override
    public String getHeroName() {
        return HERO_CLASS_NAME;
    }

}
