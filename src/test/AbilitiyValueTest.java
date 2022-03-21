package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import edu.kit.informatik.Runa;
import edu.kit.informatik.abilities.runa.defence.RunaParry;
import edu.kit.informatik.abilities.runa.defence.RunaReflect;
import edu.kit.informatik.abilities.runa.magic.RunaFire;
import edu.kit.informatik.abilities.runa.magic.RunaIce;
import edu.kit.informatik.abilities.runa.magic.RunaLightning;
import edu.kit.informatik.abilities.runa.magic.RunaWater;
import edu.kit.informatik.abilities.runa.phys.RunaPierce;
import edu.kit.informatik.abilities.runa.phys.RunaSlash;
import edu.kit.informatik.abilities.runa.phys.RunaSwing;
import edu.kit.informatik.abilities.runa.phys.RunaThrust;
import edu.kit.informatik.hero.Mage;
import edu.kit.informatik.monster.firstlevel.Spider;

public class AbilitiyValueTest {

    @ParameterizedTest
    @CsvFileSource(resources = "/resources/test/Slash.csv")
    public void slashTest(int level, int dice, int out) {
        RunaSlash obj;
        obj = new RunaSlash(level);
        assertEquals(out, obj.execute(dice, new Runa(new Mage()), new Spider()));
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/resources/test/Swing.csv")
    public void swingTest(int level, int dice, int out) {
        RunaSwing obj;
        obj = new RunaSwing(level);
        assertEquals(out, obj.execute(dice, new Runa(new Mage()), new Spider()));
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/resources/test/Thrust.csv")
    public void thrustTest(int level, int dice, int out) {
        RunaThrust obj;
        obj = new RunaThrust(level);
        assertEquals(out, obj.execute(dice, new Runa(new Mage()), new Spider()));
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/resources/test/Pierce.csv")
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
