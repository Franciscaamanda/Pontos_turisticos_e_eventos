package api.base.dao

import api.base.model.UsuarioAnunciante
import api.base.model.UsuarioComum
import api.base.model.evento.Evento
import io.github.cdimascio.dotenv.dotenv
import com.mongodb.client.MongoCollection
import com.mongodb.client.MongoDatabase
import org.litote.kmongo.*



class MongoDBConnection {
    private val client = KMongo.createClient(connectionString = dotenv().get("MONGODB"))

    private fun database(database: DATABASE = DATABASE.PontosTuristicosEventos): MongoDatabase {
        return client.getDatabase(database.name)
    }

    fun collectionUsuarioComum(collection: COL): MongoCollection<UsuarioComum> {
        val db = database()
        return db.getCollection<UsuarioComum>(collection.name)
    }

    fun collectionUsuarioAnunciante(collection: COL): MongoCollection<UsuarioAnunciante> {
        val db = database()
        return db.getCollection<UsuarioAnunciante>(collection.name)
    }

    fun collectionEvento(collection: COL): MongoCollection<Evento> {
        val db = database()
        return db.getCollection<Evento>(collection.name)
    }
}