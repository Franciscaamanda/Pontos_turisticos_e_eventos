package api.base.evento

import api.base.model.evento.Evento

class Eventos() {
 var eventos = mutableListOf<Evento>()

    fun criarevento(evento: Evento){
        eventos.add(evento)
    }

}