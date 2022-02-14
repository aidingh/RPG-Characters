package Armour;
import Attributes.PrimaryAttributes;
import Item.Item;

/**
 * @author Aidin Ghassemloi
 * Weapons class extending the Item class.
 */
public class Armours extends Item {

    public enum ArmourItems{
        CLOTH, LEATHER, MAIL, PLATE
    }

    /**
     * All public variables local to this class.
     */
    public Armours.ArmourItems armourItems;

    /**
     * Creates an empty Armours object. But its values must be set with getters and setters.
     */
    public Armours() {
    }

    /**
     * Creates a Armours object. All values are set at once.
     */
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
