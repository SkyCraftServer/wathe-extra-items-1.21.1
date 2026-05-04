package sir.nicholascooke.watheextraitems.api;

import net.minecraft.entity.player.PlayerEntity;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public final class SmokingTracker {

    private static final Map<UUID, Integer> SMOKE_COUNTS = new HashMap<>();

    private SmokingTracker() {
    }

    public static int getSmokeCount(PlayerEntity player) {
        return SMOKE_COUNTS.getOrDefault(player.getUuid(), 0);
    }

    public static void incrementSmokeCount(PlayerEntity player) {
        SMOKE_COUNTS.merge(player.getUuid(), 1, Integer::sum);
    }

    public static void setSmokeCount(PlayerEntity player, int count) {
        SMOKE_COUNTS.put(player.getUuid(), count);
    }

    public static void resetSmokeCount(PlayerEntity player) {
        SMOKE_COUNTS.remove(player.getUuid());
    }
}
