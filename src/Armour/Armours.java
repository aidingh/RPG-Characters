package Armour;
import Attributes.PrimaryAttributes;
import Item.Item;

public class Armours extends Item {

    public enum ArmourItems{
        CLOTH, LEATHER, MAIL, PLATE
    }

    public Armours.ArmourItems armourItems;

    public Armours() {
    }

    public Armours(String armourName, int itemLevel, Armours.ArmourItems armourType, ItemSlots itemSlot, PrimaryAttributes prime) {
        this.armourItems = armourType;
        this.setPrimaryAttributes(prime);
        this.setItemName(armourName);
        this.setItemLevel(itemLevel);
        this.setItemSlot(itemSlot);
    }

    public ArmourItems getArmourItems() {
        return armourItems;
    }

    public void setArmourType(ArmourItems armourItems) {
        this.armourItems = armourItems;
    }
}
