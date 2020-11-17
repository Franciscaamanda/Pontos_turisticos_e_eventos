package api.base.repository.database.mongodb

import api.base.models.evento.Evento
import api.base.models.usuarios.UsuarioComum
import api.base.models.usuarios.UsuarioAnunciante
import api.base.repository.database.IGetCollection
import com.mongodb.client.MongoCollection
import org.litote.kmongo.getCollection


interface IColUsuarioComum: IGetCollection, MongoDBConnection {
    override fun getCollection(collectionName: String): MongoCollection<UsuarioComum> {
        val conn = connect()
        return conn.getCollection<UsuarioComum>(collectionName)
    }
}

interface IColUsuarioAnunciante: IGetCollection, MongoDBConnection {
    override fun getCollection(collectionName: String): MongoCollection<UsuarioAnunciante> {
        val conn = connect()
        return conn.getCollection<UsuarioAnunciante>(collectionName)
    }
}

interface IColEvento: IGetCollection, MongoDBConnection {
    override fun getCollection(collectionName: String): MongoCollection<Evento> {
        val conn = connect()
        return conn.getCollection<Evento>(collectionName)
    }
}
