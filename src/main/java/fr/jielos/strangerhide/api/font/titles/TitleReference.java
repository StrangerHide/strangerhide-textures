package fr.jielos.strangerhide.api.font.titles;

import fr.jielos.strangerhide.api.font.CustomUnicode;

import javax.annotation.Nonnull;

public enum TitleReference implements CustomUnicode {

    TITLE_SERIES_LOGO("\uD83E\uDF40"),
    TITLE_ONE("\uD83E\uDF45"),
    TITLE_TWO("\uD83E\uDF46"),
    TITLE_THREE("\uD83E\uDF47");

    @Nonnull private final String unicode;

    TitleReference(@Nonnull String unicode) {
        this.unicode = unicode;
    }

    @Nonnull
    @Override
    public String toString() {
        return unicode;
    }

    @Nonnull
    public static CustomUnicode getByInt(int value) {
        if(value == 3) return TITLE_THREE;
        if(value == 2) return TITLE_TWO;

        return TITLE_ONE;
    }

}
