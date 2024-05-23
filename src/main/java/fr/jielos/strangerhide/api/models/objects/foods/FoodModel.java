package fr.jielos.strangerhide.api.models.objects.foods;

import fr.jielos.strangerhide.api.models.objects.items.ItemModel;
import org.bukkit.Material;

import javax.annotation.Nonnull;

public class FoodModel extends ItemModel {

    @Nonnull public static final FoodModel ICE_SCREAM_GREEN_RED = new FoodModel("Glace verte et rouge", 1);
    @Nonnull public static final FoodModel ICE_SCREAM_ORANGE_BLUE = new FoodModel("Glace orange et bleue", 2);

    public FoodModel(@Nonnull String name, int id) {
        super("Nourritures", Material.COOKED_BEEF, name, id);
    }

}
