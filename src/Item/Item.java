package Item;


import Attributes.PrimaryAttributes;
import Weapons.Weapons;

public abstract class Item {

    public enum ItemSlots {
        WEAPON, LEGS, BODY, HEAD
    }

    public String itemName;
    public int itemLevel;
    public ItemSlots itemSlot;
    public PrimaryAttributes primaryAttributes;
    public Weapons wep;

    public Item() {
    }


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
