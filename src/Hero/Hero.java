package Hero;
import Armour.Armours;
import Attributes.BaseAttributes;
import CustomExceptions.InvalidArmourException;
import CustomExceptions.InvalidWeaponException;
import Item.Item;
import Weapons.Weapons;
import java.util.HashMap;

public abstract class Hero extends Item {

    public enum ClassType {
        MAGE, RANGER, ROGUE, WARRIOR
    }

    public int level = 1;
    public HashMap<ItemSlots, Item> equipments = new HashMap<>();
    public double charDps;
    public double base;
    public double totalPrimaryAttributes;
    public BaseAttributes baseAttributes;
    public ClassType classType;

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
