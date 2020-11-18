package api.base.repository.database


interface IGetCollection {
    fun getCollection(collectionName: String): Any
}