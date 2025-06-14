package militarytechnology.content;

import arc.graphics.Color;
import arc.struct.Seq;
import militarytechnology.world.blocks.distribution.MTAmmoBelt;
import mindustry.content.Fx;
import mindustry.content.Items;
import mindustry.content.Liquids;
import mindustry.content.StatusEffects;
import mindustry.entities.bullet.BasicBulletType;
import mindustry.entities.bullet.FlakBulletType;
import mindustry.entities.pattern.ShootAlternate;
import mindustry.gen.Sounds;
import mindustry.graphics.Pal;
import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.type.LiquidStack;
import mindustry.world.Block;
import mindustry.world.blocks.defense.Wall;
import mindustry.world.blocks.defense.turrets.ItemTurret;
import mindustry.world.blocks.environment.OreBlock;
import mindustry.world.blocks.power.ConsumeGenerator;
import mindustry.world.blocks.power.ImpactReactor;
import mindustry.world.blocks.production.AttributeCrafter;
import mindustry.world.blocks.production.GenericCrafter;
import mindustry.world.blocks.production.Separator;
import mindustry.world.consumers.ConsumeLiquidFilter;
import mindustry.world.draw.DrawDefault;
import mindustry.world.draw.DrawFlame;
import mindustry.world.draw.DrawMulti;
import mindustry.world.meta.Attribute;

import multicraft.*;

import static militarytechnology.content.MTItems.*;
import static mindustry.type.ItemStack.with;

public class MTBlocks {
    public static Block

        //ores
        oreIron, oreBauxite, oreTungsten,

        //crafting
        oilRefinery, ironFurnace, ironSmeltery, aluminiumSmeltery, arcFurnace, radioactiveCentrifuge, steelForge,
        casingSmelter, propellantMixer, heMixer, ammoAssembler1, ammoAssembler2, ammoAssembler3, ammoAssemblerA, ammoAssemblerM1,
        ammoAssemblerM2, t1CompositeAssembler, t2CompositeAssembler, t3CompositeAssembler,

        //defence

        ironWall, ironWallL, roadBlock, steelWall, steelWallL, t1wall, t1wallL, t2wall, t2wallL, t3wall, t3wallL,

        //liquid
        pipe, pulsePipe, pipeRouter, pipeJunction, undPipeline,

        //transport
        beltC, beltB, beltA, beltAN,

        //power
        dieselGeneratorS, dieselGenerator, locomotiveEngine, shipEngine,

        //turrets
        m1919a4, m2hb, polsten, m168, oerlikonkda, m6, kwk39, m1, m32, m3, t15e2, m41, t5e1, m68a1e8, m58, m256, m185, mark125508, mark075012,

        //units
        t1TFabricator, t2TFabricator, t3TFabricator, t4TFabricator, t5TFabricator, t6TFabricator, sFabricator;

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

            outputItem = new ItemStack(MTItems.bitumen, 1);
            liquidOutputDirections = new int[]{1, 2, 3};

            size = 3;
            craftTime = 120f;

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

            craftTime = 210f;
            size = 4;
            hasPower = true;
            hasItems = true;
            hasLiquids = true;
            itemCapacity = 50;
            liquidCapacity = 20;
            ambientSound = Sounds.techloop;
            ambientSoundVolume = 0.02f;

            consumeItem(Items.thorium, 4);
            consumeLiquid(Liquids.water, 0.6f);
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
            craftTime = 75f;
            size = 3;
            hasPower = true;
            hasItems = true;
            hasLiquids = true;
            itemCapacity = 100;
            liquidCapacity = 20;

            consumeItems(with(MTItems.aluminiumIngot, 1, Items.lead, 1, Items.copper, 1, Items.silicon, 1));
            consumeLiquid(Liquids.water, 6f / 60f);
            consumePower(160f / 60f);
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

        heMixer = new GenericCrafter("he-mixer"){{
            localizedName = "High-Explosive Mixer";
            description = "Mixes a combination of chemical compounds to create blast compound.";
            requirements(Category.crafting, with(
                    MTItems.ironIngot, 60,
                    Items.copper, 100,
                    Items.lead, 60,
                    Items.silicon, 80
            ));

            craftEffect = Fx.pulverize;
            outputItem = new ItemStack(Items.blastCompound, 2);
            craftTime = 90f;
            size = 2;
            hasPower = true;
            hasItems = true;
            hasLiquids = true;
            itemCapacity = 20;
            liquidCapacity = 10;

            consumeItems(with(bitumen, 2, Items.lead, 1));
            consumeLiquid(Liquids.oil, 4f / 60f);
            consumePower(100f / 60f);
        }};

