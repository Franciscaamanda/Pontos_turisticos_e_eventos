package api.base.routes

import LOG
import api.base.controllers.evento.EventosController
import api.base.models.evento.Evento
import api.base.repository.EventoRepo

import com.google.gson.Gson
import io.ktor.application.*
import io.ktor.http.*
import io.ktor.request.*
import io.ktor.response.*
import io.ktor.routing.*


fun Route.eventos() {
    val gson = Gson()
    val map = hashMapOf<String, String>()

    post(path = "/criar"){
        val evento = call.receive<Evento>()
        val novoEvento = EventosController(evento)
        val isCreated = novoEvento.criar()

        if(isCreated){
            LOG.info("Novo evento criado.")
            map["Mensagem"] = "Novo evento criado."
            call.respond(HttpStatusCode.Created, gson.toJson(map))
        }else{
            LOG.info("Erro ao criar o evento.")
            map["Mensagem"] = "Erro ao criar o evento."
            call.respond(HttpStatusCode.BadRequest, gson.toJson(map))
        }
    }

    get(path = "/listar"){
        val eventoRepo = EventoRepo()
        map["Eventos"] = eventoRepo.getAll().toString()
        call.respond(gson.toJson(map))
    }

    patch(path = "/atualizar"){

    }
}