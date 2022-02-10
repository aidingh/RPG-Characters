package com.company;

import Heroes.Mage;
import Item.Item;
import Weapons.Weapons;

public class Main {

    public static void main(String[] args) {

        String name = "Gini";

        Mage mage = new Mage(name);
        mage.heroLevelUp();
        System.out.println(mage.toString());

        Weapons weapon = new Weapons();
        weapon.setItemName("Common Wand");
        weapon.setItemLevel(4);
        weapon.setItemSlot(Item.ItemSlots.WEAPON);
        weapon.setWeaponType(Weapons.WeaponItems.WANDS);
        weapon.setDmg(7);
        weapon.setAttackSpeed(1.1);

        mage.setEquipments(weapon);

    }


}
