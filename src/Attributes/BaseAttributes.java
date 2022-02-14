package Attributes;

/**
 * @author Aidin Ghassemloi
 * Creates a base attribute object.
 * BaseAttributes are set to heros as base stats that gain attribute on hero level up.
 */
public class BaseAttributes {

    public double str;
    public double dex;
    public double intel;

    public BaseAttributes(double str, double dex, double intel) {
        this.str = str;
        this.dex = dex;
        this.intel = intel;
    }

    public double getStr() {
        return str;
    }

    public void setStr(double str) {
        this.str = str;
    }

    public double getDex() {
        return dex;
    }

    public void setDex(double dex) {
        this.dex = dex;
    }

    public double getIntel() {
        return intel;
    }

    public void setIntel(double intel) {
        this.intel = intel;
    }
}
