package sync.data

import data.client.HttpClient
import data.database.Database
import sync.domain.ISyncRepository

class SyncRepository(
    private val database: Database,
    private val client: HttpClient,
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
