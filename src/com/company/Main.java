package com.company;
import Armour.Armours;
import Attributes.PrimaryAttributes;
import CustomExceptions.InvalidArmourException;
import CustomExceptions.InvalidWeaponException;
import Heroes.Warrior;
import Item.Item;
import Weapons.Weapons;

/**
 * @author Aidin Ghassemloi
 * Main class for creating heros and items.
 * Below are some examples on how instances are created and usage.
 */

public class Main {

    public static void main(String[] args) throws InvalidArmourException, InvalidWeaponException {

        //Creates an instance of a warrior hero class.
        Warrior warrior = new Warrior("Muradin Bronzebeard");

        //Print hero attributes. Such as dps, base attributes and more.
        System.out.println(warrior.toString());

        //Creates an instance of weapon. And set the attributes. There is also an option to create an object by the contructor aswell.
        Weapons axe = new Weapons();
        axe.setItemName("Common Axe");
        axe.setItemLevel(1);
        axe.setItemSlot(Item.ItemSlots.WEAPON);
        axe.setWeaponType(Weapons.WeaponItems.AXES);
        axe.setDmg(7);
        axe.setAttackSpeed(1.1);

        //Equip the Weapons instance and print the new attributes. As the dps will change depending on weapon.
        boolean didEquipWeapon = warrior.equipWeapon(axe);
        System.out.println(warrior.toString());

        //Creates an instance of armour. And set the attributes. There is also an option to create an object by the contructor aswell.
        Armours plateBodyArmour = new Armours();
        plateBodyArmour.setItemName("Common Plate Body Armour");
        plateBodyArmour.setItemLevel(1);
        plateBodyArmour.setItemSlot(Item.ItemSlots.BODY);
        plateBodyArmour.setArmourType(Armours.ArmourItems.PLATE);
        plateBodyArmour.setPrimaryAttributes(new PrimaryAttributes(1,0,0));

        //Equip the Armours instance and print the new attributes. As the dps will change depending on weapon and armour..
        boolean didEquipArmour = warrior.equipArmour(plateBodyArmour);
        System.out.println(warrior.toString());
    }
}
