package api.base.mongodb

import api.base.data.*
import io.github.cdimascio.dotenv.dotenv
import com.mongodb.client.MongoCollection
import com.mongodb.client.MongoDatabase
import org.litote.kmongo.*



class MongoDB {
    private val client = KMongo.createClient(connectionString = dotenv().get("MONGODB"))

    private fun database(name: String = DATABASE): MongoDatabase {
        return client.getDatabase(name)
    }

    fun collection(databaseName: String = DATABASE, collectionName: String): MongoCollection<UsuarioComum> {
        val db = database(databaseName)
        return db.getCollection<UsuarioComum>(collectionName)
    }

}


//fun main(){
//    val evento = Evento(
//            "Baile do Senado Federal",
//            "Festa Oficial",
//            "01-02-2020",
//            "8h30",
//            600f,
//            "Senado Federal de Brasília"
//    )
//    val usuario = UsuarioComum(
//            "Oliveira",
//            "111.222.333.45",
//            "01-02-2020",
//            mutableListOf(evento)
//    )
//
//    val mongoConnection = MongoDB()
//    val col = mongoConnection.collection(
//            DATABASE,
//            COL_USUARIO_COMUM
//    )
//    val ans = col.insertOne(usuario)
//    println("Insert id: ${ans.insertedId}")
//    println("Insert ok: ${ans.wasAcknowledged()}")
//}