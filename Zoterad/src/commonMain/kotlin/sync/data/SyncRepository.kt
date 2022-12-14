package sync.data

import common.data.client.HttpClient
import common.data.database.Database
import sync.domain.ISyncRepository

class SyncRepository(
    private val database: Database = Database(),
    private val client: HttpClient = HttpClient(),
) : ISyncRepository {
    override suspend fun syncLibrary(): Result<Unit> {
        try {
            val user = database.user ?: return Result.failure(Exception("Auth error"))
            client.addLibraries(user, database.libraries)
            return Result.success(Unit)
        } catch (e: Exception) {
            return Result.failure(e)
        }
    }
}
