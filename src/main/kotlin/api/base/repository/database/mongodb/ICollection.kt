package api.base.repository.database.mongodb

import api.base.models.evento.Evento
import api.base.models.usuarios.UsuarioComum
import api.base.models.usuarios.UsuarioAnunciante
import com.mongodb.client.MongoCollection
import org.litote.kmongo.getCollection


interface IColUsuarioComum: MongoDBConnection {
    fun getCollection(collectionName: String): MongoCollection<UsuarioComum> {
        val conn = connect()
        return conn.getCollection<UsuarioComum>(collectionName)
    }
}

interface IColUsuarioAnunciante: MongoDBConnection {
    fun getCollection(collectionName: String): MongoCollection<UsuarioAnunciante> {
        val conn = connect()
        return conn.getCollection<UsuarioAnunciante>(collectionName)
    }
}

interface IColEvento: MongoDBConnection {
    fun getCollection(collectionName: String): MongoCollection<Evento> {
        val conn = connect()
        return conn.getCollection<Evento>(collectionName)
    }
}
