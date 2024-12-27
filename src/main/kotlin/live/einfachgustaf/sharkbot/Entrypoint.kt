package live.einfachgustaf.sharkbot

import live.einfachgustaf.sharkbot.utils.dotenv

suspend fun main() {
    val bot = SharkBot(dotenv["BOT_TOKEN"], dotenv["MONGODB_CONNECTION_STRING"], dotenv["MONGODB_DATABASE_NAME"])

    bot.boot()
}