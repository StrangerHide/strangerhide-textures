package fr.jielos.strangerhide.api.models.objects.tools;

import fr.jielos.strangerhide.api.models.objects.items.ItemModel;
import org.bukkit.Material;

import javax.annotation.Nonnull;

public class ToolModel extends ItemModel {

    @Nonnull public static final String CATEGORY_NAME = "Outils";

    @Nonnull public static final ToolModel BASEBALL_BAT = new ToolModel("Batte de Baseball", 1);
    @Nonnull public static final ToolModel SLINGSHOT = new ToolModel("Lance-pierres", 2);

    public ToolModel(@Nonnull String name, int id) {
        super(CATEGORY_NAME, Material.GOLDEN_AXE, name, id);
    }

}