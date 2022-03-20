package edu.kit.informatik.hero;

import java.util.List;

import edu.kit.informatik.cards.runa.model.RunaAbilities;

public interface HeroClass {

    List<RunaAbilities> getAbilities();

    String getHeroName();
}
