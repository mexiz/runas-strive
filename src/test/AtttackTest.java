package test;

import org.junit.Test;

import edu.kit.informatik.Runa;
import edu.kit.informatik.abilities.monster.defence.MonsterFocus;
import edu.kit.informatik.abilities.runa.phys.RunaThrust;
import edu.kit.informatik.hero.Mage;
import edu.kit.informatik.model.Monster;
import edu.kit.informatik.model.Ability;
import edu.kit.informatik.monster.firstlevel.Spider;

public class AtttackTest {

    @Test
    public void attackTest() {
        Runa runa = new Runa(new Mage());
        runa.test(new RunaThrust(1));

        Spider m = new Spider();
        m.setAbility(new MonsterFocus(0));

        m.getHealth();
    }

}
