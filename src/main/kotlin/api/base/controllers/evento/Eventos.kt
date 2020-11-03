package api.base.controllers.evento

import api.base.repository.EventoRepo
import api.base.models.evento.Evento
import com.google.gson.Gson


class Eventos() {
    var EventoRepo = EventoRepo()

    fun criar(evento: Evento): Boolean{
        return EventoRepo.insert(evento)
    }

    fun atualizar() {}

    fun listar(): List<Evento> {
        val eventos = EventoRepo.getAll()
        return eventos
    }
}