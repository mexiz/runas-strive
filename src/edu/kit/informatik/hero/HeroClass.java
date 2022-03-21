package edu.kit.informatik.hero;

import java.util.List;

import edu.kit.informatik.model.Ability;

public interface HeroClass {

    List<Ability> getAbilities();

    String getHeroName();
}
