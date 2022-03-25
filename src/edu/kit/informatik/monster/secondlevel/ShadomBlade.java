package edu.kit.informatik.monster.secondlevel;

import java.util.List;

import edu.kit.informatik.abilities.monster.defence.MonsterBlock;
import edu.kit.informatik.abilities.monster.defence.MonsterDeflect;
import edu.kit.informatik.abilities.monster.defence.MonsterFocus;
import edu.kit.informatik.abilities.monster.magic.MonsterLightning;
import edu.kit.informatik.abilities.monster.phys.MonsterClaw;
import edu.kit.informatik.abilities.monster.phys.MonsterScratch;
import edu.kit.informatik.model.Monster;
import edu.kit.informatik.model.MonsterType;
import edu.kit.informatik.model.Ability;

public class ShadomBlade extends Monster {

    private static final MonsterType MONSTER_TYPE = MonsterType.LIGHTNING;
    private static final String name = "Frog";
    private int health = 27;
    private int countAbility = 0;
    private int focusPoint = 0;

    private List<Ability> abilities = List.of(new MonsterScratch(2),
            new MonsterFocus(2),
            new MonsterLightning(2));

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
