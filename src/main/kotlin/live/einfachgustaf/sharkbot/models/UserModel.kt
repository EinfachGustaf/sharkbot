package live.einfachgustaf.sharkbot.models

import kotlinx.serialization.Serializable

/**
 * The user model.
 *
 * @param id The ID of the user.
 * @param name The name of the user.
 * @param displayName The display name of the user.
 * @param bot Whether the user is a bot.
 */
@Serializable
data class UserModel(
    val id: Long,
    val name: String,
    val displayName: String,
    val bot: Boolean = false
)
