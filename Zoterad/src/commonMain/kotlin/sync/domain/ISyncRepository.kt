package sync.domain

interface ISyncRepository {
    suspend fun syncLibrary(): Result<Nothing>
}