        ammoAssembler1 = new MultiCrafter("ammo-assembler-1") {{
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
            itemCapacity = 50;
            craftEffect = Fx.pulverize;

            resolvedRecipes = Seq.with(

                    new Recipe(){{
                        input = new IOEntry(
                                Seq.with(ItemStack.with(MTItems.propellant, 1, MTItems.casingAlloy, 2, Items.copper, 1, Items.lead, 2)),
                                Seq.with()
                                );
                        output = new IOEntry(
                                Seq.with(ItemStack.with(MTItems.ap762, 1)),
                                Seq.with()
                        );
                        craftTime = 30f;
                    }},
                    new Recipe(){{
                input = new IOEntry(
                        Seq.with(ItemStack.with(MTItems.propellant, 1, MTItems.casingAlloy, 3, Items.copper, 1, Items.lead, 2)),
                        Seq.with()
                );
                output = new IOEntry(
                        Seq.with(ItemStack.with(MTItems.ap127, 1)),
                        Seq.with()
                );
                craftTime = 60f;
            }},
                    new Recipe(){{
                        input = new IOEntry(
                                Seq.with(ItemStack.with(MTItems.propellant, 1, MTItems.casingAlloy, 3, Items.blastCompound, 1, Items.copper, 1)),
                                Seq.with()
                        );
                        output = new IOEntry(
                                Seq.with(ItemStack.with(MTItems.he127, 1)),
                                Seq.with()
                        );
                        craftTime = 60f;
                    }},
                    new Recipe(){{
                        input = new IOEntry(
                                Seq.with(ItemStack.with(MTItems.propellant, 2, MTItems.casingAlloy, 4, Items.copper, 2, Items.lead, 2)),
                                Seq.with()
                        );
                        output = new IOEntry(
                                Seq.with(ItemStack.with(MTItems.ap20, 1)),
                                Seq.with()
                        );
                        craftTime = 60f;
                    }},
                    new Recipe(){{
                        input = new IOEntry(
                                Seq.with(ItemStack.with(MTItems.propellant, 2, MTItems.casingAlloy, 4, Items.blastCompound, 1, Items.copper, 2)),
                                Seq.with()
                        );
                        output = new IOEntry(
                                Seq.with(ItemStack.with(MTItems.he20, 1)),
                                Seq.with()
                        );
                        craftTime = 60f;
                    }},
                    new Recipe(){{
                        input = new IOEntry(
                                Seq.with(ItemStack.with(MTItems.propellant, 2, MTItems.casingAlloy, 6, Items.copper, 3, Items.lead, 3)),
                                Seq.with()
                        );
                        output = new IOEntry(
                                Seq.with(ItemStack.with(MTItems.ap35, 1)),
                                Seq.with()
                        );
                        craftTime = 60f;
                    }},
                    new Recipe(){{
                        input = new IOEntry(
                                Seq.with(ItemStack.with(MTItems.propellant, 2, MTItems.casingAlloy, 6, Items.blastCompound, 2, Items.copper, 4)),
                                Seq.with()
                        );
                        output = new IOEntry(
                                Seq.with(ItemStack.with(MTItems.he35, 1)),
                                Seq.with()
                        );
                        craftTime = 60f;
                    }});
                    consumePower(40f / 60f);
                }};

        ammoAssembler2 = new MultiCrafter("ammo-assembler-2") {{
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
            itemCapacity = 60;
            craftEffect = Fx.pulverize;

            resolvedRecipes = Seq.with(
                    new Recipe(){{
                        input = new IOEntry(
                                Seq.with(ItemStack.with(MTItems.propellant, 3, MTItems.casingAlloy, 6, MTItems.ironIngot, 1, Items.lead, 3)),
                                Seq.with()
                        );
                        output = new IOEntry(
                                Seq.with(ItemStack.with(MTItems.ap37, 5)),
                                Seq.with()
                        );
                        craftTime = 60f;
                    }},
                    new Recipe(){{
                        input = new IOEntry(
                                Seq.with(ItemStack.with(MTItems.propellant, 2, MTItems.casingAlloy, 6, Items.blastCompound, 1, MTItems.ironIngot, 2)),
                                Seq.with()
                        );
                        output = new IOEntry(
                                Seq.with(ItemStack.with(MTItems.he37, 5)),
                                Seq.with()
                        );
                        craftTime = 60f;
                    }},
                    new Recipe(){{
                        input = new IOEntry(
                                Seq.with(ItemStack.with(MTItems.propellant, 4, MTItems.casingAlloy, 8, MTItems.ironIngot, 2, Items.lead, 5)),
                                Seq.with()
                        );
                        output = new IOEntry(
                                Seq.with(ItemStack.with(MTItems.ap50, 5)),
                                Seq.with()
                        );
                        craftTime = 60f;
                    }},
                    new Recipe(){{
                        input = new IOEntry(
                                Seq.with(ItemStack.with(MTItems.propellant, 3, MTItems.casingAlloy, 8, Items.blastCompound, 3, MTItems.ironIngot, 2)),
                                Seq.with()
                        );
                        output = new IOEntry(
                                Seq.with(ItemStack.with(MTItems.he50, 5)),
                                Seq.with()
                        );
                        craftTime = 60f;
                    }},
                    new Recipe(){{
                        input = new IOEntry(
                                Seq.with(ItemStack.with(MTItems.propellant, 5, MTItems.casingAlloy, 10, MTItems.ironIngot, 3, Items.lead, 6)),
                                Seq.with()
                        );
                        output = new IOEntry(
                                Seq.with(ItemStack.with(MTItems.ap76, 5)),
                                Seq.with()
                        );
                        craftTime = 90f;
                    }},
                    new Recipe(){{
                        input = new IOEntry(
                                Seq.with(ItemStack.with(MTItems.propellant, 4, MTItems.casingAlloy, 10, Items.blastCompound, 4, MTItems.ironIngot, 4)),
                                Seq.with()
                        );
                        output = new IOEntry(
                                Seq.with(ItemStack.with(MTItems.he76, 5)),
                                Seq.with()
                        );
                        craftTime = 90f;
                    }},
                    new Recipe(){{
                        input = new IOEntry(
                                Seq.with(ItemStack.with(MTItems.propellant, 6, MTItems.casingAlloy, 14, MTItems.ironIngot, 5, Items.lead, 6)),
                                Seq.with()
                        );
                        output = new IOEntry(
                                Seq.with(ItemStack.with(MTItems.ap90, 5)),
                                Seq.with()
                        );
                        craftTime = 120f;
                    }},
                    new Recipe(){{
                        input = new IOEntry(
                                Seq.with(ItemStack.with(MTItems.propellant, 5, MTItems.casingAlloy, 14, Items.blastCompound, 8, MTItems.ironIngot, 6)),
                                Seq.with()
                        );
                        output = new IOEntry(
                                Seq.with(ItemStack.with(MTItems.he90, 5)),
                                Seq.with()
                        );
                        craftTime = 120f;
                    }}
            );

            consumePower(1f);
        }};

