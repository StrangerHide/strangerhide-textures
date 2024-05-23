package fr.jielos.strangerhide.api.font.icons;

import fr.jielos.strangerhide.api.font.CustomUnicode;

import javax.annotation.Nonnull;

public enum IconReference implements CustomUnicode {

    ICON_MOUSE_LEFT_CLICK("\uD83E\uDF20"),
    ICON_MOUSE_RIGHT_CLICK("\uD83E\uDF21"),
    ICON_LINK("\uD83E\uDF22"),
    ICON_GEAR("\uD83E\uDF23"),
    ICON_STATS("\uD83E\uDF24"),
    ICON_DISCORD("\uD83E\uDF25"),
    ICON_CURSOR_RIGHT("\uD83E\uDF26");

    @Nonnull private final String unicode;

    IconReference(@Nonnull String unicode) {
        this.unicode = unicode;
    }

    @Nonnull
    @Override
    public String toString() {
        return unicode;
    }
}
