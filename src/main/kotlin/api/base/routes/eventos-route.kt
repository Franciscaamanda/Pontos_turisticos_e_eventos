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
            map["Mensagem"] = gson.toJson(repoEvento.list())
            LOG.info("Listar próximos eventos.")
        }
        catch (e: Exception) {
            map["Mensagem"] = "Erro ao consultar lista de eventos."
            LOG.info("$e")
        }
        finally {
            call.respond(map)
        }
    }

    patch(path = "/atualizar"){
        val dados = call.receive<Evento>()
        val repoEvento = RepoEvento()
        val update = repoEvento.update(dados.id, dados)
        LOG.info("Atualizar evento.")
        if (update){
            map["Mensagem"] = "Evento atualizado com sucesso!"
            call.respond(HttpStatusCode.OK, gson.toJson(map))
        }else{
            map["Mensagem"] = "Evento id: $dados.id não encontrado!"
            call.respond(HttpStatusCode.NotFound, gson.toJson(map))
        }
    }

    post(path = "/excluir"){
        val id = call.receive<Int>()
        val repoEvento = RepoEvento()
        LOG.info("Excluir evento.")
        val deleted: Boolean = repoEvento.delete(id)
        if (deleted){
            map["Mensagem"] = "Evento excluido com sucesso!!"
            call.respond(HttpStatusCode.OK, gson.toJson(map))
        }else {
            map["Mensagem"] = "Evento id: $id não encontrado!"
            call.respond(HttpStatusCode.NotFound, gson.toJson(map))
        }
    }

    post(path = "/buscar"){
        val repoEvento = RepoEvento()
        val id = call.receive<Int>()
        val busca = repoEvento.get(id)
        LOG.info("Buscar evento.")
        if (busca != null){
            call.respond(HttpStatusCode.OK, gson.toJson(busca))
        }else {
            map["Mensagem"] = "Evento id: $id não encontrado!"
            call.respond(HttpStatusCode.NotFound, gson.toJson(map))
        }
    }

}