        ammoAssembler3 = new MultiCrafter("ammo-assembler-3") {{
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
            itemCapacity = 80;
            craftEffect = Fx.pulverize;

            resolvedRecipes = Seq.with(
                    new Recipe(){{
                        input = new IOEntry(
                                Seq.with(ItemStack.with(MTItems.propellant, 12, MTItems.casingAlloy, 20, MTItems.steelIngot, 10)),
                                Seq.with()
                        );
                        output = new IOEntry(
                                Seq.with(ItemStack.with(MTItems.ap105, 5)),
                                Seq.with()
                        );
                        craftTime = 180f;
                    }},
                    new Recipe(){{
                        input = new IOEntry(
                                Seq.with(ItemStack.with(MTItems.propellant, 10, MTItems.casingAlloy, 20, Items.blastCompound, 10, MTItems.steelIngot, 5, MTItems.aluminiumIngot, 2)),
                                Seq.with()
                        );
                        output = new IOEntry(
                                Seq.with(ItemStack.with(MTItems.he105, 5)),
                                Seq.with()
                        );
                        craftTime = 180f;
                    }},
                    new Recipe(){{
                        input = new IOEntry(
                                Seq.with(ItemStack.with(MTItems.propellant, 18, MTItems.casingAlloy, 26, MTItems.steelIngot, 14)),
                                Seq.with()
                        );
                        output = new IOEntry(
                                Seq.with(ItemStack.with(MTItems.ap120, 5)),
                                Seq.with()
                        );
                        craftTime = 210f;
                    }},
                    new Recipe(){{
                        input = new IOEntry(
                                Seq.with(ItemStack.with(MTItems.propellant, 14, MTItems.casingAlloy, 26, Items.blastCompound, 14, MTItems.steelIngot, 8, MTItems.aluminiumIngot, 4)),
                                Seq.with()
                        );
                        output = new IOEntry(
                                Seq.with(ItemStack.with(MTItems.he120, 5)),
                                Seq.with()
                        );
                        craftTime = 210f;
                    }}
            );

            consumePower(1.5f);
        }};

        ammoAssemblerA = new MultiCrafter("ammo-assembler-a") {{
            localizedName = "Artillery Shell Assembler";
            description = "Assembles large to huge artillery ammunition using a lot of materials.";
            requirements(Category.crafting, with(
                    MTItems.ironIngot, 140,
                    Items.copper, 200,
                    Items.silicon, 120
            ));

            size = 4;
            hasPower = true;
            hasItems = true;
            itemCapacity = 160;
            craftEffect = Fx.pulverize;

            resolvedRecipes = Seq.with(
                    new Recipe(){{
                        input = new IOEntry(
                                Seq.with(ItemStack.with(MTItems.propellant, 12, MTItems.casingAlloy, 46, Items.blastCompound, 20, MTItems.ironIngot, 12, Items.copper, 6)),
                                Seq.with()
                        );
                        output = new IOEntry(
                                Seq.with(ItemStack.with(MTItems.he155, 5)),
                                Seq.with()
                        );
                        craftTime = 360f;
                    }},
                    new Recipe(){{
                        input = new IOEntry(
                                Seq.with(ItemStack.with(MTItems.propellant, 18, MTItems.casingAlloy, 60, Items.blastCompound, 28, MTItems.ironIngot, 16, Items.copper, 10)),
                                Seq.with()
                        );
                        output = new IOEntry(
                                Seq.with(ItemStack.with(MTItems.he203, 5)),
                                Seq.with()
                        );
                        craftTime = 480f;
                    }},
                    new Recipe(){{
                        input = new IOEntry(
                                Seq.with(ItemStack.with(MTItems.propellant, 24, MTItems.casingAlloy, 80, Items.blastCompound, 40, MTItems.ironIngot, 21, Items.copper, 18)),
                                Seq.with()
                        );
                        output = new IOEntry(
                                Seq.with(ItemStack.with(MTItems.he305, 5)),
                                Seq.with()
                        );
                        craftTime = 660f;
                    }}
            );

            consumePower(1.5f);
        }};

