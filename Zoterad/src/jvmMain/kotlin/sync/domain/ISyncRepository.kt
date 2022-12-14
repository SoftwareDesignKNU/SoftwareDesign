package sync.domain

fun interface ISyncRepository {
    suspend fun syncLibrary(): Result<Unit>;
}