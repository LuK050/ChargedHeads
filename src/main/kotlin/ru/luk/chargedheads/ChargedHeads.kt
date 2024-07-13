package ru.luk.chargedheads
import ru.luk.chargedheads.listener.PlayerDiedFromChargedCreeperListener

import org.bukkit.Bukkit
import org.bukkit.plugin.java.JavaPlugin

class ChargedHeads : JavaPlugin() {
    companion object {
        lateinit var plugin: ChargedHeads
    }

    override fun onEnable() {
        plugin = this

        Bukkit.getPluginManager().registerEvents(PlayerDiedFromChargedCreeperListener(), this)
    }
}