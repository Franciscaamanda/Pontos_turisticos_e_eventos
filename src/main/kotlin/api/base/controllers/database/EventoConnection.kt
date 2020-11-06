package api.base.controllers.database

import api.base.models.evento.Evento
import com.mongodb.client.MongoCollection
import org.litote.kmongo.getCollection


class EventoConnection: MongoDBConnection() {
    fun getCollection(collection: COL): MongoCollection<Evento> {
        val db = getDatabase()
        return db.getCollection<Evento>(collection.name)
    }
}