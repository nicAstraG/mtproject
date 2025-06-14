package militarytechnology.content;

import arc.graphics.Color;
import mindustry.type.Item;

public class MTItems {

    public static Item ironRaw, ironIngot, steelIngot, bauxite, aluminiumIngot, casingAlloy, tungstenRaw, tungstenRod,
            depletedThorium, enrichedThorium, bitumen, t1Composite, t2Composite, t3Composite,
            propellant, ap762, ap127, he127, ap20, he20, ap35, he35, apds35, ap37, he37, ap50, he50, ap76, he76,
            apds76, heatfs76, ap90, he90, apcr90, heatfs90, ap105, he105, apfsds105, apfsds2_105,
            heatfs105, ap120, he120, apfsds120, apfsds2_120, heatfs120, he155, he203, he305;

    public static void load() {

        ironRaw = new Item("iron-raw", Color.valueOf("989fa9")) {{
            localizedName = "Raw Iron Ore";
            description = "Unprocessed iron ore, basic resource for smelting.";
            hardness = 2;
            buildable = false;
        }};

        ironIngot = new Item("iron-ingot", Color.valueOf("cbcdcd")) {{
            localizedName = "Iron Ingot";
            description = "Refined iron, used in most crafting and construction.";
            cost = 0.8f;
        }};

        steelIngot = new Item("steel-ingot", Color.valueOf("343432")) {{
            localizedName = "Steel";
            description = "Hardened iron alloy, stronger and more durable.";
            cost = 1.15f;
            healthScaling = 0.5f;
        }};

        bauxite = new Item("bauxite-ore", Color.valueOf("bd6858")) {{
            localizedName = "Bauxite Ore";
            description = "Raw ore for extracting aluminum.";
            buildable = false;
        }};

        aluminiumIngot = new Item("aluminium-ingot", Color.valueOf("cac4b8")) {{
            localizedName = "Amulinium";
            description = "Lightweight metal used for advanced constructions.";
            cost = 0.9f;
            healthScaling = 0.2f;
        }};

        casingAlloy = new Item("casing-alloy", Color.valueOf("958d69")) {{
            localizedName = "Casing Alloy";
            description = "Metal alloy mainly used for projectile casings.";
            cost = 0.8f;
        }};

        tungstenRaw = new Item("tungsten-raw", Color.valueOf("4a4a4a")) {{
            localizedName = "Raw Tungsten Ore";
            description = "Unrefined tungsten ore, prized for hardness.";
            hardness = 4;
            buildable = false;
        }};

        tungstenRod = new Item("tungsten-rod", Color.valueOf("767980")) {{
            localizedName = "Tungsten Rod";
            description = "Processed tungsten for high-strength components.";
            cost = 1.5f;
            healthScaling = 1f;
        }};

        depletedThorium = new Item("depleted-thorium", Color.valueOf("645266")) {{
            localizedName = "Depleted Thorium";
            description = "Used nuclear material with residual radioactivity.";
            radioactivity = 0.02f;
            cost = 1.5f;
            healthScaling = 0.5f;
        }};

        enrichedThorium = new Item("enriched-thorium", Color.valueOf("e100ff")) {{
            localizedName = "Enriched Thorium";
            description = "Highly radioactive fuel for advanced power systems.";
            explosiveness = 4f;
            radioactivity = 10f;
            buildable = false;
        }};

        bitumen = new Item("bitumen", Color.valueOf("000000")) {{
            localizedName = "Bitumen";
            description = "Dark-colored, semi-solid to hard, sticky hydrocarbon mixtures obtained during the processing of crude oil. Used as binding material for roads.";
            explosiveness = 0.9f;
            flammability = 0.4f;
            buildable = false;
        }};

        t1Composite = new Item("t1-composite", Color.valueOf("c9c9c9")) {{
            localizedName = "Plastic Composite";
            description = "Synthetic material, moderately flammable and flexible.";
            flammability = 0.2f;
            cost = 1.1f;
            healthScaling = 0.1f;
        }};

        t2Composite = new Item("t2-composite", Color.valueOf("456287")) {{
            localizedName = "Titanium Composite";
            description = "Strong, lightweight composite for high-end builds.";
            cost = 1.3f;
            healthScaling = 0.4f;
        }};

        t3Composite = new Item("t3-composite", Color.valueOf("35472a")) {{
            localizedName = "MBT Armor Composite";
            description = "Heavy-duty armor material with superior durability.";
            cost = 1.5f;
            healthScaling = 0.6f;
        }};

        propellant = new Item("propellant", Color.valueOf("18181a")) {{
            localizedName = "Propellant";
            description = "Highly flammable substance used to launch projectiles.";
            buildable = false;
            flammability = 5f;
            explosiveness = 0.25f;
        }};

        ap762 = new Item("762ap", Color.valueOf("053801")) {{
            localizedName = "7.62mm AP";
            description = "7.62mm armor-piercing round for the M1919A4 Machinegun.";
            buildable = false;
            flammability = 0.1f;
            explosiveness = 0.5f;
        }};

        ap127 = new Item("127ap", Color.valueOf("053801")) {{
            localizedName = "12.7mm AP";
            description = ".50 cal armor-piercing rounds for the M2HB Machinegun.";
            buildable = false;
            flammability = 0.1f;
            explosiveness = 0.5f;
        }};

        he127 = new Item("127he", Color.valueOf("7a4c01")) {{
            localizedName = "12.7mm HE";
            description = ".50 cal high-explosive rounds for the M2HB Machinegun.";
            buildable = false;
            flammability = 0.1f;
            explosiveness = 2f;
        }};

        ap20 = new Item("20ap", Color.valueOf("053801")) {{
            localizedName = "20mm AP";
            description = "20mm armor-piercing rounds fired from the Polsten and M168 turrets.";
            buildable = false;
            flammability = 0.1f;
            explosiveness = 0.5f;
        }};

        he20 = new Item("20he", Color.valueOf("7a4c01")) {{
            localizedName = "20mm HE";
            description = "20mm high-explosive rounds fired from the Polsten and M168 turrets.";
            buildable = false;
            flammability = 0.1f;
            explosiveness = 2f;
        }};

        ap35 = new Item("35ap", Color.valueOf("053801")) {{
            localizedName = "35mm AP";
            description = "35mm AP for the OerlikonKDA Air-defense system.";
            buildable = false;
            flammability = 0.1f;
            explosiveness = 0.5f;
        }};

        he35 = new Item("35he", Color.valueOf("7a4c01")) {{
            localizedName = "35mm HE";
            description = "35mm HE for the OerlikonKDA Air-defense system.";
            buildable = false;
            flammability = 0.1f;
            explosiveness = 2f;
        }};

        apds35 = new Item("35apds", Color.valueOf("038a81")) {{
            localizedName = "35mm APDS";
            description = "Advanced 35mm APDS for the OerlikonKDA Air-defense system.";
            buildable = false;
            flammability = 0.1f;
            explosiveness = 0.5f;
        }};

        ap37 = new Item("37ap", Color.valueOf("053801")) {{
            localizedName = "37mm AP";
            description = "37mm AP for the M6 cannon.";
            buildable = false;
            flammability = 0.1f;
            explosiveness = 0.5f;
        }};

        he37 = new Item("37he", Color.valueOf("7a4c01")) {{
            localizedName = "37mm HE";
            description = "37mm HE for the M6 cannon.";
            buildable = false;
            flammability = 0.1f;
            explosiveness = 2f;
        }};

        ap50 = new Item("50ap", Color.valueOf("053801")) {{
            localizedName = "50mm AP";
            description = "50mm AP for the german KwK39 cannon.";
            buildable = false;
            flammability = 0.1f;
            explosiveness = 0.5f;
        }};

        he50 = new Item("50he", Color.valueOf("7a4c01")) {{
            localizedName = "50mm HE";
            description = "50mm HE for the german KwK39 cannon.";
            buildable = false;
            flammability = 0.1f;
            explosiveness = 2f;
        }};

        ap76 = new Item("76ap", Color.valueOf("053801")) {{
            localizedName = "76mm AP";
            description = "76mm AP used in the M1 cannon.";
            buildable = false;
            flammability = 0.1f;
            explosiveness = 0.5f;
        }};

        he76 = new Item("76he", Color.valueOf("7a4c01")) {{
            localizedName = "76mm HE";
            description = "76mm HE used in the M1 cannon.";
            buildable = false;
            flammability = 0.1f;
            explosiveness = 2f;
        }};

        apds76 = new Item("76apds", Color.valueOf("038a81")) {{
            localizedName = "76mm APDS";
            description = "Advanced 76mm APDS for the long 76mm M32 cannon.";
            buildable = false;
            flammability = 0.1f;
            explosiveness = 0.5f;
        }};

        heatfs76 = new Item("76heatfs", Color.valueOf("8a0303")) {{
            localizedName = "76mm HEAT-FS";
            description = "Advanced 76mm HEAT-FS for the long 76mm M32 cannon.";
            buildable = false;
            flammability = 0.1f;
            explosiveness = 1.8f;
        }};

        ap90 = new Item("90ap", Color.valueOf("053801")) {{
            localizedName = "90mm AP";
            description = "90mm AP round for the M3 and T15E2 cannons.";
            buildable = false;
            flammability = 0.1f;
            explosiveness = 0.5f;
        }};

        he90 = new Item("90he", Color.valueOf("7a4c01")) {{
            localizedName = "90mm HE";
            description = "90mm HE round for the M3 and T15E2 cannons.";
            buildable = false;
            flammability = 0.1f;
            explosiveness = 2f;
        }};

        apcr90 = new Item("90apcr", Color.valueOf("038a81")) {{
            localizedName = "90mm APCR";
            description = "90mm APCR round used in the M41 cannon.";
            buildable = false;
            flammability = 0.1f;
            explosiveness = 0.5f;
        }};

        heatfs90 = new Item("90heatfs", Color.valueOf("8a0303")) {{
            localizedName = "90mm HEAT-FS";
            description = "Advanced 90mm HEATFS round used in the M41 cannon.";
            buildable = false;
            flammability = 0.1f;
            explosiveness = 1.8f;
        }};

        ap105 = new Item("105ap", Color.valueOf("053801")) {{
            localizedName = "105mm AP";
            description = "105mm AP for the T5E1 cannon.";
            buildable = false;
            flammability = 0.1f;
            explosiveness = 0.5f;
        }};

        he105 = new Item("105he", Color.valueOf("7a4c01")) {{
            localizedName = "105mm HE";
            description = "105mm HE for the T5E1 cannon.";
            buildable = false;
            flammability = 0.1f;
            explosiveness = 2f;
        }};

        apfsds105 = new Item("105apfsds", Color.valueOf("030e8a")) {{
            localizedName = "105mm APFSDS";
            description = "Advanced 105mm APFSDS round for the M68A1E8 cannon.";
            buildable = false;
            flammability = 0.1f;
            explosiveness = 0.75f;
        }};

        apfsds2_105 = new Item ("105apfsds2", Color.valueOf("88038a")) {{
            localizedName = "105mm APFSDS-2";
            description = "Powerful 105mm APFSDS2 round for the M68A1E8 cannon.";
            buildable = false;
            flammability = 0.1f;
            explosiveness = 0.75f;
        }};

        heatfs105 = new Item ("105heatfs", Color.valueOf("8a0303")) {{
            localizedName = "105mm HEAT-FS";
            description = "Advanced 105mm HEATFS round for the M68A1E8 cannon.";
            buildable = false;
            flammability = 0.1f;
            explosiveness = 1.8f;
        }};

        ap120 = new Item ("120ap", Color.valueOf("053801")) {{
            localizedName = "120mm AP";
            description = "Big 120mm AP for the M58 cannon.";
            buildable = false;
            flammability = 0.1f;
            explosiveness = 0.5f;
        }};

        he120 = new Item ("120he", Color.valueOf("7a4c01")) {{
            localizedName = "120mm HE";
            description = "Deangerous 120mm HE for the M58 cannon.";
            buildable = false;
            flammability = 0.1f;
            explosiveness = 2f;
        }};

        apfsds120 = new Item ("120apfsds", Color.valueOf("030e8a")) {{
            localizedName = "120mm APFSDS";
            description = "Advanced 120mm APFSDS round for the M256 cannon.";
            buildable = false;
            flammability = 0.1f;
            explosiveness = 0.75f;
        }};

        apfsds2_120 = new Item ("120apfsds2", Color.valueOf("88038a")) {{
            localizedName = "120mm APFSDS-2";
            description = "Powerful 120mm APFSDS2 round for the M256 cannon.";
            buildable = false;
            flammability = 0.1f;
            explosiveness = 0.75f;
        }};

        heatfs120 = new Item ("120heatfs", Color.valueOf("8a0303")) {{
            localizedName = "120mm HEAT-FS";
            description = "Advanced 120mm HEATFS round for the M256 cannon.";
            buildable = false;
            flammability = 0.1f;
            explosiveness = 1.8f;
        }};

        he155 = new Item ("155he", Color.valueOf("8a0303")) {{
            localizedName = "155mm HE";
            description = "Standart 155mm HE artillery shell for the M185 cannon.";
            buildable = false;
            flammability = 0.1f;
            explosiveness = 5f;
        }};

        he203 = new Item ("203he", Color.valueOf("8a0303")) {{
            localizedName = "203mm HE";
            description = "Big 203mm HE artillery shell used in the 8/55 Mark naval cannon.";
            buildable = false;
            flammability = 0.1f;
            explosiveness = 8f;
        }};

        he305 = new Item ("305he", Color.valueOf("8a0303")) {{
            localizedName = "305mm HE";
            description = "Huge 305mm HE artillery shell used in the 12/50 Mk.7 naval cannon.";
            buildable = false;
            flammability = 0.1f;
            explosiveness = 14f;
        }};
    }
}