package Tests;
import Heroes.Mage;
import Heroes.Ranger;
import Heroes.Rogue;
import Heroes.Warrior;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ClassTests {

    @Test
    public void testInitialHeroLevel() {
        Warrior warrior = new Warrior("Muradin Bronzebeard");
        assertEquals(1, warrior.getLevel());
    }

    @Test
    public void testHeroOnLevelUp() {
        Warrior warrior = new Warrior("Muradin Bronzebeard");
        warrior.heroLevelUp();
        assertEquals(2, warrior.getLevel());
    }

    @Test
    public void testWarriorHeroBaseAttributeGain() {
        Warrior warrior = new Warrior("Muradin Bronzebeard");
        warrior.heroLevelUp();

        assertAll(
        () -> assertEquals(8, warrior.getBaseAttributes().str),
        () -> assertEquals(4, warrior.getBaseAttributes().dex),
        () -> assertEquals(2, warrior.getBaseAttributes().intel)
        );
    }

    @Test
    public void testRangerHeroBaseAttributeGain() {
        Ranger ranger = new Ranger("Sylvanas Windrunner");
        ranger.heroLevelUp();

        assertAll(
                () -> assertEquals(2, ranger.getBaseAttributes().str),
                () -> assertEquals(12, ranger.getBaseAttributes().dex),
                () -> assertEquals(2, ranger.getBaseAttributes().intel)
        );
    }

    @Test
    public void testRogueHeroBaseAttributeGain() {
        Rogue rogue = new Rogue("Edwin VanCleef");
        rogue.heroLevelUp();

        assertAll(
                () -> assertEquals(3, rogue.getBaseAttributes().str),
                () -> assertEquals(10, rogue.getBaseAttributes().dex),
                () -> assertEquals(2, rogue.getBaseAttributes().intel)
        );
    }

    @Test
    public void testMageHeroBaseAttributeGain() {
        Mage mage = new Mage("Jaina Proudmoore");
        mage.heroLevelUp();

        assertAll(
                () -> assertEquals(2, mage.getBaseAttributes().str),
                () -> assertEquals(2, mage.getBaseAttributes().dex),
                () -> assertEquals(13, mage.getBaseAttributes().intel)
        );
    }

}
