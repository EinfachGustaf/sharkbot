package live.einfachgustaf.sharkbot.api

import dev.kord.core.entity.Guild
import live.einfachgustaf.sharkbot.models.GuildModel

class SharkGuild(
    val guild: Guild,
    val info: GuildModel
)