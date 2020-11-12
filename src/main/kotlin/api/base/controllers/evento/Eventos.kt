package api.base.controllers.evento

import api.base.controllers.cadastro.CadastroEventos
import api.base.repository.EventoRepo
import api.base.models.evento.Evento


class EventosController(override val evento: Evento): CadastroEventos {
    var EventoRepo = EventoRepo()

    override fun criar(): Boolean{
        return EventoRepo.insert(evento)
    }

    override fun atualizar(): Boolean {
        TODO("Not yet implemented")
    }

    override fun encontar(): List<Any> {
        TODO("Not yet implemented")
    }

    override fun deletar(): Boolean {
        TODO("Not yet implemented")
    }
}