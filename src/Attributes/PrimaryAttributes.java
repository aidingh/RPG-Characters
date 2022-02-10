package Attributes;

public class PrimaryAttributes {
    public int str;
    public int dex;
    public int intel;

    public PrimaryAttributes(int str, int dex, int intel) {
        this.str = str;
        this.dex = dex;
        this.intel = intel;
    }

    public int getStr() {
        return str;
    }

    public void setStr(int str) {
        this.str = str;
    }

    public int getDex() {
        return dex;
    }

    public void setDex(int dex) {
        this.dex = dex;
    }

    public int getIntel() {
        return intel;
    }

    public void setIntel(int intel) {
        this.intel = intel;
    }
}
