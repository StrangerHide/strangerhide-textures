package fr.jielos.strangerhide.api.models.objects;

import fr.jielos.strangerhide.utils.minecraft.inventories.items.ItemBuilder;
import lombok.Getter;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import javax.annotation.Nonnull;

public abstract class ModelObject<T extends ModelObject<T>> {

    @Getter @Nonnull protected final String categoryName;
    @Getter @Nonnull protected final Material material;

    @Getter @Nonnull protected final String displayName;
    @Getter protected int id;

    @Getter @Nonnull protected final ItemBuilder<?> itemBuilder;

    public ModelObject(@Nonnull String categoryName, @Nonnull Material material, @Nonnull String displayName, int id) {
        this.categoryName = categoryName;
        this.material = material;

        this.displayName = displayName;
        this.id = id;

        this.itemBuilder = new ItemBuilder<>(material).setCustomModelData(id);
    }

    @Nonnull
    public ItemBuilder<?> toItemBuilder() {
        return new ItemBuilder<>(itemBuilder.toItemStack());
    }

    @Nonnull
    public ItemStack toItemStack() {
        return new ItemStack(itemBuilder.toItemStack());
    }

}
