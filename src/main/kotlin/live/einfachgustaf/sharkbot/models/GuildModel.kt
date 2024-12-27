package live.einfachgustaf.sharkbot.models

import kotlinx.serialization.Serializable

/**
 * The guild model.
 *
 * @param id The ID of the guild.
 * @param name The name of the guild.
 * @param owner The owner of the guild.
 * @param language The language of the guild.
 */
@Serializable
data class GuildModel(
    val id: Long,
    val name: String? = null,
    val owner: Long? = null,
    val language: String = "en_US"
)
