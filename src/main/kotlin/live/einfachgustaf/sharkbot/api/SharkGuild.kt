package live.einfachgustaf.sharkbot.api

import dev.kord.core.entity.Guild
import live.einfachgustaf.sharkbot.models.GuildModel

/**
 * The SharkGuild class.
 *
 * @param guild The guild.
 * @param info The guild info.
 */
class SharkGuild(
    val guild: Guild,
    val info: GuildModel
)