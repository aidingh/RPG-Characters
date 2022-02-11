package com.company;

import Armour.Armours;
import Heroes.Mage;
import Item.Item;
import Weapons.Weapons;

public class Main {

    public static void main(String[] args) {

        String name = "Gini";

        Mage mage = new Mage(name);
        mage.heroLevelUp();

        Weapons weapon = new Weapons();
        weapon.setItemName("Common Wand");
        weapon.setItemLevel(4);
        weapon.setItemSlot(Item.ItemSlots.WEAPON);
        weapon.setWeaponType(Weapons.WeaponItems.WANDS);
        weapon.setDmg(7);
        weapon.setAttackSpeed(1.1);

        Armours armour = new Armours();
        armour.setItemName("Common Cloth Robe Armour");
        armour.setItemLevel(4);
        armour.setItemSlot(Item.ItemSlots.BODY);
        armour.setArmourItems(Armours.ArmourItems.CLOTH);
        //armour.setAttributes()

        boolean didEquipWeapon = mage.equipWeapon(weapon);
        boolean didEquipArmour = mage.equipArmour(armour);

    }


}
