package live.einfachgustaf.sharkbot.models

import kotlinx.serialization.Serializable

/**
 * The guild model.
 *
 * @param id The ID of the guild.
 * @param name The name of the guild.
 * @param owner The owner of the guild.
 * @param locale The language/locale of the guild.
 */
@Serializable
data class GuildModel(
    val id: Long,
    val name: String? = null,
    val owner: Long? = null,
    val locale: String = "en_US"
)
