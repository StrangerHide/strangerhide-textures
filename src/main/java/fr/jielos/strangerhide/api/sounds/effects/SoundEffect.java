package fr.jielos.strangerhide.api.sounds.effects;

import fr.jielos.strangerhide.api.sounds.CustomSound;
import org.bukkit.SoundCategory;

import javax.annotation.Nonnull;

public enum SoundEffect implements CustomSound {

    BREATHLESSNESS("custom.effects.breathlessness", SoundCategory.PLAYERS),
    HEARTBEATS("custom.effects.heartbeats", SoundCategory.PLAYERS),

    DEMOGORGON_FX("custom.effects.demogorgon_fx", SoundCategory.PLAYERS),
    DEMOGORGON_SCREAM( "custom.effects.demogorgon_scream", SoundCategory.PLAYERS),

    WHERE_IS_EVERYONE_HIDING("custom.effects.where_is_everyone_hiding", SoundCategory.PLAYERS);

    @Nonnull private final String name;
    @Nonnull private final SoundCategory category;

    SoundEffect(@Nonnull String name, @Nonnull SoundCategory category) {
        this.name = name;
        this.category = category;
    }

    @Nonnull
    @Override
    public String getName() {
        return name;
    }

    @Nonnull
    @Override
    public SoundCategory getCategory() {
        return category;
    }
}
