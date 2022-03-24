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

    public boolean isFinished() {
        return finished;
    }

    public void setFinished(boolean finished) {
        this.finished = finished;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getStage() {
        return stage;
    }

    public void setStage(int stage) {
        this.stage = stage;
    }

    public void setRuna(Runa runa) {
        this.runa = runa;
    }

    public Runa getRuna() {
        return runa;
    }

    public LevelCards getCard() {
        return levelCards;
    }

    public void setCard(LevelCards card) {
        this.levelCards = card;
    }

    public void nextGamePhase() {
        gamePhase.start();
    }

    public void setGamePhase(GamePhase gamePhase) {
        this.gamePhase = gamePhase;
    }

    // CHANGE
    public List<HeroClass> getHeroclass() {
        return heroclass;
    }

    public void setHeroclass(List<HeroClass> heroclass) {
        Game.heroclass = heroclass;
    }
    // -

}
