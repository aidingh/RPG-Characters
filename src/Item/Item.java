package Item;

public abstract class Item {

    public enum ItemSlots {
        WEAPON, LEGS, BODY, HEAD
    }

    public String itemName;
    public int itemLevel;
    public ItemSlots itemSlot;

    public Item() {
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
