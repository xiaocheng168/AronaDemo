package cc.mcyx.darona

import cc.mcyx.arona.core.command.annotation.Command
import cc.mcyx.arona.core.command.annotation.CommandEvent
import cc.mcyx.arona.core.command.event.CommandExecutor
import cc.mcyx.arona.core.command.event.CommandTabExecutor

@Command("halo", permission = "cc.mcyx.darona.halo", noPermission = "没有权限呢?")
class Command {
    @CommandEvent
    fun halo(command: CommandExecutor) {
        command.commandSender.sendMessage("你好!")
    }

    @CommandEvent
    fun halo(tabExecutor: CommandTabExecutor) {
        tabExecutor.callbacks = listOf("1", "2", "3", "4", "5", "6", "7", "8")
    }
}