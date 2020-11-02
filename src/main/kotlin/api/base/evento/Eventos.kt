package api.base.evento

import api.base.dao.EventoDAO
import api.base.model.evento.Evento
import api.base.model.evento.ingresso.Ingresso
import com.mongodb.client.MongoCollection


class Eventos() {
    var eventoDAO = EventoDAO()

    fun criarevento(evento: Evento): Boolean{
        return eventoDAO.insert(evento)
    }


    fun buscaevento(id: Int): Evento?{
       return eventoDAO.get(id)
    }

    fun deletaevento(id:Int): Boolean{
        return eventoDAO.delete(id)
    }

    fun updateevento(id: Int, evento: Evento): Boolean{
        return eventoDAO.update(id, evento)
    }

    fun criaringresso(id: Int, ingressos: MutableList<Ingresso>, ingresso: Ingresso){
        val aux = buscaevento(id)
        //.insertingressos(...)

    }

    fun listaeventos():MongoCollection<Evento>{
        return eventoDAO.getall()
    }

    fun listagratis(){
        return
    }

    fun listapagos(){}



}