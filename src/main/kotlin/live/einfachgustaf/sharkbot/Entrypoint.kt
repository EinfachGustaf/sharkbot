package live.einfachgustaf.sharkbot

import live.einfachgustaf.sharkbot.utils.dotenv

val bot = SharkBot(dotenv["BOT_TOKEN"], dotenv["MONGODB_CONNECTION_STRING"], dotenv["MONGODB_DATABASE_NAME"])

suspend fun main() {
    bot.boot()
}