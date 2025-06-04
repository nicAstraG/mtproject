package militarytechnology;

import arc.util.Log;
import militarytechnology.content.MTBlocks;
import militarytechnology.content.MTItems;
import militarytechnology.content.MTLiquids;
import militarytechnology.content.MTStatusEffects;
import mindustry.mod.Mod;

public class MilitaryTechnology extends Mod {

    public MilitaryTechnology(){
        Log.info("Loaded Military Technology Mod");
    }

    public void loadContent(){
        Log.info("Loading content.");
        System.out.println("MT mod loaded");
        MTItems.load();
        MTLiquids.load();
        MTStatusEffects.load();
        MTBlocks.load();
    }

}
