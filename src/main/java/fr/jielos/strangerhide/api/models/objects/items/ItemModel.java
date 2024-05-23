package fr.jielos.strangerhide.api.models.objects.items;

import fr.jielos.strangerhide.api.models.objects.ModelObject;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import javax.annotation.Nonnull;

public class ItemModel extends ModelObject<ItemModel> {

    @Nonnull public static final Material MATERIAL = Material.PAPER;

    @Nonnull public static final ItemModel EMPTY = new ItemModel(" ", 1);
    @Nonnull public static final ItemModel BACKWARD = new ItemModel("Retour", 10);

    @Nonnull public static final ItemModel RELOAD = new ItemModel("Rechargement", 11);
    @Nonnull public static final ItemModel UNAVAILABLE = new ItemModel("Indisponible", 12);


    @Nonnull public static final ItemModel CAMERA = new ItemModel("Caméra", 101);
    @Nonnull public static final ItemModel CONTROLLER = new ItemModel("Manette", 102);
    @Nonnull public static final ItemModel DICE = new ItemModel("Dé", 103);

    public ItemModel(@Nonnull String categoryName, @Nonnull Material material, @Nonnull String displayName, int id) {
        super(categoryName, material, displayName, id);
    }

    public ItemModel(@Nonnull String displayName, int id) {
        this("Objets divers", MATERIAL, displayName, id);
    }

    @Nonnull
    public ItemStack toObtainableItem() {
        return toItemBuilder().setDisplayName(ChatColor.WHITE + displayName).setLore("§7Catégorie: §9" + categoryName, "§7Identifiant unique: §9" + id).toItemStack();
    }

}
