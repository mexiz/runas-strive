package edu.kit.informatik.monster.firstlevel;

import java.util.List;

import edu.kit.informatik.abilities.monster.defence.MonsterFocus;
import edu.kit.informatik.abilities.monster.magic.MonsterWater;
import edu.kit.informatik.model.Monster;
import edu.kit.informatik.model.MonsterType;
import edu.kit.informatik.model.Ability;

public class Frog extends Monster {

    private static final MonsterType MONSTER_TYPE = MonsterType.WATER;

    private static final String name = "Frog";

    private int health = 16;
    private int countAbility = 0;
    private int focusPoint = 0;

    private List<Ability> abilities = List.of(new MonsterFocus(1),
            new MonsterWater(1));

    private Ability currentAbility = abilities.get(countAbility);

    
    /** 
     * @return MonsterType
     */
    @Override
    public MonsterType getMonsterType() {
        return MONSTER_TYPE;
    }

    
    /** 
     * @return int
     */
    @Override
    public int getFocusPoints() {
        return focusPoint;
    }

    
    /** 
     * @param focusPoint
     */
    @Override
    public void setFocusPoints(int focusPoint) {
        this.focusPoint = focusPoint;
    }

    
    /** 
     * @return int
     */
    @Override
    public int getHealth() {
        return health;
    }

    
    /** 
     * @return Ability
     */
    @Override
    public Ability getCurrentAbility() {
        return currentAbility;
    }

    
    /** 
     * @param abilities
     */
    @Override
    public void setCurrentAbility(Ability abilities) {
        this.currentAbility = abilities;

    }

    
    /** 
     * @param health
     */
    @Override
    public void setHealth(int health) {
        this.health = health;
    }

    @Override
    public void changeAbility() {
        countAbility++;
        if (countAbility > abilities.size() - 1) {
            countAbility = 0;
        }
        super.setPrevAbility(currentAbility);
        currentAbility = abilities.get(countAbility);
    }

    
    /** 
     * @return String
     */
    @Override
    public String getName() {
        return name;
    }
}
