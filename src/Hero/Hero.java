package Hero;
import Armour.Armours;
import Attributes.BaseAttributes;
import CustomExceptions.InvalidArmourException;
import CustomExceptions.InvalidWeaponException;
import Item.Item;
import Weapons.Weapons;
import java.util.HashMap;

/**
 * @author Aidin Ghassemloi
 * Abstact class Hero is extended among all hero classes.
 * Abstact methods are defined, the methods needs to be implmeneted for all heros.
 */

public abstract class Hero extends Item {

    public enum ClassType {
        MAGE, RANGER, ROGUE, WARRIOR
    }

    /**
     * All public variables in this class is shared among all instances of a new hero class.
     */
    public int level = 1;
    public HashMap<ItemSlots, Item> equipments = new HashMap<>();
    public double charDps;
    public double base;
    public double totalPrimaryAttributes;
    public BaseAttributes baseAttributes;
    public ClassType classType;

    /**
     * All public functions in this class is shared among all instances of a new hero class.
     * Abstract functions are implemented in the hero classes.
     */
    public Hero() {}

    public ClassType getClassType() {
        return classType;
    }

    public void setClassType(ClassType classType) {
        this.classType = classType;
    }

    public abstract boolean equipWeapon(Weapons wep) throws InvalidWeaponException;

    public abstract boolean equipArmour(Armours armour) throws InvalidArmourException;

    public abstract void attributeGain();

    public abstract double getCharacterDps();;

    /**
     * Function is called when a class levels up.
     * This function will call the abstract method attributeGain() that will gain the correct attributes for the corresponding class.
     */
    public void heroLevelUp(){
        this.level = this.level + 1;
        this.attributeGain();
    }

    public BaseAttributes getBaseAttributes() {
        return baseAttributes;
    }

    public void setBaseAttributes(BaseAttributes baseAttributes) {
        this.baseAttributes = baseAttributes;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

}
