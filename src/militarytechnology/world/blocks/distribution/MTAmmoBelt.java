package militarytechnology.world.blocks.distribution;

import arc.struct.Seq;
import mindustry.gen.Building;
import mindustry.type.Item;
import mindustry.world.blocks.distribution.StackConveyor;

public class MTAmmoBelt extends StackConveyor {
    public Seq<Item> allowedAmmo;

    public MTAmmoBelt(String name, Seq<Item> allowedAmmo) {
        super(name);
        this.allowedAmmo = allowedAmmo;
    }

    public boolean acceptItem(Building build, Item item, Building source) {
        return allowedAmmo.contains(item);
    }
}