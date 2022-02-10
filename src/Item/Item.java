package Item;
import Weapons.Weapons;
import java.util.HashMap;


public abstract class Item {

    public enum ItemSlots {
        WEAPON, LEGS, BODY, HEAD
    }

    public String itemName;
    public int itemLevel;
    public ItemSlots itemSlot;
    public HashMap<ItemSlots, Weapons> equipments = new HashMap<>();

    public HashMap<ItemSlots, Weapons> getEquipments() {
        return equipments;
    }

    public void setEquipments(Weapons wep) {
        System.out.println(wep.getItemLevel());
        System.out.println(wep.getItemSlot());
        System.out.println(wep.getWeaponType());
        
    }

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
