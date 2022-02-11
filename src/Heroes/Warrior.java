package Heroes;

import Armour.Armours;
import Attributes.BaseAttributes;
import CustomExceptions.InvalidArmourException;
import CustomExceptions.InvalidWeaponException;
import Hero.Hero;
import Weapons.Weapons;

public class Warrior extends Hero {

    public String name;

    public Warrior(String name) {
        this.name = name;
        this.setBaseAttributes(new BaseAttributes(5, 2, 1));
        this.setClassType(ClassType.WARRIOR);
    }

    @Override
    public String toString() {
        return "Warrior{" +
                "Level = " + level +
                ", Dps = " + this.getCharacterDps() +
                ", baseAttributes = " + "Strength: "+ baseAttributes.str + " Dexterity: "+ baseAttributes.dex + " Intelligence: "+ baseAttributes.intel +
                ", ClassType=" + classType +
                ", Name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equipWeapon(Weapons wep) {
        try {
            if (wep.itemLevel > this.level) {
                throw new InvalidWeaponException("Weapon level is to high! Weapon level: " + wep.itemLevel);
            } else if (wep.getWeaponType() == Weapons.WeaponItems.AXES || wep.getWeaponType() == Weapons.WeaponItems.HAMMERS || wep.getWeaponType() == Weapons.WeaponItems.SWORDS) {
                this.equipments.put(wep.getItemSlot(), wep);
                return true;
            }
            else{
                throw new InvalidWeaponException(this.getClassType() + " can only equip " + Weapons.WeaponItems.AXES + " , " + Weapons.WeaponItems.HAMMERS + " or " +  Weapons.WeaponItems.SWORDS);
            }
        } catch (InvalidWeaponException e) {
            e.printStackTrace();
            return false;
        }
    }


    @Override
    public boolean equipArmour(Armours armour) {
        try {
            if (armour.itemLevel > this.level) {
                throw new InvalidArmourException("Armour level is to high! Armour level: " + armour.itemLevel);
            } else if (armour.getArmourItems() == Armours.ArmourItems.MAIL || armour.getArmourItems() == Armours.ArmourItems.PLATE) {
                this.equipments.put(armour.getItemSlot(), armour);
                return true;
            }
            else{
                throw new InvalidArmourException(this.getClassType() + " can only equip " + Armours.ArmourItems.MAIL + " or " + Armours.ArmourItems.PLATE);
            }
        } catch (InvalidArmourException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public void attributeGain() {
        BaseAttributes attributes = this.getBaseAttributes();
        attributes.str = attributes.str + 3;
        attributes.dex = attributes.dex + 2;
        attributes.intel = attributes.intel + 1;
        this.setBaseAttributes(attributes);
    }

    @Override
    public double getCharacterDps() {
        this.base = this.getBaseAttributes().str;
        if(equipments.isEmpty()){
            double weaponDps = 1;
            return this.charDps = weaponDps * ( 1 + (base / 100));
        }
        for (ItemSlots key : equipments.keySet()) {
            if(key != ItemSlots.WEAPON){
                System.out.println("Key: " + key + ", Value: " + equipments.get(key).getPrimaryAttributes().str);
                this.totalPrimaryAttributes = this.totalPrimaryAttributes + equipments.get(key).getPrimaryAttributes().str;
            }
            else {
                if(equipments.get(ItemSlots.WEAPON) != null){
                    double weaponDps = equipments.get(ItemSlots.WEAPON).getWeaponDamage();
                    if(this.totalPrimaryAttributes == 0){
                        return this.charDps = weaponDps * ( 1 + (this.base / 100));
                    }
                    return this.charDps = weaponDps * ( 1 + ((this.base + this.totalPrimaryAttributes) / 100));
                }
            }
        }
        return 0;
    }
}
