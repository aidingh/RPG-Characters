package com.company;
import Armour.Armours;
import Attributes.PrimaryAttributes;
import CustomExceptions.InvalidArmourException;
import CustomExceptions.InvalidWeaponException;
import Heroes.Warrior;
import Item.Item;
import Weapons.Weapons;

public class Main {

    public static void main(String[] args) throws InvalidArmourException, InvalidWeaponException {

        Warrior warrior = new Warrior("Muradin Bronzebeard");
        System.out.println(warrior.toString());

        Weapons axe = new Weapons();
        axe.setItemName("Common Axe");
        axe.setItemLevel(1);
        axe.setItemSlot(Item.ItemSlots.WEAPON);
        axe.setWeaponType(Weapons.WeaponItems.AXES);
        axe.setDmg(7);
        axe.setAttackSpeed(1.1);

        boolean didEquipWeapon = warrior.equipWeapon(axe);
        System.out.println(warrior.toString());

        Armours plateBodyArmour = new Armours();
        plateBodyArmour.setItemName("Common Plate Body Armour");
        plateBodyArmour.setItemLevel(1);
        plateBodyArmour.setItemSlot(Item.ItemSlots.BODY);
        plateBodyArmour.setArmourType(Armours.ArmourItems.PLATE);
        plateBodyArmour.setPrimaryAttributes(new PrimaryAttributes(1,0,0));


        boolean didEquipArmour = warrior.equipArmour(plateBodyArmour);
        System.out.println(warrior.toString());

    }


}
