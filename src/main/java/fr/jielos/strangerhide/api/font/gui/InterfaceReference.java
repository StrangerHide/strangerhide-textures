package fr.jielos.strangerhide.api.font.gui;

import fr.jielos.strangerhide.api.font.CustomUnicode;
import org.bukkit.ChatColor;

import javax.annotation.Nonnull;

public enum InterfaceReference implements CustomUnicode {

    GUI_GAME("\uD83E\uDFA0"),
    GUI_MAPS("\uD83E\uDFA1"),
    GUI_SETTINGS("\uD83E\uDFA2"),
    GUI_CHARACTERS("\uD83E\uDFA3");

    @Nonnull private final String unicode;

    InterfaceReference(@Nonnull String unicode) {
        this.unicode = unicode;
    }

    @Nonnull
    @Override
    public String toString() {
        return ChatColor.WHITE.toString() + BLANK_50 + unicode;
    }

}
