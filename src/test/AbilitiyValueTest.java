package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

import edu.kit.informatik.cards.monster.monster.Spider;
import edu.kit.informatik.cards.runa.abilities.defence.RunaParry;
import edu.kit.informatik.cards.runa.abilities.defence.RunaReflect;
import edu.kit.informatik.cards.runa.abilities.magic.RunaFire;
import edu.kit.informatik.cards.runa.abilities.magic.RunaIce;
import edu.kit.informatik.cards.runa.abilities.magic.RunaLightning;
import edu.kit.informatik.cards.runa.abilities.magic.RunaWater;
import edu.kit.informatik.cards.runa.abilities.phys.RunaPierce;
import edu.kit.informatik.cards.runa.abilities.phys.RunaSlash;
import edu.kit.informatik.cards.runa.abilities.phys.RunaSwing;
import edu.kit.informatik.cards.runa.abilities.phys.RunaThrust;
import edu.kit.informatik.cards.runa.model.Runa;
import edu.kit.informatik.hero.Mage;

public class AbilitiyValueTest {

    @ParameterizedTest
    @CsvSource({
            "1, 1, 5",
            "2, 10, 18",
            "3, 20, 32",
    })
    public void slashTest(int level, int dice, int out) {
        RunaSlash obj;
        obj = new RunaSlash(level);
        assertEquals(out, obj.execute(dice, new Runa(new Mage()), new Spider()));
    }

    @ParameterizedTest
    @CsvSource({
            "1, 1, 6",
            "2, 10, 20",
            "3, 20, 35",
    })
    public void swingTest(int level, int dice, int out) {
        RunaSwing obj;
        obj = new RunaSwing(level);
        assertEquals(out, obj.execute(dice, new Runa(new Mage()), new Spider()));
    }

    @ParameterizedTest
    @CsvSource({
            "1, 1, 7",
            "2, 10, 30",
            "3, 20,50",
    })
    public void thrustTest(int level, int dice, int out) {
        RunaThrust obj;
        obj = new RunaThrust(level);
        assertEquals(out, obj.execute(dice, new Runa(new Mage()), new Spider()));
    }

    @ParameterizedTest
    @CsvSource({
        "1,9620,9632",
        "2,14943,14967",
        "3,64069,64105",
        "4,97851,97899",
        "5,66452,66512",
        "6,94872,94944",
        "7,43019,43103",
        "8,60464,60560",
        "9,59036,59144",
        "10,17797,17917",
        "11,97375,97507",
        "12,41097,41241",
        "13,17181,17337",
        "14,22218,22386",
        "15,36281,36461"
    })
    public void pierceTest(int level, int dice, int out) {
        RunaPierce obj;
        obj = new RunaPierce(level);
        assertEquals(out, obj.execute(dice, new Runa(new Mage()), new Spider()));
    }
    @ParameterizedTest
    @CsvFileSource(resources = "/resources/test/Parry.csv")
    public void parryTest(int level, int dice, int out) {
        RunaParry obj;
        obj = new RunaParry(level);
        assertEquals(out, obj.execute(dice, new Runa(new Mage()), new Spider()));
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/resources/test/Reflect.csv")
    public void reflectTest(int level, int dice, int out) {
        RunaReflect obj;

        obj = new RunaReflect(level);
        assertEquals(out, obj.execute(dice, new Runa(new Mage()), new Spider()));
    }
    @ParameterizedTest
    @CsvFileSource(resources = "/resources/test/Water.csv")
    public void waterTest(int level, int dice, int out) {
        RunaWater obj;
        Runa runa = new Runa(new Mage());
        runa.setFocus(dice);
        obj = new RunaWater(level);
        assertEquals(out, obj.execute(dice, runa, new Spider()));
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/resources/test/Ice.csv")
    public void iceTest(int level, int dice, int out) {
        RunaIce obj;
        Runa runa = new Runa(new Mage());
        runa.setFocus(dice);
        obj = new RunaIce(level);
        assertEquals(out, obj.execute(dice, runa, new Spider()));
    }
    @ParameterizedTest
    @CsvFileSource(resources = "/resources/test/Fire.csv")
    public void fireTest(int level, int dice, int out) {
        RunaFire obj;
        Runa runa = new Runa(new Mage());
        runa.setFocus(dice);
        obj = new RunaFire(level);
        assertEquals(out, obj.execute(dice, runa, new Spider()));
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/resources/test/Lightning.csv")
    public void lightningTest(int level, int dice, int out) {
        RunaLightning obj;
        Runa runa = new Runa(new Mage());
        runa.setFocus(dice);
        obj = new RunaLightning(level);
        assertEquals(out, obj.execute(dice, runa, new Spider()));
    }

}
