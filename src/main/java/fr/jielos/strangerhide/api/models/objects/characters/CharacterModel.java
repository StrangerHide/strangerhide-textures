package fr.jielos.strangerhide.api.models.objects.characters;

import fr.jielos.strangerhide.api.models.objects.ModelObject;
import org.bukkit.Material;

import javax.annotation.Nonnull;

public class CharacterModel extends ModelObject<CharacterModel> {

    @Nonnull public static CharacterModel DEMOGORGON = new CharacterModel("Démogorgon", 1);

    public CharacterModel(@Nonnull String name, int id) {
        super("Personnages", Material.FIREWORK_STAR, name, id);
    }

}
