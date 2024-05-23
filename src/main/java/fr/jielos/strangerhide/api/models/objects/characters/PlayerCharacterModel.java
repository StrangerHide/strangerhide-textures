package fr.jielos.strangerhide.api.models.objects.characters;

import fr.jielos.strangerhide.api.Module;
import fr.jielos.strangerhide.api.events.ListenerAdapter;
import lombok.Getter;
import org.bukkit.Location;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Player;
import org.bukkit.inventory.EquipmentSlot;

import javax.annotation.Nonnull;

public class PlayerCharacterModel extends Module<Player> implements ListenerAdapter {

    @Getter @Nonnull private final CharacterModel characterModel;
    @Getter @Nonnull private final ArmorStand armorStand;

    public PlayerCharacterModel(@Nonnull Player player, @Nonnull CharacterModel characterModel) {
        super(player);

        this.characterModel = characterModel;
        this.armorStand = createArmorStand(player);

        this.refresh();
    }

    @Nonnull
    public ArmorStand createArmorStand(@Nonnull Player player) {
        @Nonnull final ArmorStand armorStand = player.getWorld().spawn(player.getLocation(), ArmorStand.class);

        armorStand.setInvisible(true);
        armorStand.setInvulnerable(true);
        armorStand.setGravity(false);
        armorStand.setCanPickupItems(false);
        armorStand.setHelmet(characterModel.toItemStack());
        armorStand.addEquipmentLock(EquipmentSlot.HEAD, ArmorStand.LockType.REMOVING_OR_CHANGING);

        return armorStand;
    }

    public void refresh() {
        if(!module.isInvisible()) module.setInvisible(true);
        armorStand.teleport(getLocation());
    }

    public void destroy() {
        armorStand.remove();
        module.setInvisible(false);
    }

    @Nonnull
    public Location getLocation() {
        return module.getLocation();
    }

}
