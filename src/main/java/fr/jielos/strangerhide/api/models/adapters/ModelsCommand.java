package fr.jielos.strangerhide.api.models.adapters;

import fr.jielos.strangerhide.api.Module;
import fr.jielos.strangerhide.api.commands.CommandAdapter;
import fr.jielos.strangerhide.api.models.objects.characters.CharacterModel;
import fr.jielos.strangerhide.api.models.ModelReference;
import fr.jielos.strangerhide.api.models.ModelsControllers;
import fr.jielos.strangerhide.api.models.objects.ModelObject;
import fr.jielos.strangerhide.api.models.objects.items.ItemModel;
import fr.jielos.strangerhide.utils.minecraft.commands.CommandsUtils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

public class ModelsCommand extends Module<ModelsControllers> implements CommandAdapter {

    public ModelsCommand(@Nonnull ModelsControllers module) {
        super(module);
    }

    @Override
    public boolean onCommandComplete(@Nonnull CommandSender sender, @Nonnull Command command, @Nonnull String label, @Nonnull String[] args) {
        if(args.length >= 1) {
            switch (args[0]) {
                case "give", "disguise" -> {
                    if(args.length >= 2) {
                        @Nullable ModelObject<?> targetModelObject = ModelReference.getModelObjectByName(args[1]);
                        @Nonnull Player targetPlayer = CommandsUtils.getTargetPlayerFromArgs(sender, args, 2);

                        switch (args[0]) {
                            case "give" -> {
                                if(!(targetModelObject instanceof ItemModel itemModel)) throw new IllegalArgumentException("Ce modèle n'est pas récupérable en tant qu'objet !");

                                targetPlayer.getInventory().addItem(itemModel.toObtainableItem());

                                sender.sendMessage(String.format("§r%s §avient de recevoir le modèle suivant: §7%s", targetPlayer.getDisplayName(), itemModel.getDisplayName()));
                            }

                            case "disguise" -> {
                                if(!(targetModelObject instanceof CharacterModel characterModel)) throw new IllegalArgumentException("Ce modèle n'est pas un personnage déguisable !");

                                if(module.isDisguise(targetPlayer)) {
                                    if(module.getDisguise(targetPlayer).getCharacterModel() == characterModel) {
                                        throw new IllegalArgumentException(String.format("%s est déjà déguisé(e) en %s !", targetPlayer.getName(), characterModel.getDisplayName()));
                                    }
                                }

                                module.disguisePlayers(targetPlayer, characterModel);
                                sender.sendMessage(String.format("§r%s §avient de se déguisé(e) en tant que: §7%s", targetPlayer.getDisplayName(), characterModel.getDisplayName()));
                            }
                        }

                        return true;
                    }

                    return false;
                }

                case "undisguise" -> {
                    @Nonnull Player targetPlayer = CommandsUtils.getTargetPlayerFromArgs(sender, args, 1);
                    if(!module.isDisguise(targetPlayer)) throw new IllegalArgumentException(String.format("%s n'est pas déguisé(e) !", targetPlayer.getName()));

                    module.unDisguisePlayers(targetPlayer);
                    sender.sendMessage(String.format("§r%s §avient d'être démasqué(e) !", targetPlayer.getDisplayName()));

                    return true;
                }
            }
        }

        return false;
    }

    @Override
    public List<String> onTabComplete(@Nonnull CommandSender sender, @Nonnull Command command, @Nonnull String label, @Nonnull String[] args) {
        if(args.length >= 1) {
            if(args.length >= 2) {
                if(args.length >= 3) {
                    return null;
                }

                @Nonnull List<String> availableModels = new ArrayList<>();
                switch (args[0]) {
                    case "give" -> availableModels.addAll(ModelReference.getModels(ItemModel.class).keySet());
                    case "disguise" -> availableModels.addAll(ModelReference.getModels(CharacterModel.class).keySet());
                    case "undisguise" -> {
                        return null;
                    }
                }

                return CommandsUtils.getAutoCompletions(args[1], availableModels.toArray(new String[0]));
            }

            return CommandsUtils.getAutoCompletions(args[0], "give", "disguise", "undisguise");
        }

        return CommandAdapter.super.onTabComplete(sender, command, label, args);
    }
}
