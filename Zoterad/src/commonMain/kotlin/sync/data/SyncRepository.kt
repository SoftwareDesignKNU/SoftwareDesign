package sync.data

import common.data.client.HttpClient
import common.data.database.Database
import sync.domain.ISyncRepository

class SyncRepository(
    private val database: Database = Database(),
    private val client: HttpClient = HttpClient(),
) : ISyncRepository {
    override suspend fun syncLibrary(): Result<Nothing> {
        // get data from database and put to server via client
        TODO("Not yet implemented")
    }
}