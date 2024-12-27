package live.einfachgustaf.sharkbot

import dev.kord.core.Kord
import dev.kordex.core.ExtensibleBot
import live.einfachgustaf.sharkbot.db.MongoConnector
import live.einfachgustaf.sharkbot.utils.logger

/**
 * The SharkBot class.
 *
 * @param token The token for the bot.
 * @param mongoConnectionString The connection string for the MongoDB database.
 */
class SharkBot(private val token: String, private val mongoConnectionString: String, mongoDatabaseName: String) {

    /**
     * The Mongo connector.
     */
    val mongoConnector = MongoConnector(mongoConnectionString, mongoDatabaseName)

    /**
     * The Kord object used for accessing the discord api
     */
    lateinit var kord: Kord; private set

    /**
     * The bot object used for extending the bot
     */
    lateinit var bot: ExtensibleBot; private set

    /**
     * Boot the bot.
     *
     * @param postInitialize The function to run after the bot has been initialized (pre start).
     */
    suspend fun boot(
        postInitialize: suspend SharkBot.() -> Unit = {}
    ) {
        logger.info { "Booting the bot..." }
        bot = ExtensibleBot(token) {
            presence {
                streaming("EinfachGustaf.live", "https://twitch.tv/einfachgustaf")
            }
        }
        kord = bot.kordRef

        postInitialize.invoke(this)
        bot.start()
    }

    /**
     * Shutdown the bot.
     */
    suspend fun shutdown() {
        logger.info { "Shutting down the bot..." }
        bot.stop()
    }
}