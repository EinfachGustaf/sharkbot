import dev.kord.common.entity.Snowflake
import live.einfachgustaf.sharkbot.api.GuildRepo
import live.einfachgustaf.sharkbot.bot
import live.einfachgustaf.sharkbot.models.GuildModel

suspend fun main() {
    bot.boot {
        val collection = mongoConnector.database.getCollection<GuildModel>("guilds_test")
        val guildRepo = GuildRepo(collection, kord)

        try {
            guildRepo.setupGuild(Snowflake(1065307087724363796))
        } catch (e: IllegalStateException) {
            println("skipping guild setup because it already exists")
        }

        val guildExists = guildRepo.guildExists(Snowflake(1065307087724363796))

        println("Guild exists: $guildExists")
    }
}