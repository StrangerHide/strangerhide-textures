package fr.jielos.strangerhide.api.font.tags;

import fr.jielos.strangerhide.api.font.CustomUnicode;

import javax.annotation.Nonnull;

public enum TagReference implements CustomUnicode {

    TAG_VOTED("\uD83E\uDF30"),
    TAG_NEW("\uD83E\uDF31");

    @Nonnull private final String unicode;

    TagReference(@Nonnull String unicode) {
        this.unicode = unicode;
    }

    @Nonnull
    @Override
    public String toString() {
        return unicode;
    }

}
