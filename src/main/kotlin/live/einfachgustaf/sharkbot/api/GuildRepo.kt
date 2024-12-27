package live.einfachgustaf.sharkbot.api

import com.mongodb.client.model.Filters.eq
import com.mongodb.kotlin.client.coroutine.MongoCollection
import dev.kord.common.entity.Snowflake
import dev.kord.core.Kord
import kotlinx.coroutines.flow.firstOrNull
import live.einfachgustaf.sharkbot.models.GuildModel
import kotlin.jvm.Throws

/**
 * The guild repository.
 * Used for handling guilds.
 *
 * @param collection The collection for the guilds.
 */
class GuildRepo(val collection: MongoCollection<GuildModel>, private val kord: Kord) {

    /**
     * Get a guild by its snowflake.
     *
     * @param id The snowflake of the guild.
     * @return The guild or null if it doesn't exist.
     */
    suspend fun getGuildBySnowflake(id: Snowflake): SharkGuild? {
        val guild = collection.find(eq("id", id.value.toLong())).firstOrNull() ?: return null
        return SharkGuild(kord.getGuild(id), guild)
    }

    /**
     * Setup a guild by its snowflake.
     * If the guild already exists, it will return the existing guild.
     *
     * @param id The snowflake of the guild.
     * @return The guild.
     */
    @Throws(IllegalStateException::class)
    suspend fun setupGuild(id: Snowflake): SharkGuild {
        val guildBySnowflake = getGuildBySnowflake(id)

        if (guildBySnowflake != null) {
            throw IllegalStateException("Guild already exists")
        }

        val kordGuild = kord.getGuild(id)
        val guild = SharkGuild(kordGuild, GuildModel(id.value.toLong(), kordGuild.name, kordGuild.owner.id.value.toLong()))

        collection.insertOne(guild.info)
        return guild
    }

    /**
     * Get a guild by its snowflake or set up a new guild.
     *
     * @param id The snowflake of the guild.
     * @return The guild.
     */
    suspend fun getGuildOrSetup(id: Snowflake): SharkGuild {
        return getGuildBySnowflake(id) ?: setupGuild(id)
    }

    /**
     * Check if a guild exists.
     *
     * @param id The snowflake of the guild.
     * @return If the guild exists.
     */
    suspend fun guildExists(id: Snowflake): Boolean {
        return (collection.withDocumentClass<GuildModel>().countDocuments(eq("id", id.value.toLong())) > 0)
    }
}