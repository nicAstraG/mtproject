package militarytechnology.content;

import arc.graphics.Color;
import arc.struct.Seq;
import militarytechnology.world.blocks.crafting.CraftPlan;
import militarytechnology.world.blocks.distribution.MTAmmoBelt;
import militarytechnology.type.MTAmmoAssembler;
import mindustry.content.Fx;
import mindustry.content.Items;
import mindustry.content.Liquids;
import mindustry.entities.bullet.BasicBulletType;
import mindustry.gen.Sounds;
import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.type.LiquidStack;
import mindustry.world.Block;
import mindustry.world.blocks.defense.Wall;
import mindustry.world.blocks.defense.turrets.ItemTurret;
import mindustry.world.blocks.environment.OreBlock;
import mindustry.world.blocks.power.ConsumeGenerator;
import mindustry.world.blocks.production.AttributeCrafter;
import mindustry.world.blocks.production.GenericCrafter;
import mindustry.world.blocks.production.Separator;
import mindustry.world.consumers.ConsumeLiquidFilter;
import mindustry.world.draw.DrawDefault;
import mindustry.world.draw.DrawFlame;
import mindustry.world.draw.DrawMulti;
import mindustry.world.meta.Attribute;

import static militarytechnology.content.MTItems.ap762;
import static mindustry.type.ItemStack.with;

public class MTBlocks {
    public static Block

        //ores
        oreIron, oreBauxite, oreTungsten,

        //crafting
        oilRefinery, ironFurnace, ironSmeltery, aluminiumSmeltery, arcFurnace, radioactiveCentrifuge, steelForge,
        casingSmelter, propellantMixer, ammoAssembler1, ammoAssembler2, ammoAssembler3, ammoAssemblerA, ammoAssemblerM1,
        ammoAssemblerM2, t1CompositeAssembler, t2CompositeAssembler, t3CompositeAssembler,

        //defence

        t1wall, t1wallL, t2wall, t2wallL, t3wall, t3wallL,

        //transport
        ammoBeltS, ammoBeltM, ammoBeltL, ammoBeltA,

        //power
        dieselGeneratorS, dieselGenerator, locomotiveEngine, shipEngine,

        //turrets
        m1919a4, m2hb, polsten, m168, oerlikonkda, m6, kwk39, m1, m32, m3, t15e2, m41, t5e1, m68a1e8, m58, m256, m185, mark5508, mark75012;

