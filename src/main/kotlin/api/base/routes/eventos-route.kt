package api.base.routes

import LOG
import api.base.controllers.eventos.CtrlEventos
import api.base.models.evento.Evento
import api.base.repository.RepoEvento

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
        val novoEvento = CtrlEventos(evento)
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
        val repoEvento = RepoEvento()
        try {
            map["Eventos"] = gson.toJson(repoEvento.list())
            LOG.info("Listar próximos eventos.")
        }
        catch (e: Exception) {
            map["Eventos"] = "Erro ao consultar lista de eventos."
            LOG.info("$e")
        }
        finally {
            call.respond(map)
        }
    }

    patch(path = "/atualizar"){

    }
}