package militarytechnology.content;

import arc.graphics.Color;
import mindustry.content.StatusEffects;
import mindustry.type.*;

public class MTLiquids {

    public static Liquid
            diesel, heavyFuelOil, lubricant;

    public static void load() {

        diesel = new Liquid("diesel", Color.valueOf("c0d547")) {{
            localizedName = "Diesel";
            description = "A volatile fuel used in generators and engines.";
            viscosity = 0.55f;
            flammability = 0.8f;
            explosiveness = 1.4f;
            heatCapacity = 0.55f;
            barColor = Color.valueOf("c0d547");
            effect = MTStatusEffects.flammable;
            boilPoint = 0.7f;
            gasColor = Color.grays(0.4f);
            coolant = false;
        }};

        heavyFuelOil = new Liquid("heavy-fuel-oil", Color.valueOf("0a0a09")) {{
            localizedName = "Heavy Fuel Oil";
            description = "Thick, low-flammability industrial fuel with high heat capacity. Best suited for large generators and long-term combustion.";
            viscosity = 0.8f;
            flammability = 0.4f;
            explosiveness = 1f;
            heatCapacity = 0.75f;
            barColor = Color.valueOf("2e2718");
            effect = StatusEffects.tarred;
            boilPoint = 0.8f;
            gasColor = Color.grays(0.6f);
        }};

        lubricant = new Liquid("lubricant", Color.valueOf("c0a25d")) {{
            localizedName = "Lubricant";
            description = "Slick, flammable fluid with excellent heat capacity, used for reducing friction in high-speed machinery.";
            viscosity = 0.65f;
            flammability = 0.8f;
            explosiveness = 1f;
            heatCapacity = 0.8f;
            barColor = Color.valueOf("c0a25d");
            effect = MTStatusEffects.flammable;
            boilPoint = 0.7f;
            gasColor = Color.grays(0.4f);
        }};
    }
}
