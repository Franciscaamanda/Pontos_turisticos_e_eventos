package api.base.routes

import api.base.Eventos
import api.base.models.evento.Evento
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
        val novo = call.receive<Evento>()
        val isCreated = Eventos.criar(novo)

        if(isCreated){
            map["Mensagem"] = "Novo evento criado."
            call.respond(HttpStatusCode.Created, gson.toJson(map))
        }else{
            map["Mensagem"] = "Erro ao criar o evento."
            call.respond(HttpStatusCode.BadRequest, gson.toJson(map))
        }
    }

    get(path = "/listar"){
        val listaEventos: MutableList<Evento> = Eventos.listar() as MutableList<Evento>
        map["Eventos"] = listaEventos.toString()
        call.respond(gson.toJson(map))
    }

    patch(path = "/atualizar"){

    }
}