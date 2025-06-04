package militarytechnology.type;

import arc.struct.Seq;
import militarytechnology.world.blocks.crafting.CraftPlan;
import mindustry.world.blocks.production.GenericCrafter;

public class MTAmmoAssembler extends GenericCrafter {

    public Seq<CraftPlan> plans = new Seq<>();

    public MTAmmoAssembler(String name) {
        super(name);
    }

    public MTAmmoAssembler(String name, Seq<CraftPlan> plans) {
        super(name);
        this.plans = plans;
    }
}
