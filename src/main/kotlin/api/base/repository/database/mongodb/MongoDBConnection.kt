package api.base.repository.database.mongodb

import org.litote.kmongo.*
import api.base.repository.database.*
import com.mongodb.client.MongoClient
import com.mongodb.client.MongoDatabase
import io.github.cdimascio.dotenv.dotenv


interface MongoDBConnection: IDatabaseConn {
    private val client: MongoClient
        get() = KMongo.createClient(connectionString = dotenv().get("MONGODB"))

    override fun connect(): MongoDatabase {
        val database = DATABASE.PontosTuristicosEventos
        return client.getDatabase(database.name)
    }
}


// MANEIRA BURRA
//class MongoDBConnection {
//    private val client = KMongo.createClient(connectionString = dotenv().get("MONGODB"))
//
//    private fun database(database: DATABASE = DATABASE.PontosTuristicosEventos): MongoDatabase {
//        return client.getDatabase(database.name)
//    }
//
//    fun collectionUsuarioComum(collection: COL): MongoCollection<UsuarioComum> {
//        val db = database()
//        return db.getCollection<UsuarioComum>(collection.name)
//    }
//
//    fun collectionUsuarioAnunciante(collection: COL): MongoCollection<UsuarioAnunciante> {
//        val db = database()
//        return db.getCollection<UsuarioAnunciante>(collection.name)
//    }
//
//    fun collectionEvento(collection: COL): MongoCollection<Evento> {
//        val db = database()
//        return db.getCollection<Evento>(collection.name)
//    }
//}