package api.base.controllers.database

import api.base.models.usuarios.UsuarioAnunciante
import api.base.models.usuarios.UsuarioComum
import api.base.models.evento.Evento
import io.github.cdimascio.dotenv.dotenv
import com.mongodb.client.MongoCollection
import com.mongodb.client.MongoDatabase
import org.litote.kmongo.*


enum class DATABASE {
    PontosTuristicosEventos,
}

enum class COL {
    UsuarioComum,
    UsuarioAnunciante,
    Eventos,
    ProximosEventos,
}


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