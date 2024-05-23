package fr.jielos.strangerhide.api.font.flags;

import fr.jielos.strangerhide.api.font.CustomUnicode;

import javax.annotation.Nonnull;

public enum FlagReference implements CustomUnicode {

    FLAG_AVAILABLE("\uD83E\uDF50"),
    FLAG_RELOADING("\uD83E\uDF51"),
    FLAG_UNAVAILABLE("\uD83E\uDF52");

    @Nonnull private final String unicode;

    FlagReference(@Nonnull String unicode) {
        this.unicode = unicode;
    }

    @Nonnull
    @Override
    public String toString() {
        return unicode;
    }

}
