package fr.jielos.strangerhide;

import fr.jielos.strangerhide.api.commands.CommandsController;
import fr.jielos.strangerhide.api.events.EventsController;
import fr.jielos.strangerhide.api.models.ModelsControllers;
import lombok.Getter;
import org.bukkit.plugin.java.JavaPlugin;

public final class StrangerHideTextures extends JavaPlugin {

    @Getter private static StrangerHideTextures instance;

    @Getter private EventsController eventsController;
    @Getter private CommandsController commandsController;

    @Getter private ModelsControllers modelsControllers;

    @Override
    public void onEnable() {
        instance = this;

        this.eventsController = new EventsController(instance).load();
        this.commandsController = new CommandsController(instance).load();

        this.modelsControllers = new ModelsControllers(instance).load();

        this.getLogger().info(this.getName() + " is loaded and ready to use.");
    }

    @Override
    public void onDisable() {
        eventsController.unload();
        commandsController.unload();

        modelsControllers.unload();
    }

}
