package Heroes;

import Armour.Armours;
import Attributes.BaseAttributes;
import Hero.Hero;
import Weapons.Weapons;

public class Ranger extends Hero{

    public String name;

    public Ranger(String name) {
        this.name = name;
        this.setBaseAttributes(new BaseAttributes(1, 7, 1));
        this.setClassType(ClassType.RANGER);
    }

    @Override
    public boolean equipWeapon(Weapons wep) {
        return false;
    }

    @Override
    public boolean equipArmour(Armours armour) {
        return false;
    }

    @Override
    public void attributeGain() {

    }

    @Override
    public double getCharacterDps() {
        return 0;
    }
}
