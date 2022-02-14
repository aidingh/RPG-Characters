package Tests;
import Heroes.Mage;
import Heroes.Ranger;
import Heroes.Rogue;
import Heroes.Warrior;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Aidin Ghassemloi
 * Test class for testing hero classes.
 * Most tests are focused on the Warrior class as there was provided data.
 */
public class ClassTests {

    /**
     * Test: Initial level is set to 1 when a hero class is created.
     */
    @Test
    public void testInitialHeroLevel() {
        Warrior warrior = new Warrior("Muradin Bronzebeard");
        assertEquals(1, warrior.getLevel());
    }

    /**
     * Test: Hero level will increase when hero levels up.
     */
    @Test
    public void testHeroOnLevelUp() {
        Warrior warrior = new Warrior("Muradin Bronzebeard");
        warrior.heroLevelUp();
        assertEquals(2, warrior.getLevel());
    }

    /**
     * Test: Check if base attributes increase correctly when a warrior class levels up.
     */
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

    /**
     * Test: Check if base attributes increase correctly when a ranger class levels up.
     */
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

    /**
     * Test: Check if base attributes increase correctly when a rogue class levels up.
     */
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

    /**
     * Test: Check if base attributes increase correctly when a mage class levels up.
     */
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
