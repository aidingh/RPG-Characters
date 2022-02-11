package com.company;
import Armour.Armours;
import Attributes.PrimaryAttributes;
import Heroes.Warrior;
import Item.Item;
import Weapons.Weapons;

public class Main {

    public static void main(String[] args) {

        String name = "Ulrik";

        Warrior warrior = new Warrior(name);

        Weapons axe = new Weapons();
        axe.setItemName("Common Axe");
        axe.setItemLevel(1);
        axe.setItemSlot(Item.ItemSlots.WEAPON);
        axe.setWeaponType(Weapons.WeaponItems.AXES);
        axe.setDmg(7);
        axe.setAttackSpeed(1.1);

        Weapons bow = new Weapons();
        bow.setItemName("Common Bow");
        bow.setItemLevel(1);
        bow.setItemSlot(Item.ItemSlots.WEAPON);
        bow.setWeaponType(Weapons.WeaponItems.BOWS);
        bow.setDmg(7);
        bow.setAttackSpeed(1.1);

        Armours plateBodyArmour = new Armours();
        plateBodyArmour.setItemName("Common Plate Body Armour");
        plateBodyArmour.setItemLevel(1);
        plateBodyArmour.setItemSlot(Item.ItemSlots.BODY);
        plateBodyArmour.setArmourItems(Armours.ArmourItems.PLATE);
        plateBodyArmour.setPrimaryAttributes(new PrimaryAttributes(1,0,0));

        boolean didEquipWeapon = warrior.equipWeapon(axe);
        //boolean didEquipWeapon = warrior.equipWeapon(bow);
        boolean didEquipBodyArmour = warrior.equipArmour(plateBodyArmour);

        System.out.println(warrior.toString());

        warrior.heroLevelUp();

        Armours plateHeadArmour = new Armours();
        plateHeadArmour.setItemName("Common Plate Head Armour");
        plateHeadArmour.setItemLevel(1);
        plateHeadArmour.setItemSlot(Item.ItemSlots.HEAD);
        plateHeadArmour.setArmourItems(Armours.ArmourItems.PLATE);
        plateHeadArmour.setPrimaryAttributes(new PrimaryAttributes(2,0,0));

        boolean didEquipHeadArmour = warrior.equipArmour(plateHeadArmour);
        warrior.heroLevelUp();

        System.out.println(warrior.toString());

    }


}
