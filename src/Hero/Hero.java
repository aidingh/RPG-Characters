package Hero;
import Armour.Armours;
import Attributes.BaseAttributes;
import Attributes.PrimaryAttributes;
import Item.Item;
import Weapons.Weapons;

import java.util.HashMap;

public abstract class Hero extends Item {

    public enum ClassType {
        MAGE, RANGER, ROGUE, WARRIOR
    }

    public int level = 1;
    public PrimaryAttributes totalPrimaryAttributes;
    public BaseAttributes baseAttributes;
    public ClassType classType;

    public Hero() {}

    public ClassType getClassType() {
        return classType;
    }

    public void setClassType(ClassType classType) {
        this.classType = classType;
    }

    public abstract boolean equipWeapon(Weapons wep);

    public abstract boolean equipArmour(Armours armour);

    public abstract void attributeGain();

    public void heroLevelUp(){
        this.level = this.level + 1;
        this.attributeGain();
    }

    public PrimaryAttributes getTotalPrimaryAttributes() {
        return totalPrimaryAttributes;
    }

    public void setTotalPrimaryAttributes(PrimaryAttributes totalPrimaryAttributes) {
        this.totalPrimaryAttributes = totalPrimaryAttributes;
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
