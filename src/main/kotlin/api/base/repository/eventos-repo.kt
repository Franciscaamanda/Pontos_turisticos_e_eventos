package api.base.repository

import api.base.models.evento.Evento
import api.base.controllers.database.COL
import api.base.controllers.database.MongoDBConnection
import com.mongodb.client.MongoCollection


class EventoRepo {
    var connection: MongoDBConnection = MongoDBConnection()
    var col: MongoCollection<Evento> = connection.collectionEvento(COL.ProximosEventos)

    fun insert(evento: Evento): Boolean {
        return col.insertOne(evento).wasAcknowledged()
    }

    fun getOne() {}

    fun getAll(): List<Evento> {
        println("$$$$$####################################################")

        val eventos = mutableListOf<Evento>()
        col.find().forEach { it -> eventos.add(it)}
        println(eventos)
        println("#########################################################")
        return eventos
    }
}