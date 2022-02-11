package Weapons;
import Item.Item;

public class Weapons extends Item{

    public enum WeaponItems {
        AXES, BOWS, DAGGERS, HAMMERS, STAFFS, SWORDS, WANDS
    }

    public double dps;
    public double attackSpeed;
    public double dmg;
    public String weaponName;
    public WeaponItems weaponType;

    public Weapons() {}

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
    
    public String getWeaponName() {
        return weaponName;
    }

}


