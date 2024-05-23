package fr.jielos.strangerhide.api.models;

import fr.jielos.strangerhide.api.models.objects.ModelObject;
import fr.jielos.strangerhide.api.models.objects.characters.CharacterModel;
import fr.jielos.strangerhide.api.models.objects.foods.FoodModel;
import fr.jielos.strangerhide.api.models.objects.items.ItemModel;
import fr.jielos.strangerhide.api.models.objects.tools.ToolModel;
import lombok.Getter;

import javax.annotation.Nonnull;
import java.util.Arrays;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;

@SuppressWarnings("unchecked")
public enum ModelReference {

    CAMERA(ItemModel.CAMERA),
    CONTROLLER(ItemModel.CONTROLLER),
    DICE(ItemModel.DICE),

    ICE_SCREAM_GREEN_RED(FoodModel.ICE_SCREAM_GREEN_RED),
    ICE_SCREAM_ORANGE_BLUE(FoodModel.ICE_SCREAM_ORANGE_BLUE),

    BASEBALL_BAT(ToolModel.BASEBALL_BAT),
    SLINGSHOT(ToolModel.SLINGSHOT),

    DEMOGORGON(CharacterModel.DEMOGORGON);

    @Getter @Nonnull private final String name;
    @Getter @Nonnull private final ModelObject<?> model;

    ModelReference(@Nonnull ModelObject<?> model) {
        this.name = this.toString().toLowerCase(Locale.ROOT);
        this.model = model;
    }

    @Nonnull
    public static <T extends ModelObject<T>> ModelObject<T> getModelObjectByName(@Nonnull String name) {
        try {
            return (T) valueOf(name.toUpperCase(Locale.ROOT)).getModel();
        } catch (IllegalArgumentException exception) {
            throw new IllegalStateException("Ce modèle n'existe pas, veuillez vous référez à la liste des modèles.");
        }
    }

    @Nonnull
    public static <T extends ModelObject<T>> Map<String, ModelObject<T>> getModels(@Nonnull Class<T> type) {
        return Arrays.stream(values()).filter(e -> type.isAssignableFrom(e.getModel().getClass())).collect(Collectors.toMap(ModelReference::getName, e -> (T) e.getModel()));
    }

}