    public static void load() {

        //region ore

        oreIron = new OreBlock(MTItems.ironRaw) {{
            localizedName = "Iron Ore";
            description = "A dense deposit of raw iron.";
            oreDefault = true;
            oreThreshold = 0.81f;
            oreScale = 23.47619f;
        }};

        oreBauxite = new OreBlock(MTItems.bauxite) {{
            localizedName = "Bauxite Ore";
            description = "A soft, reddish ore used to produce aluminum.";
            oreDefault = true;
            oreThreshold = 0.828f;
            oreScale = 23.47619f;
        }};

        oreTungsten = new OreBlock(MTItems.tungstenRaw) {{
            localizedName = "Tungsten Ore";
            description = "A rare, dense ore prized for its exceptional hardness and high melting point.";
            oreDefault = true;
            oreThreshold = 0.882f;
            oreScale = 16.380953f;
        }};

        //endregion
        //region crafting

        oilRefinery = new GenericCrafter("oil-refinery") {{
            localizedName = "Oil Refinery";
            description = "Processes crude oil into diesel, lubricant, heavy fuel oil and tar.";
            requirements(Category.crafting, with(
                    MTItems.ironIngot, 120,
                    Items.copper, 50,
                    Items.silicon, 80,
                    Items.titanium, 100,
                    Items.graphite, 40,
                    Items.metaglass, 60,
                    MTItems.steelIngot, 40
            ));

            outputLiquids = LiquidStack.with(
                    MTLiquids.diesel, 12f / 60f,
                    MTLiquids.heavyFuelOil, 8f / 60f,
                    MTLiquids.lubricant, 16f / 60f
            );

            outputItem = new ItemStack(MTItems.tarItem, 2);
            liquidOutputDirections = new int[]{1, 2, 3};

            size = 3;
            craftTime = 60f;

            hasPower = true;
            hasItems = true;
            hasLiquids = true;
            rotate = true;
            solid = true;

            outputsLiquid = true;

            liquidCapacity = 72f;

            consumePower(2f);
            consumeLiquid(Liquids.oil, 36f / 60f);
        }};

        ironFurnace = new GenericCrafter("iron-furnace") {{
            localizedName = "Iron Furnace";
            description = "Smelts raw iron into refined ingots.";
            requirements(Category.crafting, with(
                    Items.copper, 50,
                    Items.lead, 20,
                    Items.graphite, 25
            ));

            craftEffect = Fx.smeltsmoke;
            outputItem = new ItemStack(MTItems.ironIngot, 1);
            craftTime = 90f;
            size = 2;
            hasItems = true;
            hasPower = true;

            consumeItem(MTItems.ironRaw, 2);
        }};

        ironSmeltery = new GenericCrafter("iron-smeltery") {{
            localizedName = "Iron Smeltery";
            description = "High-efficiency smelter that rapidly processes raw iron using pyratite-assisted heating. Demands substantial power, but outputs refined ingots at industrial scale.";
            requirements(Category.crafting, with(
                    MTItems.ironIngot, 200,
                    Items.titanium, 160,
                    Items.graphite, 120,
                    Items.silicon, 80
            ));

            craftEffect = Fx.smeltsmoke;
            outputItem = new ItemStack(MTItems.ironIngot, 6);
            craftTime = 60f;
            size = 3;
            hasPower = true;
            hasItems = true;
            itemCapacity = 32;
            ambientSound = Sounds.smelter;
            ambientSoundVolume = 0.07f;

            consumeItems(with(MTItems.ironRaw, 8, Items.pyratite, 1));
            consumePower(320f / 60f);
        }};

        aluminiumSmeltery = new GenericCrafter("aluminium-smeltery") {{
            localizedName = "Aluminium Smeltery";
            description = "Uses water-cooled refinement to extract aluminium from bauxite.";
            requirements(Category.crafting, with(
                    MTItems.ironIngot, 60,
                    Items.copper, 100,
                    Items.graphite, 80,
                    Items.titanium, 100
            ));

            craftEffect = Fx.formsmoke;
            outputItem = new ItemStack(MTItems.aluminiumIngot, 2);
            craftTime = 48f;
            itemCapacity = 20;
            size = 3;
            hasItems = true;
            hasLiquids = true;
            hasPower = true;

            consumePower(1.8f);
            consumeItem(MTItems.bauxite, 4);
            consumeLiquid(Liquids.water, 12f / 60f);
        }};

        arcFurnace = new AttributeCrafter("arc-furnace") {{
            localizedName = "Arc Furnace";
            description = "High-energy induction furnace for smelting dense tungsten rods. Extremely power-intensive, but essential for late-game metallurgical processing.";
            requirements(Category.crafting, with(
                    MTItems.ironIngot, 120,
                    Items.copper, 200,
                    Items.lead, 60,
                    Items.titanium, 250,
                    Items.graphite, 180,
                    Items.silicon, 90,
                    MTItems.steelIngot, 250
            ));

            craftEffect = Fx.smeltsmoke;
            outputItem = new ItemStack(MTItems.tungstenRod, 3);
            craftTime = 150f;
            size = 4;
            hasPower = true;
            hasItems = true;
            hasLiquids = false;
            itemCapacity = 30;
            attribute = Attribute.heat;
            boostScale = 0.05f;
            drawer = new DrawMulti(new DrawDefault(), new DrawFlame(Color.valueOf("ffef99")));
            ambientSound = Sounds.smelter;
            ambientSoundVolume = 0.07f;

            consumeItems(with(MTItems.tungstenRaw, 6, Items.graphite, 1));
            consumePower(20f);
        }};

        radioactiveCentrifuge = new Separator("radioactive-centrifuge") {{
            localizedName = "Radioactive Centrifuge";
            description = "Spins thorium at high speed to separate enriched isotopes. Produces a mix of depleted and enriched thorium for nuclear applications. Requires steady water flow and high energy input.";
            requirements(Category.crafting, with(
                    MTItems.ironIngot, 180,
                    Items.copper, 140,
                    Items.lead, 300,
                    Items.titanium, 200,
                    Items.graphite, 160,
                    Items.silicon, 80,
                    Items.thorium, 100,
                    Items.metaglass, 80
            ));

            results = with(
                    MTItems.depletedThorium, 6,
                    MTItems.enrichedThorium, 1);

            craftTime = 300f;
            size = 4;
            hasPower = true;
            hasItems = true;
            itemCapacity = 50;
            ambientSound = Sounds.techloop;
            ambientSoundVolume = 0.02f;

            consumeItem(Items.thorium, 10);
            consumePower(11f);
        }};

        steelForge = new GenericCrafter("steel-forge") {{
            localizedName = "Steel Forge";
            description = "High-temperature forge for alloying iron and graphite into durable steel. Consumes large amounts of power and resources, but essential for advanced construction and defense.";
            requirements(Category.crafting, with(
                    MTItems.ironIngot, 250,
                    Items.copper, 100,
                    Items.titanium, 160,
                    Items.silicon, 100,
                    Items.graphite, 80,
                    MTItems.aluminiumIngot, 140
            ));

            craftEffect = Fx.smeltsmoke;
            outputItem = new ItemStack(MTItems.steelIngot, 1);
            craftTime = 75f;
            size = 4;
            hasPower = true;
            hasItems = true;
            itemCapacity = 20;

            consumeItems(with(MTItems.ironIngot, 4, Items.graphite, 1));
            consumePower(580f / 60f);
        }};

        casingSmelter = new GenericCrafter("casing-smelter") {{
            localizedName = "Casing Smelter";
            description = "Rapidly forges lightweight alloy casings from multiple materials and water.";
            requirements(Category.crafting, with(
                    MTItems.ironIngot, 60,
                    Items.copper, 40,
                    Items.lead, 50,
                    Items.silicon, 60,
                    Items.graphite, 60
            ));

            craftEffect = Fx.formsmoke;
            outputItem = new ItemStack(MTItems.casingAlloy, 6);
            craftTime = 15f;
            size = 3;
            hasPower = true;
            hasItems = true;
            hasLiquids = true;
            itemCapacity = 100;
            liquidCapacity = 20;

            consumeItems(with(MTItems.aluminiumIngot, 1, Items.lead, 1, Items.copper, 1, Items.silicon, 1));
            consumeLiquid(Liquids.water, 6f / 60f);
            consumePower(260f / 60f);
        }};

        propellantMixer = new GenericCrafter("propellant-mixer") {{
            localizedName = "Propellant Mixer";
            description = "Blends volatile compounds and crude oil into high-energy propellant. Essential for fueling advanced munitions and propulsion systems.";
            requirements(Category.crafting, with(
                    MTItems.ironIngot, 120,
                    Items.graphite, 100,
                    Items.silicon, 100
            ));

            craftEffect = Fx.pulverize;
            outputItem = new ItemStack(MTItems.propellant, 10);
            craftTime = 60f;
            size = 3;
            hasPower = true;
            hasItems = true;
            hasLiquids = true;
            itemCapacity = 40;
            liquidCapacity = 10;

            consumeItems(with(Items.coal, 6, Items.pyratite, 2));
            consumeLiquid(Liquids.oil, 20f / 60f);
            consumePower(80f / 60f);
        }};

        ammoAssembler1 = new MTAmmoAssembler("ammo-assembler-1") {{
            localizedName = "Autocannon Ammunition Assembler";
            description = "Assembles various machinegun ammunition types using raw materials.";
            requirements(Category.crafting, with(
                    MTItems.ironIngot, 20,
                    Items.copper, 50,
                    Items.silicon, 25
            ));

            size = 3;
            hasPower = true;
            hasItems = true;
            craftTime = 30f;
            itemCapacity = 50;
            craftEffect = Fx.pulverize;

            plans = Seq.with(
                    new CraftPlan(
                            with(MTItems.propellant, 1, MTItems.casingAlloy, 2, Items.copper, 1, Items.lead, 2),
                            new ItemStack(ap762, 10)
                    ),
                    new CraftPlan(
                            with(MTItems.propellant, 1, MTItems.casingAlloy, 3, Items.copper, 1, Items.lead, 2),
                            new ItemStack(MTItems.ap127, 10)
                    ),
                    new CraftPlan(
                            with(MTItems.propellant, 1, MTItems.casingAlloy, 3, Items.blastCompound, 1, Items.copper, 1),
                            new ItemStack(MTItems.he127, 10)
                    ),
                    new CraftPlan(
                            with(MTItems.propellant, 2, MTItems.casingAlloy, 4, Items.copper, 2, Items.lead, 2),
                            new ItemStack(MTItems.ap20, 10)
                    ),
                    new CraftPlan(
                            with(MTItems.propellant, 2, MTItems.casingAlloy, 4, Items.blastCompound, 1, Items.copper, 2),
                            new ItemStack(MTItems.he20, 10)
                    ),
                    new CraftPlan(
                            with(MTItems.propellant, 2, MTItems.casingAlloy, 6, Items.copper, 3, Items.lead, 3),
                            new ItemStack(MTItems.ap35, 10)
                    ),
                    new CraftPlan(
                            with(MTItems.propellant, 2, MTItems.casingAlloy, 6, Items.blastCompound, 2, Items.copper, 4),
                            new ItemStack(MTItems.he35, 10)
                    ));

            consumePower(40f / 60f);
        }};

        ammoAssembler2 = new MTAmmoAssembler("ammo-assembler-2") {{
            localizedName = "Medium Caliber Ammunition Assembler";
            description = "Assembles various medium caliber ammunition using more refined materials.";
            requirements(Category.crafting, with(
                    MTItems.ironIngot, 40,
                    Items.copper, 100,
                    Items.silicon, 50
            ));

            size = 3;
            hasPower = true;
            hasItems = true;
            craftTime = 60f;
            itemCapacity = 60;
            craftEffect = Fx.pulverize;

            plans = Seq.with(
                    new CraftPlan(
                            with(MTItems.propellant, 3, MTItems.casingAlloy, 6, MTItems.ironIngot, 1, Items.lead, 3),
                            new ItemStack(MTItems.ap37, 5)
                    ),
                    new CraftPlan(
                            with(MTItems.propellant, 2, MTItems.casingAlloy, 6, Items.blastCompound, 1, MTItems.ironIngot, 2),
                            new ItemStack(MTItems.he37, 5)
                    ),
                    new CraftPlan(
                            with(MTItems.propellant, 4, MTItems.casingAlloy, 8, MTItems.ironIngot, 2, Items.lead, 5),
                            new ItemStack(MTItems.ap50, 5)
                    ),
                    new CraftPlan(
                            with(MTItems.propellant, 3, MTItems.casingAlloy, 8, Items.blastCompound, 3, MTItems.ironIngot, 2),
                            new ItemStack(MTItems.he50, 5)
                    ),
                    new CraftPlan(
                            with(MTItems.propellant, 5, MTItems.casingAlloy, 10, MTItems.ironIngot, 3, Items.lead, 6),
                            new ItemStack(MTItems.ap76, 5)
                    ),
                    new CraftPlan(
                            with(MTItems.propellant, 4, MTItems.casingAlloy, 10, Items.blastCompound, 4, MTItems.ironIngot, 4),
                            new ItemStack(MTItems.he76, 5)
                    ),
                    new CraftPlan(
                            with(MTItems.propellant, 6, MTItems.casingAlloy, 14, MTItems.ironIngot, 5, Items.lead, 6),
                            new ItemStack(MTItems.ap90, 5)
                    ),
                    new CraftPlan(
                            with(MTItems.propellant, 5, MTItems.casingAlloy, 14, Items.blastCompound, 8, MTItems.ironIngot, 6),
                            new ItemStack(MTItems.he90, 5)
                    ));

            consumePower(1f);
        }};

        ammoAssembler3 = new MTAmmoAssembler("ammo-assembler-3") {{
            localizedName = "Large Caliber Ammunition Assembler";
            description = "Assembles various Large caliber ammunition using more refined materials.";
            requirements(Category.crafting, with(
                    MTItems.ironIngot, 120,
                    Items.copper, 200,
                    Items.silicon, 100
            ));

            size = 4;
            hasPower = true;
            hasItems = true;
            craftTime = 180f;
            itemCapacity = 80;
            craftEffect = Fx.pulverize;

            plans = Seq.with(
                    new CraftPlan(
                            with(MTItems.propellant, 12, MTItems.casingAlloy, 20, MTItems.steelIngot, 10),
                            new ItemStack(MTItems.ap105, 5)
                    ),
                    new CraftPlan(
                            with(MTItems.propellant, 10, MTItems.casingAlloy, 20, Items.blastCompound, 10, MTItems.steelIngot, 5, MTItems.aluminiumIngot, 2),
                            new ItemStack(MTItems.he105, 5)
                    ),
                    new CraftPlan(
                            with(MTItems.propellant, 18, MTItems.casingAlloy, 26, MTItems.steelIngot, 14),
                            new ItemStack(MTItems.ap120, 5)
                    ),
                    new CraftPlan(
                            with(MTItems.propellant, 14, MTItems.casingAlloy, 26, Items.blastCompound, 14, MTItems.steelIngot, 8, MTItems.aluminiumIngot, 4),
                            new ItemStack(MTItems.he120, 5)
                    ));

            consumePower(1.5f);
        }};

        ammoAssemblerA = new MTAmmoAssembler("ammo-assembler-a") {{
            localizedName = "Large Caliber Ammunition Assembler";
            description = "Assembles various Large caliber ammunitions using more refined materials.";
            requirements(Category.crafting, with(
                    MTItems.ironIngot, 140,
                    Items.copper, 200,
                    Items.silicon, 120
            ));

            size = 4;
            hasPower = true;
            hasItems = true;
            craftTime = 480f;
            itemCapacity = 160;
            craftEffect = Fx.pulverize;

            plans = Seq.with(
                    new CraftPlan(
                            with(MTItems.propellant, 12, MTItems.casingAlloy, 46, Items.blastCompound, 20, MTItems.ironIngot, 12, Items.copper, 6),
                            new ItemStack(MTItems.he155, 5)
                    ),
                    new CraftPlan(
                            with(MTItems.propellant, 18, MTItems.casingAlloy, 60, Items.blastCompound, 28, MTItems.ironIngot, 16, Items.copper, 10),
                            new ItemStack(MTItems.he203, 5)
                    ),
                    new CraftPlan(
                            with(MTItems.propellant, 24, MTItems.casingAlloy, 80, Items.blastCompound, 40, MTItems.ironIngot, 21, Items.copper, 18),
                            new ItemStack(MTItems.he155, 5)
                    )
            );

            consumePower(1.5f);
        }};

        ammoAssemblerM1 = new MTAmmoAssembler("ammo-assembler-m1") {{
            localizedName = "Advanced Ammunition Assembler 1";
            description = "Assembles various advanced ammunition using advanced materials. Assembles APDS, APCR and HEAT-FS";
            requirements(Category.crafting, with(
                    MTItems.ironIngot, 120,
                    Items.copper, 200,
                    Items.silicon, 160,
                    MTItems.steelIngot, 150,
                    Items.titanium, 180
            ));

            size = 3;
            hasPower = true;
            hasItems = true;
            craftTime = 240f;
            itemCapacity = 80;
            craftEffect = Fx.pulverize;

            plans = Seq.with(
                    new CraftPlan(
                            with(MTItems.propellant, 3, MTItems.casingAlloy, 6, MTItems.steelIngot, 3, MTItems.aluminiumIngot, 2),
                            new ItemStack(MTItems.apds35, 5)
                    ),
                    new CraftPlan(
                            with(MTItems.propellant, 8, MTItems.casingAlloy, 11, MTItems.steelIngot, 6, MTItems.aluminiumIngot, 4),
                            new ItemStack(MTItems.apds76, 5)
                    ),
                    new CraftPlan(
                            with(MTItems.propellant, 6, MTItems.casingAlloy, 11, Items.blastCompound, 3, MTItems.aluminiumIngot, 8, Items.copper, 1),
                            new ItemStack(MTItems.heatfs76, 5)
                    ),
                    new CraftPlan(
                            with(MTItems.propellant, 10, MTItems.casingAlloy, 16, MTItems.steelIngot, 8, MTItems.ironIngot, 5),
                            new ItemStack(MTItems.apcr90, 5)
                    ),
                    new CraftPlan(
                            with(MTItems.propellant, 7, MTItems.casingAlloy, 16, Items.blastCompound, 6, MTItems.aluminiumIngot, 10, Items.copper, 2),
                            new ItemStack(MTItems.heatfs90, 5)
                    ),
                    new CraftPlan(
                            with(MTItems.propellant, 14, MTItems.casingAlloy, 22, Items.blastCompound, 10, MTItems.aluminiumIngot, 15, Items.copper, 3),
                            new ItemStack(MTItems.heatfs105, 5)
                    ),
                    new CraftPlan(
                            with(MTItems.propellant, 18, MTItems.casingAlloy, 30, Items.blastCompound, 14, MTItems.aluminiumIngot, 18, Items.copper, 5),
                            new ItemStack(MTItems.heatfs120, 5)
                    ));

            consumePower(1.5f);
        }};

        ammoAssemblerM2 = new MTAmmoAssembler("ammo-assembler-m2") {{
            localizedName = "Advanced Ammunition Assembler 2";
            description = "Assembles advanced APFSDS ammunition using expensive materials.";
            requirements(Category.crafting, with(
                    MTItems.ironIngot, 200,
                    Items.graphite, 220,
                    Items.silicon, 190,
                    MTItems.steelIngot, 200,
                    Items.titanium, 250
            ));

            size = 4;
            hasPower = true;
            hasItems = true;
            craftTime = 330f;
            itemCapacity = 80;
            craftEffect = Fx.pulverize;


            plans = Seq.with(
                    new CraftPlan(
                            with(MTItems.propellant, 20, MTItems.casingAlloy, 22, MTItems.tungstenRod, 5, MTItems.aluminiumIngot, 12),
                            new ItemStack(MTItems.apfsds105, 5)
                    ),
                    new CraftPlan(
                            with(MTItems.propellant, 26, MTItems.casingAlloy, 24, MTItems.depletedThorium, 5, MTItems.tungstenRod, 3),
                            new ItemStack(MTItems.apfsds2_105, 5)
                    ),
                    new CraftPlan(
                            with(MTItems.propellant, 24, MTItems.casingAlloy, 30, MTItems.tungstenRod, 10, MTItems.aluminiumIngot, 16),
                            new ItemStack(MTItems.apfsds120, 5)
                    ),
                    new CraftPlan(
                            with(MTItems.propellant, 30, MTItems.casingAlloy, 32, MTItems.depletedThorium, 10, MTItems.tungstenRod, 6),
                            new ItemStack(MTItems.apfsds2_120, 5)
                    ));

            consumePower(2f);
        }};

        t1CompositeAssembler = new GenericCrafter("t1-composite-crafter") {{
            localizedName = "Tier 1 Composite Assembler";
            description = "Produces plastic composite by processing oil, metaglass, and lead. Efficient early-tier factory with moderate power use and output.";
            requirements(Category.crafting, with(
                    Items.copper, 40,
                    Items.titanium, 80,
                    Items.metaglass, 20
            ));

            craftEffect = Fx.smeltsmoke;
            outputItem = new ItemStack(MTItems.t1Composite, 2);
            craftTime = 180f;
            size = 2;
            hasItems = true;
            hasLiquids = true;
            hasPower = true;
            itemCapacity = 20;
            liquidCapacity = 10;

            consumeItems(with(Items.lead, 2, Items.metaglass, 2));
            consumeLiquid(Liquids.oil, 20f / 60f);
            consumePower(164f / 60f);
        }};

        t2CompositeAssembler = new GenericCrafter("t2-composite-crafter") {{
            localizedName = "Tier 2 Composite Assembler";
            description = "Processes plastic composite, titanium, steel, and diesel to produce titanium composite. Higher capacity and power usage for advanced materials.";
            requirements(Category.crafting, with(
                    Items.graphite, 100,
                    Items.titanium, 100,
                    Items.silicon, 120,
                    Items.plastanium, 60
            ));

            craftEffect = Fx.smeltsmoke;
            outputItem = new ItemStack(MTItems.t2Composite, 4);
            craftTime = 252f;
            size = 3;
            hasItems = true;
            hasLiquids = true;
            hasPower = true;
            itemCapacity = 30;
            liquidCapacity = 10;

            consumeItems(with(Items.titanium, 4, MTItems.t1Composite, 2, MTItems.steelIngot, 2));
            consumeLiquid(MTLiquids.diesel, 12f / 60f);
            consumePower(296f / 60f);
        }};

        t3CompositeAssembler = new GenericCrafter("t3-composite-crafter") {{
            localizedName = "Tier 3 Composite Assembler";
            description = "Uses advanced alloys, depleted thorium, tungsten, and heavy fuel oil to craft MBT-grade armor composite for heavy military applications. High power and throughput for top-tier materials.";
            requirements(Category.crafting, with(
                    Items.surgeAlloy, 60,
                    Items.silicon, 200,
                    Items.phaseFabric, 180,
                    MTItems.steelIngot, 140
            ));

            craftEffect = Fx.smeltsmoke;
            outputItem = new ItemStack(MTItems.t3Composite, 6);
            craftTime = 600f;
            size = 4;
            hasItems = true;
            hasLiquids = true;
            hasPower = true;
            itemCapacity = 50;
            liquidCapacity = 20;

            consumeItems(with(MTItems.t2Composite, 4, MTItems.depletedThorium, 2, MTItems.tungstenRod, 6));
            consumeLiquid(MTLiquids.heavyFuelOil, 18f / 60f);
            consumePower(19f);
        }};

        //endregion
        //region defence

        int wallHealthMultiplier = 4;

        t1wall = new Wall("t1-wall") {{
            localizedName = "Plastic Composite Wall";
            description = "Lightweight yet sturdy defensive wall made from plastic composite and titanium.";
            requirements(Category.defense, with(MTItems.t1Composite, 4, Items.plastanium, 4));
            health = 125 * wallHealthMultiplier;
            insulated = true;
            absorbLasers = true;
            schematicPriority = 10;
        }};

        t1wallL = new Wall("t1-wall-large") {{
            localizedName = "Large Plastic Composite Wall";
            description = "Larger and tougher variant offering enhanced durability.";
            requirements(Category.defense, ItemStack.mult(t1wall.requirements, 4));
            health = 125 * wallHealthMultiplier * 4;
            size = 2;
            insulated = true;
            absorbLasers = true;
            schematicPriority = 10;
        }};

        t2wall = new Wall("t2-wall") {{
            localizedName = "Titanium Composite Wall";
            description = "Advanced composite wall that combines titanium composite, plastanium, and phase fabric for enhanced defense.";
            requirements(Category.defense, with(MTItems.t2Composite, 6, Items.plastanium, 2, Items.phaseFabric, 2));
            health = 250 * wallHealthMultiplier;
            armor = 20f;
            chanceDeflect = 10f;
            flashHit = true;
            absorbLasers = true;
            schematicPriority = 10;
        }};

        t2wallL = new Wall("t2-wall-large") {{
            localizedName = "Large Titanium Composite Wall";
            description = "A formidable large wall variant offering greater durability and a chance to deflect incoming bullets.";
            requirements(Category.defense, ItemStack.mult(t2wall.requirements, 4));
            health = 250 * wallHealthMultiplier * 4;
            armor = 20f;
            size = 2;
            chanceDeflect = 10f;
            flashHit = true;
            absorbLasers = true;
            schematicPriority = 10;
        }};

        t3wall = new Wall("t3-wall") {{
            localizedName = "MBT Armour Composite Wall";
            description = "Elite composite wall made from MBT armor composite, surge alloy, and phase fabric. It blocks laser damage and has a higher chance to reflect incoming bullets.";
            requirements(Category.defense, with(MTItems.t3Composite, 6, Items.surgeAlloy, 6, Items.phaseFabric, 8));
            health = 800 * wallHealthMultiplier;
            armor = 60f;
            chanceDeflect = 1f;
            flashHit = true;
            absorbLasers = true;
            lightningChance = 0.1f;
            schematicPriority = 10;
        }};

        t3wallL = new Wall("t3-wall-large") {{
            localizedName = "Large MBT Armour Composite Wall";
            description = "The ultimate large wall. It completely blocks laser damage and reflects incoming bullets, making it nearly impervious against most heavy attacks.";
            requirements(Category.defense, ItemStack.mult(t2wall.requirements, 4));
            health = 800 * wallHealthMultiplier * 4;
            armor = 60f;
            size = 2;
            chanceDeflect = 1f;
            flashHit = true;
            absorbLasers = true;
            lightningChance = 0.1f;
            schematicPriority = 10;
        }};

        //endregion
        //region distribution

        ammoBeltS = new MTAmmoBelt("ammo-belt-s", Seq.with(
                ap762, MTItems.ap127, MTItems.he127, MTItems.ap20, MTItems.he20, MTItems.ap35, MTItems.he35, MTItems.apds35
        )) {{
            localizedName = "Ammunition Belt class-S";
            description = "A compact conveyor belt designed to transport small-caliber ammunition efficiently.";
            requirements(Category.distribution, with(MTItems.ironIngot, 1, Items.copper, 1));
            health = 40;
            speed = 8f / 60f;
            itemCapacity = 100;
        }};

        ammoBeltM = new MTAmmoBelt("ammo-belt-m", Seq.with(
                MTItems.ap35, MTItems.he35, MTItems.apds35, MTItems.ap37, MTItems.he37, MTItems.ap50, MTItems.he50, MTItems.ap76, MTItems.he76, MTItems.apds76, MTItems.heatfs76, MTItems.ap90, MTItems.he90, MTItems.apcr90, MTItems.heatfs90
        )) {{
            localizedName = "Ammunition Belt class-M";
            description = "A sturdy conveyor belt built to handle medium-caliber ammunition, from 35mm up to 90mm rounds.";
            requirements(Category.distribution, with(MTItems.ironIngot, 2, Items.copper, 2));
            health = 80;
            speed = 6f / 60f;
            itemCapacity = 50;
        }};

        ammoBeltL = new MTAmmoBelt("ammo-belt-l", Seq.with(
                MTItems.ap105, MTItems.he105, MTItems.apfsds105, MTItems.apfsds2_105, MTItems.heatfs105, MTItems.ap120, MTItems.he120, MTItems.apfsds120, MTItems.apfsds2_120, MTItems.heatfs120, MTItems.he155
        )) {{
            localizedName = "Ammunition Belt class-L";
            description = "Heavy-duty ammo belt designed for the large rounds, efficiently transporting 105mm to 155mm shells with strong durability.";
            requirements(Category.distribution, with(MTItems.ironIngot, 5, Items.copper, 10));
            health = 130;
            speed = 6f / 60f;
            itemCapacity = 25;
        }};

        ammoBeltA = new MTAmmoBelt("ammo-belt-a", Seq.with(
                MTItems.he203, MTItems.he305
        )) {{
            localizedName = "Ammunition Belt class-A/N";
            description = "Heavy-duty ammo belt designed for the largest calibers, efficiently transporting 203mm to 305mm shells with high survivability";
            requirements(Category.distribution, with(MTItems.ironIngot, 5, Items.copper, 10));
            health = 240;
            speed = 3f / 60f;
            itemCapacity = 10;
        }};

        //endregion
        //region power

        dieselGeneratorS = new ConsumeGenerator("diesel-generator-s") {{
            localizedName = "Small Diesel Engine";
            description = "Compact power source, runs on diesel or heavy fuel oil or raw oil. Outputs tar as byproduct from heavy duty oil.";

            requirements(Category.power, with(
                    MTItems.ironIngot, 20,
                    Items.copper, 25,
                    Items.lead, 60
            ));

            size = 1;
            powerProduction = 86f / 60f;
            liquidCapacity = 15f;

            consume(new ConsumeLiquidFilter(
                    liquid -> liquid == Liquids.oil || liquid == MTLiquids.diesel || liquid == MTLiquids.heavyFuelOil,
                    80f / 60f
            ));

            ambientSound = Sounds.hum;
            ambientSoundVolume = 0.01f;
        }};

        dieselGenerator = new ConsumeGenerator("diesel-generator") {{
            localizedName = "Diesel Engine";
            description = "Mid-tier engine, outputs moderate power on both diesel and heavy fuel oil. Highly efficient.";

            requirements(Category.power, with(
                    MTItems.ironIngot, 120,
                    MTItems.aluminiumIngot, 80,
                    Items.copper, 60,
                    Items.lead, 80
            ));

            size = 2;
            powerProduction = 230f / 60f;
            liquidCapacity = 40f;

            consume(new ConsumeLiquidFilter(
                    liquid -> liquid == Liquids.oil || liquid == MTLiquids.diesel || liquid == MTLiquids.heavyFuelOil,
                    0.1f
            ));

            ambientSound = Sounds.hum;
            ambientSoundVolume = 0.02f;
        }};

        locomotiveEngine = new ConsumeGenerator("locomotive-engine") {{
            localizedName = "Locomotive Engine";
            description = "Heavy-duty engine, uses diesel or heavy fuel oil with higher power output.";

            requirements(Category.power, with(
                    MTItems.ironIngot, 400,
                    MTItems.aluminiumIngot, 250,
                    MTItems.steelIngot, 200,
                    Items.copper, 600,
                    Items.lead, 250,
                    Items.silicon, 400,
                    Items.graphite, 300,
                    Items.metaglass, 40
            ));

            size = 4;
            powerProduction = 1550f / 60f;
            liquidCapacity = 200f;

            consume(new ConsumeLiquidFilter(
                    liquid -> liquid == Liquids.oil || liquid == MTLiquids.diesel || liquid == MTLiquids.heavyFuelOil,
                    0.5f
            ));

            ambientSound = Sounds.hum;
            ambientSoundVolume = 0.04f;
        }};

        shipEngine = new ConsumeGenerator("ship-engine") {{
            localizedName = "Ship Engine";
            description = "Massive engine for large ships, uses diesel or heavy fuel oil for extreme power. Requires huge amountsof power for startup.";

            requirements(Category.power, with(
                    MTItems.ironIngot, 400,
                    MTItems.aluminiumIngot, 250,
                    MTItems.steelIngot, 200,
                    Items.copper, 600,
                    Items.lead, 250,
                    Items.silicon, 400,
                    Items.graphite, 300,
                    Items.metaglass, 40
            ));

            size = 8;
            powerProduction = 440f;
            liquidCapacity = 800f;

            consume(new ConsumeLiquidFilter(
                    liquid -> liquid == Liquids.oil || liquid == MTLiquids.diesel || liquid == MTLiquids.heavyFuelOil,
                    5f
            ));
            consumePower(45f);

            ambientSound = Sounds.hum;
            ambientSoundVolume = 0.12f;
        }};

        //endregion
        //region turrets 		m1919a4, m2hb, polsten, m168, oerlikonkda, m6, kwk39, m1, m32, m3, t15e2, m41, t5e1, m68a1e8, m58, m256, m185, mark5508, mark75012;

        m1919a4 = new ItemTurret("m1919a4"){{
            localizedName = "M1919A4 Machinegun Turret";
            description = "Reliable light machine gun turret effective against both air and ground targets. It boasts a fast firing rate and moderate range, ideal for suppressing lightly armored enemies. Requires water or lubricant for enhanced firing speed.";
            requirements(Category.turret, with(
                MTItems.ironIngot, 15,
                    Items.copper, 20 ));
            ammo(
                            MTItems.ap762, new BasicBulletType(3.64f, 1){{
                            lifetime = 110;
                            hitSize = 1;
                            width = 1;
                            height = 2;
                            pierce = true;
                            pierceCap = 1;
                            collidesAir = true;
                            collidesGround = true;
                            hittable = true;
                            reflectable = true;
                            absorbable = true;
                            hitColor = Color.valueOf("ffffffff");
                            lightRadius = 0.8F;
                            lightOpacity = 0.3F;
                            lightColor = Color.valueOf("fbd367ff");
                            ammoMultiplier = 1F;
                        }}
                    );
                    reload = 7.2f;
                    inaccuracy = 2;
                    range = 200;
                    rotateSpeed = 4.5f;
                    maxAmmo = 250;
                    targetAir = true;
                    targetGround = true;

        }

    };}}