package fr.jielos.strangerhide.api.font.images;

import fr.jielos.strangerhide.api.font.CustomUnicode;

import javax.annotation.Nonnull;

public enum ImageReference implements CustomUnicode {

    SERVER_LOGO("\uD83E\uDF10"),
    SERVER_BANNER("\uD83E\uDF11");

    @Nonnull private final String unicode;

    ImageReference(@Nonnull String unicode) {
        this.unicode = unicode;
    }

    @Nonnull
    @Override
    public String toString() {
        return unicode;
    }

}
