package Heroes;

import Armour.Armours;
import Attributes.BaseAttributes;
import CustomExceptions.InvalidArmourException;
import CustomExceptions.InvalidWeaponException;
import Hero.Hero;
import Weapons.Weapons;

/**
 * @author Aidin Ghassemloi
 * Mage class extending the hero class.
 * Specific Mage functions are present in this class.
 */
public class Mage extends Hero {

    public String name;

    /**
     * Creates a mage object and sets its initial values.
     * @param  name name of the new class.
     */
    public Mage(String name) {
        this.name = name;
        this.setBaseAttributes(new BaseAttributes(1, 1, 8));
        this.setClassType(ClassType.MAGE);
    }

    /**
     * Returns a string containing the mage class attributes and more.
     * @return Object as string.
     */
    @Override
    public String toString() {
        return "Mage{" +
                "Level = " + level +
                ", Dps = " + this.getCharacterDps() +
                ", baseAttributes = " + "Strength: "+ baseAttributes.str + " Dexterity: "+ baseAttributes.dex + " Intelligence: "+ baseAttributes.intel +
                ", ClassType=" + classType +
                ", Name='" + name + '\'' +
                '}';
    }


    /**
     * Equips a weapon object to the mage class.
     * Mage can only equip staffs or wands.
     * Function also checks if the class is the right hero level to equip the weapon.
     *
     * @param wep Weapon object.
     * @throws InvalidWeaponException will throw custom exception.
     */
    @Override
    public boolean equipWeapon(Weapons wep) throws InvalidWeaponException {
        if (wep.itemLevel > this.level) {
            throw new InvalidWeaponException("Weapon level is to high! Weapon level: " + wep.itemLevel);
        } else if (wep.getWeaponType() == Weapons.WeaponItems.STAFFS || wep.getWeaponType() == Weapons.WeaponItems.WANDS) {
            this.equipments.put(wep.getItemSlot(), wep);
            return true;
        }
        else{
            throw new InvalidWeaponException(this.getClassType() + " can only equip " + Weapons.WeaponItems.STAFFS + " or " + Weapons.WeaponItems.WANDS);
        }
    }

    /**
     * Equips an armour object to the mage class.
     * Mage can only equip cloth armour.
     * Function also checks if the class is the right hero level to equip the armour.
     *
     * @param  armour Armour object
     * @throws InvalidArmourException will throw custom exception.
     */
    @Override
    public boolean equipArmour(Armours armour) throws InvalidArmourException {
        if (armour.itemLevel > this.level) {
            throw new InvalidArmourException("Armour level is to high! Armour level: " + armour.itemLevel);
        } else if (armour.getArmourItems() == Armours.ArmourItems.CLOTH) {
            this.equipments.put(armour.getItemSlot(), armour);
            return true;
        }
        else{
            throw new InvalidArmourException(this.getClassType() + " can only equip " + Armours.ArmourItems.CLOTH);
        }
    }

    /**
     * Attribute gain per hero level for the mage class.
     */
    @Override
    public void attributeGain() {
        BaseAttributes attributes = this.getBaseAttributes();
        attributes.str = attributes.str + 1;
        attributes.dex = attributes.dex + 1;
        attributes.intel = attributes.intel + 5;
        this.setBaseAttributes(attributes);
    }

    /**
     * Returns a double containing the dps output for the mage class.
     * Function will handle three main cases: 1) If no weapon and armour is equipped. 2) If armour is equipped. 3) If weapon and armour is equipped.
     *
     * @return (this.charDps) double containing the class dps.
     */
    @Override
    public double getCharacterDps() {
        this.base = this.getBaseAttributes().intel;
        if(equipments.isEmpty()){
            double weaponDps = 1;
            return this.charDps = weaponDps * ( 1 + (base / 100));
        }
        for (ItemSlots key : equipments.keySet()) {
            if(key != ItemSlots.WEAPON){
                this.totalPrimaryAttributes = this.totalPrimaryAttributes + equipments.get(key).getPrimaryAttributes().intel;
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
