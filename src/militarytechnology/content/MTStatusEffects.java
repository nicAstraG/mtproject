package militarytechnology.content;

import arc.graphics.Color;
import mindustry.content.Fx;
import mindustry.content.StatusEffects;
import mindustry.type.*;

public class MTStatusEffects {

    public static StatusEffect flammable, overpressured1, overpressured2, overpressured3;

    public static void load() {

        flammable = new StatusEffect("flammable") {{
            localizedName = "Flammable";
            description = "If exposed to fire, it will ignite and burn over time.";
            color = Color.valueOf("636e27");
            permanent = true;
            effect = Fx.oily;

            affinity(StatusEffects.melting, (unit, result, time) -> result.set(StatusEffects.burning, result.time + time));
            affinity(StatusEffects.burning, (unit, result, time) -> result.set(StatusEffects.burning, result.time + time));
            affinity(StatusEffects.shocked, (unit, result, time) -> result.set(StatusEffects.burning, result.time + time));
            affinity(StatusEffects.electrified, (unit, result, time) -> result.set(StatusEffects.burning, result.time + time));

            opposites.add(StatusEffects.wet);
            opposites.add(StatusEffects.freezing);
        }};

        overpressured1 = new StatusEffect("overpressure-stunned-i") {{
            localizedName = "Overpressure Stun I";
            description = "A mild shockwave disrupts stability, slowing movement and reducing firing precision.";
            speedMultiplier = 0.95f;
            reloadMultiplier = 0.95f;
        }};

        overpressured2 = new StatusEffect("overpressure-stunned-ii") {{
            localizedName = "Overpressure Stun II";
            description = "A heavy concussive blast disrupts coordination, making movement sluggish and aim erratic.";
            speedMultiplier = 0.75f;
            reloadMultiplier = 0.75f;
        }};

        overpressured3 = new StatusEffect("overpressure-stunned-iii") {{
            localizedName = "Overpressure Stun III";
            description = "A violent shockwave overwhelms motor function, nearly halting movement and suppressing response.";
            speedMultiplier = 0.55f;
            reloadMultiplier = 0.45f;
        }};
    }
}