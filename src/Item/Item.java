package Item;
import Attributes.PrimaryAttributes;
import Weapons.Weapons;

/**
 * @author Aidin Ghassemloi
 * Abstact class Item is extended among Weapons and Armours.
 */

public abstract class Item {

    public enum ItemSlots {
        WEAPON, LEGS, BODY, HEAD
    }

    /**
     * All public variables in this class is shared among all instances of armours or weapons.
     */
    public String itemName;
    public int itemLevel;
    public ItemSlots itemSlot;
    public PrimaryAttributes primaryAttributes;
    public Weapons wep;

    public Item() {
    }

    /**
     * All public functions in this class is shared among all instances of a new hero class.
     */
    public double getWeaponDamage(){
        return wep.getWeaponDamage();
    }

    public PrimaryAttributes getPrimaryAttributes() {
        return primaryAttributes;
    }

    public void setPrimaryAttributes(PrimaryAttributes primaryAttributes) {
        this.primaryAttributes = primaryAttributes;
    }

    public ItemSlots getItemSlot() {
        return itemSlot;
    }

    public void setItemSlot(ItemSlots itemSlot) {
        this.itemSlot = itemSlot;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getItemLevel() {
        return itemLevel;
    }

    public void setItemLevel(int itemLevel) {
        this.itemLevel = itemLevel;
    }
}
