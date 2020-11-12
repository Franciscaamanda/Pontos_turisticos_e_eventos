package api.base.controllers.database

import api.base.models.usuarios.UsuarioAnunciante
import com.mongodb.client.MongoCollection
import org.litote.kmongo.getCollection


class UsuarioAnuncianteConnection: MongoDBConnection() {
    fun getCollection(collection: COL): MongoCollection<UsuarioAnunciante> {
        val db = getDatabase()
        return db.getCollection<UsuarioAnunciante>(collection.name)
    }
}