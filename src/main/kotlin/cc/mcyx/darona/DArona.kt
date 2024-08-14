package cc.mcyx.darona

import cc.mcyx.arona.core.listener.annotation.Listener
import cc.mcyx.arona.core.listener.annotation.SubscribeEvent
import cc.mcyx.arona.core.plugin.AronaPlugin
import org.bukkit.entity.Player
import org.bukkit.event.inventory.InventoryOpenEvent

@Listener
class DArona : AronaPlugin() {
    override fun onEnabled() {
        println("qws")
    }

    @SubscribeEvent
    fun qwq(inventoryOpenEvent: InventoryOpenEvent) {
        val player = inventoryOpenEvent.player as Player

    }
}