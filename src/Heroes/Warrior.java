package Heroes;

import Armour.Armours;
import Attributes.BaseAttributes;
import CustomExceptions.InvalidArmourException;
import CustomExceptions.InvalidWeaponException;
import Hero.Hero;
import Weapons.Weapons;

/**
 * @author Aidin Ghassemloi
 * Warrior class extending the hero class.
 * Specific warrior functions are present in this class.
 */
public class Warrior extends Hero {

    public String name;

    /**
     * Creates a warrior object and sets its initial values.
     * @param  name name of the new class.
     */
    public Warrior(String name) {
        this.name = name;
        this.setBaseAttributes(new BaseAttributes(5, 2, 1));
        this.setClassType(ClassType.WARRIOR);
    }

    /**
     * Returns a string containing the warrior class attributes and more.
     * @return Object as string.
     */
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

    /**
     * Equips a weapon object to the warrior class.
     * Warrior can only equip axes, hammers or swords.
     * Function also checks if the class is the right hero level to equip the weapon.
     *
     * @param wep Weapon object.
     * @throws InvalidWeaponException will throw custom exception.
     */
    @Override
    public boolean equipWeapon(Weapons wep) throws InvalidWeaponException {
        if (wep.itemLevel > this.level) {
            throw new InvalidWeaponException("Weapon level is to high! Weapon level: " + wep.itemLevel);
        } else if (wep.getWeaponType() == Weapons.WeaponItems.AXES || wep.getWeaponType() == Weapons.WeaponItems.HAMMERS || wep.getWeaponType() == Weapons.WeaponItems.SWORDS) {
            this.equipments.put(wep.getItemSlot(), wep);
            return true;
        }
        else{
            throw new InvalidWeaponException(this.getClassType() + " can only equip " + Weapons.WeaponItems.AXES + " , " + Weapons.WeaponItems.HAMMERS + " or " +  Weapons.WeaponItems.SWORDS);
        }
    }

    /**
     * Equips an armour object to the warrior class.
     * Warrior can only equip mail or plate armour.
     * Function also checks if the class is the right hero level to equip the armour.
     *
     * @param  armour Armour object
     * @throws InvalidArmourException will throw custom exception.
     */
    @Override
    public boolean equipArmour(Armours armour) throws InvalidArmourException {
        if (armour.itemLevel > this.level) {
            throw new InvalidArmourException("Armour level is to high! Armour level: " + armour.itemLevel);
        } else if (armour.getArmourItems() == Armours.ArmourItems.MAIL || armour.getArmourItems() == Armours.ArmourItems.PLATE) {
            this.equipments.put(armour.getItemSlot(), armour);
            return true;
        }
        else{
            throw new InvalidArmourException(this.getClassType() + " can only equip " + Armours.ArmourItems.MAIL + " or " + Armours.ArmourItems.PLATE);
        }
    }

    /**
     * Attribute gain per hero level for the warrior class.
     */
    @Override
    public void attributeGain() {
        BaseAttributes attributes = this.getBaseAttributes();
        attributes.str = attributes.str + 3;
        attributes.dex = attributes.dex + 2;
        attributes.intel = attributes.intel + 1;
        this.setBaseAttributes(attributes);
    }

    /**
     * Returns a double containing the dps output for the warrior class.
     * Function will handle three main cases: 1) If no weapon and armour is equipped. 2) If armour is equipped. 3) If weapon and armour is equipped.
     *
     * @return (this.charDps) double containing the class dps.
     */
    @Override
    public double getCharacterDps() {
        this.base = this.getBaseAttributes().str;
        if(equipments.isEmpty()){
            double weaponDps = 1;
            return this.charDps = weaponDps * ( 1 + (base / 100));
        }
        for (ItemSlots key : equipments.keySet()) {
            if(key != ItemSlots.WEAPON){
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
