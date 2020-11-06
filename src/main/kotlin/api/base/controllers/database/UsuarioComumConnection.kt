package api.base.controllers.database

import api.base.models.usuarios.UsuarioComum
import com.mongodb.client.MongoCollection
import org.litote.kmongo.getCollection


class UsuarioComumConnection: MongoDBConnection() {
    fun getCollection(collection: COL): MongoCollection<UsuarioComum> {
        val db = getDatabase()
        return db.getCollection<UsuarioComum>(collection.name)
    }
}