package edu.kit.informatik;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import edu.kit.informatik.hero.HeroClass;
import edu.kit.informatik.hero.Mage;
import edu.kit.informatik.hero.Paladin;
import edu.kit.informatik.hero.Warrior;
import edu.kit.informatik.model.GamePhase;
import edu.kit.informatik.phase.StartPhase;
import edu.kit.informatik.ui.UserInterface;

public class Game {

    private static List<HeroClass> heroclass = new ArrayList<>(List.of(new Warrior(),
            new Mage(),
            new Paladin()));

    public Map<Integer, Integer> monsterPerStage = new HashMap<>();

    private GamePhase gamePhase;

    private Runa runa;

    private LevelCards levelCards;

    private int level;
    private int stage;

    private boolean finished;

    public Game() {
        monsterPerStage.put(1, 1);
        monsterPerStage.put(2, 2);
        monsterPerStage.put(3, 2);
        monsterPerStage.put(4, 1);

        this.gamePhase = new StartPhase(this, new UserInterface());
        this.level = 1;
        this.stage = 0;
        finished = false;
    }

    
    /** 
     * @return boolean
     */
    public boolean isFinished() {
        return finished;
    }

    
    /** 
     * @param finished
     */
    public void setFinished(boolean finished) {
        this.finished = finished;
    }

    
    /** 
     * @return int
     */
    public int getLevel() {
        return level;
    }

    
    /** 
     * @param level
     */
    public void setLevel(int level) {
        this.level = level;
    }

    
    /** 
     * @return int
     */
    public int getStage() {
        return stage;
    }

    
    /** 
     * @param stage
     */
    public void setStage(int stage) {
        this.stage = stage;
    }

    
    /** 
     * @param runa
     */
    public void setRuna(Runa runa) {
        this.runa = runa;
    }

    
    /** 
     * @return Runa
     */
    public Runa getRuna() {
        return runa;
    }

    
    /** 
     * @return LevelCards
     */
    public LevelCards getCard() {
        return levelCards;
    }

    
    /** 
     * @param card
     */
    public void setCard(LevelCards card) {
        this.levelCards = card;
    }

    public void nextGamePhase() {
        gamePhase.start();
    }

    
    /** 
     * @param gamePhase
     */
    public void setGamePhase(GamePhase gamePhase) {
        this.gamePhase = gamePhase;
    }

    
    /** 
     * @return List<HeroClass>
     */
    // CHANGE
    public List<HeroClass> getHeroclass() {
        return heroclass;
    }

    
    /** 
     * @param heroclass
     */
    public void setHeroclass(List<HeroClass> heroclass) {
        Game.heroclass = heroclass;
    }
    // -

}
