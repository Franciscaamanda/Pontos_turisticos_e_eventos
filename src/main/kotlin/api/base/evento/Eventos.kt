package api.base.evento

import api.base.dao.EventoDAO
import api.base.model.evento.Evento


class Eventos() {
    var eventoDAO = EventoDAO()

    fun criar(evento: Evento): Boolean{
        return eventoDAO.insert(evento)
    }

//    fun listar(): List<Evento> {
//        return eventoDAO.getAll()
//    }
}