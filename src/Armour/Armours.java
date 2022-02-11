package Armour;
import Attributes.PrimaryAttributes;
import Hero.Hero;
import Item.Item;

public class Armours extends Item {

    public enum ArmourItems{
        CLOTH, LEATHER, MAIL, PLATE
    }

    public Armours.ArmourItems armourItems;

    public Armours() {
    }

    public ArmourItems getArmourItems() {
        return armourItems;
    }

    public void setArmourItems(ArmourItems armourItems) {
        this.armourItems = armourItems;
    }
}
