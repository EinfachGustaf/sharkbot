package live.einfachgustaf.sharkbot.api

import dev.kord.core.entity.User
import live.einfachgustaf.sharkbot.models.UserModel

class SharkUser(
    val user: User,
    val info: UserModel
)