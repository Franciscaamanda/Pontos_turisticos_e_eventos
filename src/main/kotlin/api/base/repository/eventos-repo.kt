package api.base.repository

import api.base.controllers.database.MongoDBConnection
import com.mongodb.client.MongoCollection
import api.base.controllers.database.COL
import api.base.models.evento.Evento


class EventoRepo {
    private var connection: MongoDBConnection = MongoDBConnection()
    private var col: MongoCollection<Evento> = connection.collectionEvento(COL.ProximosEventos)

    fun insert(evento: Evento): Boolean {
        return col.insertOne(evento).wasAcknowledged()
    }

    fun getOne() {}

    fun getAll(): List<Evento> {
        println("$$$$$####################################################")

        val eventos = col.find().toList() as MutableList<Evento>
        println("ERROR:\n$eventos\n\n")

        println("#########################################################")
        return eventos
    }
}