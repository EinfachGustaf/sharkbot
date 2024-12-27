package live.einfachgustaf.sharkbot.db

import com.mongodb.kotlin.client.coroutine.MongoClient

/**
 * The Mongo connector.
 *
 * @param connectionString The connection string for the MongoDB database.
 */
class MongoConnector(private val connectionString: String, databaseName: String = "sharkbot") {

    val client = MongoClient.create(connectionString)
    val database = client.getDatabase(databaseName)
}