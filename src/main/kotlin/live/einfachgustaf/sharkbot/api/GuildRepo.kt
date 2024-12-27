package live.einfachgustaf.sharkbot.api

import dev.kord.common.entity.Snowflake

/**
 * The guild repository.
 * Used for handling guilds.
 */
class GuildRepo {

    /**
     * Get a guild by its snowflake.
     *
     * @param id The snowflake of the guild.
     * @return The guild or null if it doesn't exist.
     */
    fun getGuildBySnowflake(id: Snowflake): SharkGuild? = TODO("Not yet implemented")

    /**
     * Setup a guild by its snowflake.
     * If the guild already exists, it will return the existing guild.
     *
     * @param id The snowflake of the guild.
     * @return The guild.
     */
    fun setupGuild(id: Snowflake): SharkGuild = TODO("Not yet implemented")

    /**
     * Get a guild by its snowflake or set up a new guild.
     *
     * @param id The snowflake of the guild.
     * @return The guild.
     */
    fun getGuildOrSetup(id: Snowflake): SharkGuild = TODO("Not yet implemented")
}