        ammoAssemblerM1 = new MultiCrafter("ammo-assembler-m1") {{
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
            itemCapacity = 80;
            craftEffect = Fx.pulverize;

            resolvedRecipes = Seq.with(
                    new Recipe(){{
                        input = new IOEntry(
                                Seq.with(ItemStack.with(MTItems.propellant, 3, MTItems.casingAlloy, 6, MTItems.steelIngot, 3, MTItems.aluminiumIngot, 2)),
                                Seq.with()
                        );
                        output = new IOEntry(
                                Seq.with(ItemStack.with(MTItems.apds35, 1)),
                                Seq.with()
                        );
                        craftTime = 180f;
                    }},
                    new Recipe(){{
                        input = new IOEntry(
                                Seq.with(ItemStack.with(MTItems.propellant, 8, MTItems.casingAlloy, 11, MTItems.steelIngot, 6, MTItems.aluminiumIngot, 4)),
                                Seq.with()
                        );
                        output = new IOEntry(
                                Seq.with(ItemStack.with(MTItems.apds76, 5)),
                                Seq.with()
                        );
                        craftTime = 240f;
                    }},
                    new Recipe(){{
                        input = new IOEntry(
                                Seq.with(ItemStack.with(MTItems.propellant, 6, MTItems.casingAlloy, 11, Items.blastCompound, 3, MTItems.aluminiumIngot, 8, Items.copper, 1)),
                                Seq.with()
                        );
                        output = new IOEntry(
                                Seq.with(ItemStack.with(MTItems.heatfs76, 5)),
                                Seq.with()
                        );
                        craftTime = 240f;
                    }},
                    new Recipe(){{
                        input = new IOEntry(
                                Seq.with(ItemStack.with(MTItems.propellant, 10, MTItems.casingAlloy, 16, MTItems.steelIngot, 8, MTItems.ironIngot, 5)),
                                Seq.with()
                        );
                        output = new IOEntry(
                                Seq.with(ItemStack.with(MTItems.apcr90, 5)),
                                Seq.with()
                        );
                        craftTime = 270f;
                    }},
                    new Recipe(){{
                        input = new IOEntry(
                                Seq.with(ItemStack.with(MTItems.propellant, 7, MTItems.casingAlloy, 16, Items.blastCompound, 6, MTItems.aluminiumIngot, 10, Items.copper, 2)),
                                Seq.with()
                        );
                        output = new IOEntry(
                                Seq.with(ItemStack.with(MTItems.heatfs90, 5)),
                                Seq.with()
                        );
                        craftTime = 270f;
                    }},
                    new Recipe(){{
                        input = new IOEntry(
                                Seq.with(ItemStack.with(MTItems.propellant, 14, MTItems.casingAlloy, 22, Items.blastCompound, 10, MTItems.aluminiumIngot, 15, Items.copper, 3)),
                                Seq.with()
                        );
                        output = new IOEntry(
                                Seq.with(ItemStack.with(MTItems.heatfs105, 5)),
                                Seq.with()
                        );
                        craftTime = 300f;
                    }},
                    new Recipe(){{
                        input = new IOEntry(
                                Seq.with(ItemStack.with(MTItems.propellant, 18, MTItems.casingAlloy, 30, Items.blastCompound, 14, MTItems.aluminiumIngot, 18, Items.copper, 5)),
                                Seq.with()
                        );
                        output = new IOEntry(
                                Seq.with(ItemStack.with(MTItems.heatfs120, 5)),
                                Seq.with()
                        );
                        craftTime = 300f;
                    }}
            );

            consumePower(1.5f);
        }};

