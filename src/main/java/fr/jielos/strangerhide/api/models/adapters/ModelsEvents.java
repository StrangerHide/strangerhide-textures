package fr.jielos.strangerhide.api.models.adapters;

import fr.jielos.strangerhide.api.Module;
import fr.jielos.strangerhide.api.events.ListenerAdapter;
import fr.jielos.strangerhide.api.models.ModelsControllers;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import javax.annotation.Nonnull;

public class ModelsEvents extends Module<ModelsControllers> implements ListenerAdapter {

    public ModelsEvents(@Nonnull ModelsControllers module) {
        super(module);
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onPlayerMove(@Nonnull PlayerMoveEvent event) {
        @Nonnull Player player = event.getPlayer();

        if(!module.isDisguise(player)) return;
        module.getDisguise(player).refresh();
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onPlayerQuit(@Nonnull PlayerQuitEvent event) {
        module.unDisguisePlayers(event.getPlayer());
    }


}
