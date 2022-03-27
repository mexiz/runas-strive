package edu.kit.informatik.hero;

import java.util.List;

import edu.kit.informatik.model.Ability;

/**
 * Die Vorlage für die Klassen des Heldens
 * 
 * @author uwlhp
 * @version 1.0.0
 */
public abstract class HeroClass {

    /**
     * Gibt die Fähigkeiten der Klasse aus
     * 
     * @param level das Level
     * @return eine Liste mit den Fähigkeiten
     */
    public abstract List<Ability> getAbilities(int level);

    /**
     * Gibt den Namen der Klasse des Heldens aus
     * 
     * @return den Namen
     */
    public abstract String getHeroName();
}
