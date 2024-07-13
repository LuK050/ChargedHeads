package ru.luk.chargedheads.listener

import org.bukkit.Material
import org.bukkit.entity.Creeper
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.entity.EntityDamageByEntityEvent
import org.bukkit.event.entity.PlayerDeathEvent
import org.bukkit.inventory.ItemStack
import org.bukkit.inventory.meta.SkullMeta

class PlayerDiedFromChargedCreeperListener : Listener {
    @EventHandler
    fun onPlayerDiedFromChargedCreeper(event: PlayerDeathEvent) {
        val lastDamageCause = event.player.lastDamageCause ?: return

        if (lastDamageCause !is EntityDamageByEntityEvent) {
            return
        }

        if (lastDamageCause.damager is Creeper && (lastDamageCause.damager as Creeper).isPowered) {
            event.drops.add(
                ItemStack(Material.PLAYER_HEAD).apply {
                    val headMeta = itemMeta as SkullMeta
                    headMeta.owningPlayer = event.player
                    itemMeta = headMeta
                }
            )
        }
    }
}