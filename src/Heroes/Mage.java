package Heroes;

import Attributes.BaseAttributes;
import Hero.Hero;

public class Mage extends Hero {

    public String name;

    public Mage(String name) {
        this.name = name;
        this.setBaseAttributes(new BaseAttributes(1, 1, 8));
    }

    @Override
    public String toString() {
        return "Mage{" +
                "name='" + name + '\'' +
                ", level=" + level +
                ", totalPrimaryAttributes=" + totalPrimaryAttributes +
                ", baseAttributes =" + " str: " + baseAttributes.str +  " dex: " + baseAttributes.dex + " intelligence: " + baseAttributes.intel +
                '}';
    }

    @Override
    public void attributeGain() {
        BaseAttributes attributes = this.getBaseAttributes();
        attributes.str = attributes.str + 1;
        attributes.dex = attributes.dex + 1;
        attributes.intel = attributes.intel + 5;
        this.setBaseAttributes(attributes);
    }

}
