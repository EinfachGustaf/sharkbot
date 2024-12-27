package live.einfachgustaf.sharkbot.api

import dev.kord.core.entity.User
import live.einfachgustaf.sharkbot.models.UserModel

/**
 * The SharkUser class.
 *
 * @param user The user.
 * @param info The user info.
 */
class SharkUser(
    val user: User,
    val info: UserModel
)