package fr.jielos.strangerhide.api.sounds;

import org.bukkit.Location;
import org.bukkit.SoundCategory;
import org.bukkit.entity.Player;

import javax.annotation.Nonnull;
import java.util.Collection;
import java.util.Objects;

public interface CustomSound {

    @Nonnull String getName();
    @Nonnull SoundCategory getCategory();

    default void playSound(@Nonnull Player player, float volume, float pitch) {
        player.playSound(player.getLocation(), getName(), getCategory(), volume, pitch);
    }

    default void playSound(@Nonnull Collection<? extends Player> players, float volume, float pitch) {
        players.forEach(player -> playSound(player, volume, pitch));
    }

    default void playSound(@Nonnull Location location, float volume, float pitch) {
        Objects.requireNonNull(location.getWorld()).playSound(location, getName(), getCategory(), volume, pitch);
    }

}
