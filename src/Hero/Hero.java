package Hero;
import Attributes.BaseAttributes;
import Attributes.PrimaryAttributes;
import Item.Item;

public abstract class Hero extends Item {


    public int level = 1;
    public PrimaryAttributes totalPrimaryAttributes;
    public BaseAttributes baseAttributes;

    public Hero() {}

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
