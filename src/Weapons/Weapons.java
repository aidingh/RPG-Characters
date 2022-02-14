package Weapons;
import Item.Item;

/**
 * @author Aidin Ghassemloi
 * Weapons class extending the Item class.
 */
public class Weapons extends Item{

    public enum WeaponItems {
        AXES, BOWS, DAGGERS, HAMMERS, STAFFS, SWORDS, WANDS
    }

    /**
     * All public variables local to this class.
     */
    public double dps;
    public double attackSpeed;
    public double dmg;
    public WeaponItems weaponType;

    /**
     * Creates an empty Weapons object. But its values must be set with getters and setters.
     */
    public Weapons() {}

    /**
     * Creates a Weapons object. All values are set at once.
     */
    public Weapons(double attackSpeed, double dmg, int itemLevel, String weaponName, WeaponItems weaponType, ItemSlots itemSlot) {
        this.attackSpeed = attackSpeed;
        this.dmg = dmg;
        this.setItemName(weaponName);
        this.weaponType = weaponType;
        this.setItemLevel(itemLevel);
        this.setItemSlot(itemSlot);
    }

    public WeaponItems getWeaponType() {
        return weaponType;
    }

    public void setWeaponType(WeaponItems weaponType) {
        this.weaponType = weaponType;
    }

    public double getWeaponDamage() {
        return this.dps = this.dmg * this.attackSpeed;
    }

    public double getDps() {
        return dps;
    }

    public void setDps(int dps) {
        this.dps = dps;
    }

    public double getAttackSpeed() {
        return attackSpeed;
    }

    public void setAttackSpeed(double attackSpeed) {
        this.attackSpeed = attackSpeed;
    }

    public double getDmg() {
        return dmg;
    }

    public void setDmg(int dmg) {
        this.dmg = dmg;
    }

}


