package Heroes;

import Armour.Armours;
import Attributes.BaseAttributes;
import CustomExceptions.InvalidArmourException;
import CustomExceptions.InvalidWeaponException;
import Hero.Hero;
import Item.Item;
import Weapons.Weapons;

import java.util.HashMap;

public class Mage extends Hero {

    public String name;
    public HashMap<ItemSlots, Item> equipments = new HashMap<>();

    public Mage(String name) {
        this.name = name;
        this.setBaseAttributes(new BaseAttributes(1, 1, 8));
        this.setClassType(ClassType.MAGE);
    }

    @Override
    public boolean equipWeapon(Weapons wep) {
        try {
            if (wep.itemLevel >= this.level) {
                throw new InvalidWeaponException("Weapon level is to high! Weapon level: " + wep.itemLevel);
            } else if (wep.getWeaponType() == Weapons.WeaponItems.WANDS || wep.getWeaponType() == Weapons.WeaponItems.STAFFS) {
                this.equipments.put(wep.getItemSlot(), wep);
                return true;
            }
            else{
                throw new InvalidWeaponException(this.getClassType() + " can only equip" + Weapons.WeaponItems.STAFFS + " or " + Weapons.WeaponItems.WANDS);
            }
        } catch (InvalidWeaponException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean equipArmour(Armours armour) {
        try {
            if (armour.itemLevel >= this.level) {
                throw new InvalidArmourException("Armour level is to high! Armour level: " + armour.itemLevel);
            } else if (armour.getArmourItems() == Armours.ArmourItems.CLOTH) {
                this.equipments.put(armour.getItemSlot(), armour);
                return true;
            }
            else{
                throw new InvalidArmourException(this.getClassType() + " can only equip" + Armours.ArmourItems.CLOTH);
            }
        } catch (InvalidArmourException e) {
            e.printStackTrace();
        }
        return false;
    }


    @Override
    public void attributeGain() {
        BaseAttributes attributes = this.getBaseAttributes();
        attributes.str = attributes.str + 1;
        attributes.dex = attributes.dex + 1;
        attributes.intel = attributes.intel + 5;
        this.setBaseAttributes(attributes);
    }

}
