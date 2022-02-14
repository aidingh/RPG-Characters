package Tests;
import Armour.Armours;
import Attributes.PrimaryAttributes;
import CustomExceptions.InvalidArmourException;
import CustomExceptions.InvalidWeaponException;
import Heroes.Warrior;
import Weapons.Weapons;
import org.junit.jupiter.api.Test;
import Item.Item;
import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Aidin Ghassemloi
 * Test class for testing hero equipments. That includes armour and weapons.
 * Most tests are focused on the Warrior class as there was provided data.
 */
public class ItemTests {

    /**
     * Test: If a class tries to equip a weapon higher than its current hero level. Then InvalidWeaponException must be thrown.
     */
    @Test
    public void testInvalidWeaponException(){
        Warrior warrior = new Warrior("Ulrik");

        Weapons axe = new Weapons();
        axe.setItemName("Common Axe");
        axe.setItemLevel(2);
        axe.setItemSlot(Item.ItemSlots.WEAPON);
        axe.setWeaponType(Weapons.WeaponItems.AXES);
        axe.setDmg(7);
        axe.setAttackSpeed(1.1);

        assertThrowsExactly(InvalidWeaponException.class, () -> warrior.equipWeapon(axe));
    }

    /**
     * Test: If a class tries to equip an armour higher than its current hero level. Then InvalidArmourException must be thrown.
     */
    @Test
    public void testInvalidArmourException(){
        Warrior warrior = new Warrior("Ulrik");

        Armours plateBodyArmour = new Armours();
        plateBodyArmour.setItemName("Common Plate Body Armour");
        plateBodyArmour.setItemLevel(2);
        plateBodyArmour.setItemSlot(Item.ItemSlots.BODY);
        plateBodyArmour.setArmourType(Armours.ArmourItems.PLATE);
        plateBodyArmour.setPrimaryAttributes(new PrimaryAttributes(1,0,0));

        assertThrowsExactly(InvalidArmourException.class, () -> warrior.equipArmour(plateBodyArmour));
    }

    /**
     * Test: If a class tries to equip a wrong armour type. Then InvalidArmourException must be thrown.
     */
    @Test
    public void testInvalidArmourEquipmentException(){
        Warrior warrior = new Warrior("Ulrik");

        Armours clothHeadArmour = new Armours();
        clothHeadArmour.setItemName("Common Cloth Head Armour");
        clothHeadArmour.setItemLevel(1);
        clothHeadArmour.setItemSlot(Item.ItemSlots.HEAD);
        clothHeadArmour.setArmourType(Armours.ArmourItems.CLOTH);
        clothHeadArmour.setPrimaryAttributes(new PrimaryAttributes(2,0,0));

        assertThrowsExactly(InvalidArmourException.class, () -> warrior.equipArmour(clothHeadArmour));
    }

    /**
     * Test: If a class tries to equip a wrong weapon type. Then InvalidWeaponException must be thrown.
     */
    @Test
    public void testValidWeaponEquip() throws InvalidWeaponException {
        Warrior warrior = new Warrior("Ulrik");

        Weapons sword = new Weapons();
        sword.setItemName("Common Sword");
        sword.setItemLevel(1);
        sword.setItemSlot(Item.ItemSlots.WEAPON);
        sword.setWeaponType(Weapons.WeaponItems.AXES);
        sword.setDmg(7);
        sword.setAttackSpeed(1.1);

        assertTrue(warrior.equipWeapon(sword));
    }

    /**
     * Test: If a class tries to equip a correct weapon type. Then a boolean = true will be returned to confirm the equipment.
     */
    @Test
    public void testValidArmourEquip() throws InvalidArmourException {
        Warrior warrior = new Warrior("Ulrik");

        Armours plateBodyArmour = new Armours();
        plateBodyArmour.setItemName("Common Plate Body Armour");
        plateBodyArmour.setItemLevel(1);
        plateBodyArmour.setItemSlot(Item.ItemSlots.BODY);
        plateBodyArmour.setArmourType(Armours.ArmourItems.PLATE);
        plateBodyArmour.setPrimaryAttributes(new PrimaryAttributes(1,0,0));

        assertTrue(warrior.equipArmour(plateBodyArmour));
    }