        ammoAssemblerM2 = new MultiCrafter("ammo-assembler-m2") {{
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
            itemCapacity = 80;
            craftEffect = Fx.pulverize;

            resolvedRecipes = Seq.with(
                    new Recipe(){{
                        input = new IOEntry(
                                Seq.with(ItemStack.with(MTItems.propellant, 20, MTItems.casingAlloy, 22, MTItems.tungstenRod, 5, MTItems.aluminiumIngot, 12)),
                                Seq.with()
                        );
                        output = new IOEntry(
                                Seq.with(ItemStack.with(MTItems.apfsds105, 5)),
                                Seq.with()
                        );
                        craftTime = 270f;
                    }},
                    new Recipe(){{
                        input = new IOEntry(
                                Seq.with(ItemStack.with(MTItems.propellant, 26, MTItems.casingAlloy, 24, MTItems.depletedThorium, 5, MTItems.tungstenRod, 3)),
                                Seq.with()
                        );
                        output = new IOEntry(
                                Seq.with(ItemStack.with(MTItems.apfsds2_105, 5)),
                                Seq.with()
                        );
                        craftTime = 330f;
                    }},
                    new Recipe(){{
                        input = new IOEntry(
                                Seq.with(ItemStack.with(MTItems.propellant, 24, MTItems.casingAlloy, 30, MTItems.tungstenRod, 10, MTItems.aluminiumIngot, 16)),
                                Seq.with()
                        );
                        output = new IOEntry(
                                Seq.with(ItemStack.with(MTItems.apfsds120, 5)),
                                Seq.with()
                        );
                        craftTime = 300f;
                    }},
                    new Recipe(){{
                        input = new IOEntry(
                                Seq.with(ItemStack.with(MTItems.propellant, 30, MTItems.casingAlloy, 32, MTItems.depletedThorium, 10, MTItems.tungstenRod, 6)),
                                Seq.with()
                        );
                        output = new IOEntry(
                                Seq.with(ItemStack.with(MTItems.apfsds2_120, 5)),
                                Seq.with()
                        );
                        craftTime = 360f;
                    }}
            );

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

        ironWall = new Wall("iron-wall"){{
            localizedName = "Iron Wall";
            description = "Sturdy wall made from refined iron.";
            requirements(Category.defense, with(MTItems.ironIngot, 6));
            health = 100 * wallHealthMultiplier;
            schematicPriority = 10;
        }};

        ironWallL = new Wall("iron-wall-l"){{
            localizedName = "Large Iron Wall";
            description = "Large wall made from refined iron.";
            requirements(Category.defense, ItemStack.mult(ironWall.requirements, 4));
            size = 2;
            health = 100 * wallHealthMultiplier * 4;
            schematicPriority = 10;
        }};

        roadBlock = new Wall("road-block"){{
            localizedName = "Roadblock";
            description = "Specialized iron & steel structure designed to block cars, trucks and tanks to advance.";
            requirements(Category.defense, with(ironIngot, 12, steelIngot, 4));
            size = 2;
            health = 250 * wallHealthMultiplier;
            armor = 6f;
        }};

        steelWall = new Wall("steel-wall"){{
            localizedName = "Steel Wall";
            description = "High durability wall made of steel. High hardness increases the chance of deflecting incoming bullets.";
            requirements(Category.defense, with(MTItems.steelIngot, 6));
            health = 180 * wallHealthMultiplier;
            armor = 14f;
            chanceDeflect = 2f;
            schematicPriority = 10;
        }};

        steelWallL = new Wall("steel-wall-l"){{
            localizedName = "Large Steel Wall";
            description = "Larger wall variant made of steel.";
            requirements(Category.defense, ItemStack.mult(ironWall.requirements, 4));
            size = 2;
            health = 180 * wallHealthMultiplier * 4;
            armor = 14f;
            chanceDeflect = 2f;
            schematicPriority = 10;
        }};

        t1wall = new Wall("t1-wall") {{
            localizedName = "Plastic Composite Wall";
            description = "Lightweight yet sturdy defensive wall made from plastic composite and titanium.";
            requirements(Category.defense, with(MTItems.t1Composite, 4, Items.plastanium, 4));
            health = 125 * wallHealthMultiplier;
            insulated = true;
            absorbLasers = true;
            schematicPriority = 10;
        }};

        t1wallL = new Wall("t1-wall-l") {{
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
            chanceDeflect = 4f;
            flashHit = true;
            absorbLasers = true;
            schematicPriority = 10;
        }};

        t2wallL = new Wall("t2-wall-l") {{
            localizedName = "Large Titanium Composite Wall";
            description = "A formidable large wall variant offering greater durability and a chance to deflect incoming bullets.";
            requirements(Category.defense, ItemStack.mult(t2wall.requirements, 4));
            health = 250 * wallHealthMultiplier * 4;
            armor = 20f;
            size = 2;
            chanceDeflect = 4f;
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
            chanceDeflect = 12f;
            flashHit = true;
            absorbLasers = true;
            lightningChance = 0.1f;
            schematicPriority = 10;
        }};

        t3wallL = new Wall("t3-wall-l") {{
            localizedName = "Large MBT Armour Composite Wall";
            description = "The ultimate large wall. It completely blocks laser damage and reflects incoming bullets, making it nearly impervious against most heavy attacks.";
            requirements(Category.defense, ItemStack.mult(t2wall.requirements, 4));
            health = 800 * wallHealthMultiplier * 4;
            armor = 60f;
            size = 2;
            chanceDeflect = 12f;
            flashHit = true;
            absorbLasers = true;
            lightningChance = 0.25f;
            schematicPriority = 10;
        }};

        //endregion
        //region distribution

        beltC = new MTAmmoBelt("ammo-belt-c", Seq.with(
                ap762, MTItems.ap127, MTItems.he127, MTItems.ap20, MTItems.he20, MTItems.ap35, MTItems.he35, MTItems.apds35
        )) {{
            localizedName = "Conveyor Belt class-C";
            description = "An upgraded version of the standard conveyor using iron, cheapest stack-conveyor.";
            requirements(Category.distribution, with(MTItems.ironIngot, 1, Items.copper, 1));
            health = 60;
            speed = 2f / 60f;
            itemCapacity = 10;
        }};

        beltB = new MTAmmoBelt("ammo-belt-b", Seq.with(
                MTItems.ap35, MTItems.he35, MTItems.apds35, MTItems.ap37, MTItems.he37, MTItems.ap50, MTItems.he50, MTItems.ap76, MTItems.he76, MTItems.apds76, MTItems.heatfs76, MTItems.ap90, MTItems.he90, MTItems.apcr90, MTItems.heatfs90
        )) {{
            localizedName = "Ammunition Belt class-B";
            description = "A sturdy conveyor belt built to handle more items.";
            requirements(Category.distribution, with(MTItems.ironIngot, 2, Items.copper, 2));
            health = 120;
            speed = 4f / 60f;
            itemCapacity = 20;
        }};

        beltA = new MTAmmoBelt("ammo-belt-a", Seq.with(
                MTItems.ap105, MTItems.he105, MTItems.apfsds105, MTItems.apfsds2_105, MTItems.heatfs105, MTItems.ap120, MTItems.he120, MTItems.apfsds120, MTItems.apfsds2_120, MTItems.heatfs120, MTItems.he155
        )) {{
            localizedName = "Ammunition Belt class-A";
            description = "Heavy-duty conveyor belt designed for the large amount of items, efficiently transporting large batches of ammunition for turrets.";
            requirements(Category.distribution, with(MTItems.ironIngot, 5, Items.copper, 10));
            health = 240;
            speed = 6f / 60f;
            itemCapacity = 40;
        }};

        beltAN = new MTAmmoBelt("ammo-belt-an", Seq.with(
                MTItems.he203, MTItems.he305
        )) {{
            localizedName = "Ammunition Belt class-A/N";
            description = "Ultimate conveyor, built for heavy defences in the frontlines plus exceptional item capacity.";
            requirements(Category.distribution, with(MTItems.ironIngot, 5, Items.copper, 10, steelIngot, 5));
            health = 480;
            speed = 12f / 60f;
            itemCapacity = 80;
        }};

        //endregion
        //region power

        dieselGeneratorS = new ConsumeGenerator("diesel-generator-s") {{
            localizedName = "Small Diesel Engine";
            description = "Compact power source, runs on diesel or heavy fuel oil or raw oil.";

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
                    8f / 60f
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
                    MTItems.ironIngot, 200,
                    MTItems.aluminiumIngot, 150,
                    MTItems.steelIngot, 100,
                    Items.copper, 400,
                    Items.lead, 200,
                    Items.silicon, 130,
                    Items.graphite, 220,
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

        shipEngine = new ImpactReactor("ship-engine") {{
            localizedName = "Ship Engine";
            description = "Massive engine for large ships, uses diesel or heavy fuel oil for extreme power. Requires huge amountsof power for startup.";

            requirements(Category.power, with(
                    MTItems.ironIngot, 750,
                    MTItems.steelIngot, 1000,
                    Items.copper, 900,
                    Items.lead, 500,
                    Items.silicon, 800,
                    Items.graphite, 400,
                    Items.plastanium, 300,
                    Items.titanium, 400,
                    MTItems.t1Composite, 250
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
            description = "Reliable light machine gun turret effective against both air and ground targets. It boasts a fast firing rate and moderate range, ideal for suppressing lightly armored enemies.";
            requirements(Category.turret, with(
                MTItems.ironIngot, 15,
                    Items.copper, 20 ));
            ammo(
                            MTItems.ap762, new BasicBulletType(4f, 4){{
                            lifetime = 80;
                            buildingDamageMultiplier = 0.15f;
                            hitSize = 1;
                            width = 1;
                            height = 2;
                            collidesAir = true;
                            collidesGround = true;
                            hittable = true;
                            reflectable = true;
                            absorbable = true;
                            hitColor = Color.valueOf("ffffffff");
                            lightRadius = 0.8F;
                            lightOpacity = 0.3F;
                            lightColor = Color.valueOf("fbd367ff");
                            ammoMultiplier = 10F;
                        }}
                    );
                    reload = 7.2f;
                    inaccuracy = 2;
                    range = 200;
                    rotateSpeed = 4.5f;
                    maxAmmo = 250;
                    targetAir = true;
                    targetGround = true;

        }};

        m2hb = new ItemTurret("m2hb"){{
            localizedName = "M2HB .50cal Turret";
            description = "Heavy machine gun turret with improved damage and range over lighter models. Effective against both air and ground units, with armor-piercing and explosive rounds for versatility.";
            requirements(Category.turret, with(
                    MTItems.ironIngot, 40,
                    Items.copper, 20 ));
            ammo(
                    MTItems.ap127, new BasicBulletType(4.25f, 17){{
                        lifetime = 100f;
                        buildingDamageMultiplier = 0.15f;
                        hitSize = 1;
                        width = 1;
                        height = 3;
                        collidesAir = true;
                        collidesGround = true;
                        hittable = true;
                        reflectable = true;
                        absorbable = true;
                        hitColor = Color.valueOf("ffffffff");
                        lightRadius = 0.8F;
                        lightOpacity = 0.3F;
                        lightColor = Color.valueOf("fbd367ff");
                        ammoMultiplier = 10F;
                    }},

                    MTItems.he127, new FlakBulletType(4.2f, 5){
                        {
                            lifetime = 100f;
                            splashDamage = 3f;
                            splashDamageRadius = 6f;
                            explodeRange = 4f;
                            buildingDamageMultiplier = 0.15f;
                            scaledSplashDamage = true;
                            knockback = 0.18f;
                            hitSize = 1f;
                            width = 1f;
                            height = 3f;
                            status = StatusEffects.blasted;
                            statusDuration = 120f;
                            collidesAir = true;
                            collidesGround = true;
                            hittable = true;
                            reflectable = true;
                            absorbable = true;
                            hitColor = Color.valueOf("ffa637ff");
                            lightRadius = 0.8f;
                            lightOpacity = 0.3f;
                            lightColor = Color.valueOf("ffa637ff");
                            fragBullet = new BasicBulletType(4f, 1) {{
                                width = 1f;
                                height = 2f;
                                lifetime = 1f;
                                backColor = Pal.gray;
                                frontColor = Color.white;
                                despawnEffect = Fx.none;
                            }};
                            fragBullets = 3;
                            fragRandomSpread = 270f;
                            fragVelocityMin = 3.6f;
                            fragVelocityMax = 7.2f;
                            ammoMultiplier = 10F;
                        }});
            reload = 6.5f;
            inaccuracy = 2;
            range = 280;
            rotateSpeed = 6f;
            maxAmmo = 300;
            targetAir = true;
            targetGround = true;
        }};

        polsten = new ItemTurret("polsten"){{
            localizedName = "20mm Polsten";
            description = "Anti-air autocannon with moderate damage and explosive capability. Uses 20mm AP and HE rounds.";
            size = 2;
            requirements(Category.turret, with(
                    MTItems.ironIngot, 100,
                    Items.copper, 60,
                    Items.graphite, 50
            ));
            ammo(
                    MTItems.ap20, new BasicBulletType(4.2f, 32){{
                        lifetime = 100f;
                        buildingDamageMultiplier = 0.15f;
                        hitSize = 2f;
                        width = 2f;
                        height = 5f;
                        collidesAir = true;
                        collidesGround = false;
                        hittable = true;
                        reflectable = true;
                        absorbable = true;
                        hitColor = Color.valueOf("ffffffff");
                        lightRadius = 1f;
                        lightOpacity = 0.3f;
                        lightColor = Color.valueOf("fbd367ff");
                        ammoMultiplier = 10F;
                    }},

                    MTItems.he20, new FlakBulletType(3.8f, 9){{
                        lifetime = 100f;
                        splashDamage = 10f;
                        splashDamageRadius = 6f;
                        explodeRange = 8f;
                        buildingDamageMultiplier = 0.15f;
                        scaledSplashDamage = true;
                        knockback = 0.1f;
                        hitSize = 2f;
                        width = 2f;
                        height = 5f;
                        status = StatusEffects.blasted;
                        statusDuration = 240f;
                        collidesAir = true;
                        collidesGround = false;
                        hittable = true;
                        reflectable = true;
                        absorbable = true;
                        hitColor = Color.valueOf("ffa637ff");
                        lightRadius = 1f;
                        lightOpacity = 0.35f;
                        lightColor = Color.valueOf("ffa637ff");
                        fragBullet = new BasicBulletType(5f, 3){{
                            width = 1f;
                            height = 2f;
                            lifetime = 1f;
                            backColor = Pal.gray;
                            frontColor = Color.white;
                            despawnEffect = Fx.none;
                        }};
                        fragBullets = 3;
                        fragRandomSpread = 360f;
                        fragVelocityMin = 3.8f;
                        fragVelocityMax = 7.6f;
                        ammoMultiplier = 10F;
                    }}
            );

            shoot = new ShootAlternate(4f + 3f);
            reload = 4f;
            inaccuracy = 3f;
            range = 320f;
            rotateSpeed = 3f;
            maxAmmo = 200;
            targetAir = true;
            targetGround = false;
        }};

        m168 = new ItemTurret("m168"){{
            localizedName = "20mm M168";
            description = "High-rate autocannon capable of targeting air, ground, and incoming projectiles. Uses AP and HE rounds. Cooled in bursts to prevent overheating.";
            size = 2;
            requirements(Category.turret, with(
                    MTItems.ironIngot, 120,
                    MTItems.aluminiumIngot, 50,
                    Items.titanium, 60
            ));

            ammo(
                    MTItems.ap20, new BasicBulletType(5f, 44){{
                        lifetime = 120f;
                        buildingDamageMultiplier = 0.15f;
                        hitSize = 2f;
                        width = 2f;
                        height = 5f;
                        collidesAir = true;
                        collidesGround = true;
                        hittable = true;
                        reflectable = true;
                        absorbable = true;
                        hitColor = Color.valueOf("ffffffff");
                        lightRadius = 1f;
                        lightOpacity = 0.3f;
                        lightColor = Color.valueOf("fbd367ff");
                        ammoMultiplier = 10F;
                    }},

                    MTItems.he20, new FlakBulletType(4.6f, 11){{
                        lifetime = 120f;
                        splashDamage = 10f;
                        splashDamageRadius = 6f;
                        explodeRange = 8f;
                        buildingDamageMultiplier = 0.15f;
                        scaledSplashDamage = true;
                        knockback = 0.23f;
                        hitSize = 2f;
                        width = 2f;
                        height = 5f;
                        status = StatusEffects.blasted;
                        statusDuration = 240f;
                        collidesAir = true;
                        collidesGround = true;
                        hittable = true;
                        reflectable = true;
                        absorbable = true;
                        hitColor = Color.valueOf("ffa637ff");
                        lightRadius = 1f;
                        lightOpacity = 0.35f;
                        lightColor = Color.valueOf("ffa637ff");

                        fragBullets = 4;
                        fragRandomSpread = 360f;
                        fragVelocityMin = 4.6f;
                        fragVelocityMax = 9.2f;
                        fragBullet = new BasicBulletType(4f, 3){{
                            width = 3f;
                            height = 8f;
                            lifetime = 1f;
                            backColor = Pal.gray;
                            frontColor = Color.white;
                            despawnEffect = Fx.none;
                        }};
                        ammoMultiplier = 10F;
                    }}
            );
            reload = 1.2f;
            inaccuracy = 5f;
            range = 400f;
            rotateSpeed = 1f;
            maxAmmo = 1200;
            targetAir = true;
            targetGround = true;
            consumePower(0.6f);
        }};

        oerlikonkda = new ItemTurret("oerlikonkda"){{
            localizedName = "35mm OerlikonKDA Anti-Air-Defence-System";
            description = "Dedicated anti-air autocannon with versatile ammo options for engaging air and ground targets. High damage APDS rounds excel against armored ground units, while HE and AP rounds provide effective area suppression of fast-moving aerial threats.";
            size = 3;
            requirements(Category.turret, with(
                    MTItems.t1Composite, 120,
                    Items.silicon, 200,
                    Items.titanium, 300,
                    Items.copper, 180,
                    Items.metaglass, 90,
                    steelIngot, 180,
                    ironIngot, 200
            ));
            ammo(
                    MTItems.ap35, new BasicBulletType(6.25f, 143){{
                        lifetime = 150f;
                        buildingDamageMultiplier = 0.15f;
                        hitSize = 3.5f;
                        width = 3.5f;
                        height = 8f;
                        collidesAir = true;
                        collidesGround = true;
                        hittable = true;
                        reflectable = true;
                        absorbable = true;
                        pierce = true;
                        pierceCap = 1;
                        hitColor = Color.valueOf("ffffffff");
                        lightRadius = 1f;
                        lightOpacity = 0.3f;
                        lightColor = Color.valueOf("fbd367ff");
                        ammoMultiplier = 10F;
                    }},

                    MTItems.he35, new FlakBulletType(6f, 21){
                        {
                            lifetime = 150f;
                            splashDamage = 61f;
                            splashDamageRadius = 8f;
                            explodeRange = 8f;
                            buildingDamageMultiplier = 0.15f;
                            scaledSplashDamage = true;
                            knockback = 0.23f;
                            hitSize = 2f;
                            width = 2f;
                            height = 5f;
                            status = StatusEffects.blasted;
                            statusDuration = 240f;
                            collidesAir = true;
                            collidesGround = true;
                            hittable = true;
                            reflectable = true;
                            absorbable = true;
                            hitColor = Color.valueOf("ffa637ff");
                            lightRadius = 1f;
                            lightOpacity = 0.35f;
                            lightColor = Color.valueOf("ffa637ff");

                            fragBullets = 4;
                            fragRandomSpread = 360f;
                            fragVelocityMin = 6f;
                            fragVelocityMax = 12f;

                            fragBullet = new BasicBulletType(6f, 5) {{
                                width = 3f;
                                height = 8f;
                                lifetime = 1f;
                                backColor = Pal.gray;
                                frontColor = Color.white;
                                despawnEffect = Fx.none;
                            }};
                            ammoMultiplier = 10F;
                        }},

                    MTItems.apds35, new BasicBulletType(7f, 311){{
                        lifetime = 150f;
                        buildingDamageMultiplier = 0.15f;
                        hitSize = 3.5f;
                        width = 3.5f;
                        height = 8f;
                        collidesAir = true;
                        collidesGround = true;
                        hittable = true;
                        reflectable = true;
                        absorbable = true;
                        pierce = true;
                        pierceArmor = true;
                        pierceBuilding = true;
                        pierceCap = 1;
                        hitColor = Color.valueOf("ffffff");
                        lightRadius = 1f;
                        lightOpacity = 0.3f;
                        lightColor = Color.valueOf("03dbfc");
                        ammoMultiplier = 3F;
                    }});
            maxAmmo = 320;
            targetAir = true;
            targetGround = true;
            recoil = 2f;
            range = 480f;
            inaccuracy = 1;
            rotateSpeed = 8f;
            reload = 3.25f;
            shoot = new ShootAlternate(16f);

            consumePower(1.2f);
        }};

        m6 = new ItemTurret("m6"){{
            localizedName = "37mm M6";
            description = "Early-game ground turret, great for initial defense with precise, hard-hitting rounds. Best replaced later as stronger options become available.";
            size = 2;
            requirements(Category.turret, with(
                    MTItems.ironIngot, 20,
                    Items.copper, 30,
                    Items.lead, 50,
                    Items.graphite, 20
            ));

            ammo(
                    MTItems.ap37, new BasicBulletType(4.44f, 142){{
                        lifetime = 150f;
                        buildingDamageMultiplier = 0.15f;
                        hitSize = 4f;
                        width = 4f;
                        height = 10f;
                        collidesAir = true;
                        collidesGround = true;
                        hittable = true;
                        reflectable = true;
                        absorbable = true;
                        pierce = true;
                        hitColor = Color.valueOf("ffffffff");
                        lightRadius = 1f;
                        lightOpacity = 0.3f;
                        lightColor = Color.valueOf("fbd367ff");
                        ammoMultiplier = 1F;
                    }},

                    MTItems.he37, new FlakBulletType(4.3f, 16){{
                        lifetime = 120f;
                        splashDamage = 70f;
                        splashDamageRadius = 8f;
                        explodeRange = 8f;
                        buildingDamageMultiplier = 0.15f;
                        scaledSplashDamage = true;
                        knockback = 0.23f;
                        hitSize = 4f;
                        width = 4f;
                        height = 10f;
                        status = StatusEffects.blasted;
                        statusDuration = 240f;
                        collidesAir = true;
                        collidesGround = true;
                        hittable = true;
                        reflectable = true;
                        absorbable = true;
                        hitColor = Color.valueOf("ffa637ff");
                        lightRadius = 1f;
                        lightOpacity = 0.35f;
                        lightColor = Color.valueOf("ffa637ff");

                        fragBullets = 4;
                        fragRandomSpread = 360f;
                        fragVelocityMin = 4.3f;
                        fragVelocityMax = 8.6f;
                        fragBullet = new BasicBulletType(4.3f, 4){{
                            width = 3f;
                            height = 8f;
                            lifetime = 1f;
                            backColor = Pal.gray;
                            frontColor = Color.white;
                            despawnEffect = Fx.none;
                        }};
                        ammoMultiplier = 1F;
                    }}
            );
            reload = 180f;
            inaccuracy = 2f;
            range = 320f;
            rotateSpeed = 1f;
            maxAmmo = 18;
            targetAir = true;
            targetGround = true;
        }};
    }}