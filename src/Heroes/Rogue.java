package Heroes;

import Armour.Armours;
import Attributes.BaseAttributes;
import CustomExceptions.InvalidArmourException;
import CustomExceptions.InvalidWeaponException;
import Hero.Hero;
import Weapons.Weapons;

public class Rogue extends Hero {

    public String name;

    public Rogue(String name) {
        this.name = name;
        this.setBaseAttributes(new BaseAttributes(2, 6, 1));
        this.setClassType(ClassType.ROGUE);
    }

    @Override
    public String toString() {
        return "Rogue{" +
                "Level = " + level +
                ", Dps = " + this.getCharacterDps() +
                ", baseAttributes = " + "Strength: "+ baseAttributes.str + " Dexterity: "+ baseAttributes.dex + " Intelligence: "+ baseAttributes.intel +
                ", ClassType=" + classType +
                ", Name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equipWeapon(Weapons wep) throws InvalidWeaponException {
        if (wep.itemLevel > this.level) {
            throw new InvalidWeaponException("Weapon level is to high! Weapon level: " + wep.itemLevel);
        } else if (wep.getWeaponType() == Weapons.WeaponItems.DAGGERS || wep.getWeaponType() == Weapons.WeaponItems.SWORDS) {
            this.equipments.put(wep.getItemSlot(), wep);
            return true;
        }
        else{
            throw new InvalidWeaponException(this.getClassType() + " can only equip " + Weapons.WeaponItems.DAGGERS + " or " + Weapons.WeaponItems.SWORDS);
        }
    }

    @Override
    public boolean equipArmour(Armours armour) throws InvalidArmourException {
        if (armour.itemLevel > this.level) {
            throw new InvalidArmourException("Armour level is to high! Armour level: " + armour.itemLevel);
        } else if (armour.getArmourItems() == Armours.ArmourItems.LEATHER || armour.getArmourItems() == Armours.ArmourItems.MAIL) {
            this.equipments.put(armour.getItemSlot(), armour);
            return true;
        }
        else{
            throw new InvalidArmourException(this.getClassType() + " can only equip " + Armours.ArmourItems.LEATHER + " or " + Armours.ArmourItems.MAIL);
        }
    }

    @Override
    public void attributeGain() {
        BaseAttributes attributes = this.getBaseAttributes();
        attributes.str = attributes.str + 1;
        attributes.dex = attributes.dex + 4;
        attributes.intel = attributes.intel + 1;
        this.setBaseAttributes(attributes);
    }

    @Override
    public double getCharacterDps() {
        this.base = this.getBaseAttributes().dex;
        if(equipments.isEmpty()){
            double weaponDps = 1;
            return this.charDps = weaponDps * ( 1 + (base / 100));
        }
        for (ItemSlots key : equipments.keySet()) {
            if(key != ItemSlots.WEAPON){
                this.totalPrimaryAttributes = this.totalPrimaryAttributes + equipments.get(key).getPrimaryAttributes().dex;
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