    /**
     * Test: The initial dps output of a base hero class at level 1. With no weapon or items equipped.
     */
    @Test
    public void testHeroDpsInit() throws InvalidArmourException {
        Warrior warrior = new Warrior("Ulrik");
        double expected = 1.05;
        assertEquals(expected, warrior.getCharacterDps());
    }

    /**
     * Test: The initial dps output of a base hero class at level 1. With weapon equipped.
     */
    @Test
    public void testHeroDpsWithWeapon() throws InvalidWeaponException {
        Warrior warrior = new Warrior("Ulrik");

        Weapons axe = new Weapons();
        axe.setItemName("Common Axe");
        axe.setItemLevel(1);
        axe.setItemSlot(Item.ItemSlots.WEAPON);
        axe.setWeaponType(Weapons.WeaponItems.AXES);
        axe.setDmg(7);
        axe.setAttackSpeed(1.1);

        boolean didEquip = warrior.equipWeapon(axe);
        double expected = 8.085;
        assertEquals(expected, warrior.getCharacterDps());
    }

    /**
     * Test: The initial dps output of a base hero class at level 1. With items and weapons equipped.
     */
    @Test
    public void testHeroDpsWithWeaponAndArmour() throws InvalidWeaponException, InvalidArmourException {
        Warrior warrior = new Warrior("Ulrik");

        Weapons axe = new Weapons(1.1, 7.0, 1, "Common Axe", Weapons.WeaponItems.AXES, Item.ItemSlots.WEAPON);
        Armours plateBodyArmour = new Armours("Common Plate Body Armour", 1, Armours.ArmourItems.PLATE, Item.ItemSlots.BODY, new PrimaryAttributes(1,0,0));

        boolean didEquipWeapon = warrior.equipWeapon(axe);
        boolean didEquipArmour = warrior.equipArmour(plateBodyArmour);

        double expected = 8.162;

        assertEquals(expected, warrior.getCharacterDps());
    }

    /**
     * Test: The initial dps output of a base hero class at level 2. With weapons equipped.
     */
    @Test
    public void testHeroDpsWithWeaponAtHeroLevelUp() throws InvalidWeaponException {
        Warrior warrior = new Warrior("Ulrik");
        warrior.heroLevelUp();

        Weapons axe = new Weapons(1.1, 7.0, 1, "Common Axe", Weapons.WeaponItems.AXES, Item.ItemSlots.WEAPON);

        boolean didEquipWeapon = warrior.equipWeapon(axe);
        double expected = 8.316000000000003;

        assertEquals(expected, warrior.getCharacterDps());
    }

    /**
     * Test: The initial dps output of a base hero class at level 2. With items and weapons equipped.
     */
    @Test
    public void testHeroDpsWithWeaponAndArmourAtHeroLevelUp() throws InvalidWeaponException, InvalidArmourException {

        Warrior warrior = new Warrior("Ulrik");
        warrior.heroLevelUp();

        Weapons axe = new Weapons(1.1, 7.0, 1, "Common Axe", Weapons.WeaponItems.AXES, Item.ItemSlots.WEAPON);
        Armours plateBodyArmour = new Armours("Common Plate Body Armour", 1, Armours.ArmourItems.PLATE, Item.ItemSlots.BODY, new PrimaryAttributes(1,0,0));

        boolean didEquipWeapon = warrior.equipWeapon(axe);
        boolean didEquipArmour = warrior.equipArmour(plateBodyArmour);

        double expected = 8.393000000000002;

        assertEquals(expected, warrior.getCharacterDps());
    }
}
