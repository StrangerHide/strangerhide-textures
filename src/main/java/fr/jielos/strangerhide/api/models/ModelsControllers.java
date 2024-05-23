package fr.jielos.strangerhide.api.models;

import fr.jielos.strangerhide.StrangerHideTextures;
import fr.jielos.strangerhide.api.Controller;
import fr.jielos.strangerhide.PluginComponent;
import fr.jielos.strangerhide.api.models.adapters.ModelsCommand;
import fr.jielos.strangerhide.api.models.adapters.ModelsEvents;
import fr.jielos.strangerhide.api.models.objects.characters.CharacterModel;
import fr.jielos.strangerhide.api.models.objects.characters.PlayerCharacterModel;
import org.bukkit.entity.Player;

import javax.annotation.Nonnull;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class ModelsControllers extends PluginComponent<StrangerHideTextures> implements Controller<ModelsControllers> {

    @Nonnull private final Map<Player, PlayerCharacterModel> disguises;

    public ModelsControllers(@Nonnull StrangerHideTextures instance) {
        super(instance);

        this.disguises = new HashMap<>();

        this.instance.getCommandsController().registerCommandAdapter("models", new ModelsCommand(this));
        this.instance.getEventsController().registerEventAdapter(new ModelsEvents(this));
    }

    @Override
    public void unload() {
        this.unDisguisePlayers(server.getOnlinePlayers());
    }

    public void disguisePlayers(@Nonnull Player player, @Nonnull CharacterModel characterModel) {
        if(disguises.containsKey(player)) unDisguisePlayers(player);

        @Nonnull final PlayerCharacterModel playerCharacterModel = new PlayerCharacterModel(player, characterModel);
        disguises.put(player, playerCharacterModel);
    }

    public void disguisePlayers(@Nonnull Collection<? extends Player> players, @Nonnull CharacterModel characterModel) {
       players.forEach(player -> disguisePlayers(player, characterModel));
    }

    public void unDisguisePlayers(@Nonnull Player player) {
        if(!disguises.containsKey(player)) return;

        disguises.get(player).destroy();
        disguises.remove(player);
    }

    public void unDisguisePlayers(@Nonnull Collection<? extends Player> players) {
        players.forEach(this::unDisguisePlayers);
    }

    public boolean isDisguise(@Nonnull Player player) {
        return disguises.containsKey(player);
    }

    @Nonnull
    public PlayerCharacterModel getDisguise(@Nonnull Player player) {
        if(!isDisguise(player)) throw new IllegalStateException(String.format("%s is not disguise !", player.getDisplayName()));
        return disguises.get(player);
    }

}
