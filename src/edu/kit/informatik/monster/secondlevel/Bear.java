package edu.kit.informatik.monster.secondlevel;

import java.util.List;

import edu.kit.informatik.abilities.monster.defence.MonsterBlock;
import edu.kit.informatik.abilities.monster.defence.MonsterDeflect;
import edu.kit.informatik.abilities.monster.phys.MonsterClaw;
import edu.kit.informatik.abilities.monster.phys.MonsterScratch;
import edu.kit.informatik.model.Monster;
import edu.kit.informatik.model.MonsterType;
import edu.kit.informatik.model.Ability;

public class Bear extends Monster {

    private static final MonsterType MONSTER_TYPE = MonsterType.NONE;
    private static final String name = "Bear";
    private int health = 40;
    private int countAbility = 0;
    private int focusPoint = 0;

    private List<Ability> abilities = List.of(new MonsterClaw(2),
            new MonsterDeflect(2),
            new MonsterBlock(2));

    private Ability currentAbility = abilities.get(countAbility);
    
    /** 
     * @return String
     */
    @Override
    public String getName() {
        return name;
    }
    
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
     * @param health
     */
    @Override
    public void setHealth(int health) {
        this.health = health;
    }

    
    /** 
     * @param abilities
     */
    @Override
    public void setCurrentAbility(Ability abilities) {
        this.currentAbility = abilities;

    }

    @Override
    public void changeAbility() {
        countAbility++;
        if (countAbility > abilities.size() - 1) {
            countAbility = 0;
        }
        currentAbility = abilities.get(countAbility);
    }
}