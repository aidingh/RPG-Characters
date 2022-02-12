package Tests;
import Attributes.BaseAttributes;
import Heroes.Ranger;
import Heroes.Warrior;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ClassTests {

    @Test
    public void testInitialHeroLevel() {
        Warrior warrior = new Warrior("Ulrik");
        assertEquals(1, warrior.getLevel());
    }

    @Test
    public void testHeroOnLevelUp() {
        Warrior warrior = new Warrior("Ulrik");
        warrior.heroLevelUp();
        assertEquals(2, warrior.getLevel());
    }

    @Test
    public void testWarriorHeroBaseAttributeGain() {
        Warrior warrior = new Warrior("Ulrik");
        warrior.heroLevelUp();

        assertAll(
        () -> assertEquals(8, warrior.getBaseAttributes().str),
        () -> assertEquals(4, warrior.getBaseAttributes().dex),
        () -> assertEquals(2, warrior.getBaseAttributes().intel)
        );
    }

    @Test
    public void testRangerHeroBaseAttributeGain() {
        Ranger ranger = new Ranger("Sylvanas");
        ranger.heroLevelUp();

        assertAll(
                () -> assertEquals(8, ranger.getBaseAttributes().str),
                () -> assertEquals(4, ranger.getBaseAttributes().dex),
                () -> assertEquals(2, ranger.getBaseAttributes().intel)
        );
    }


}
