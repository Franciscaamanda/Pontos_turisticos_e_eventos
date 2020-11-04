package api.base.routes

import api.base.controllers.usuarios.UsuarioAnuncianteController
import api.base.models.usuarios.UsuarioAnunciante

import com.google.gson.Gson
import io.ktor.application.*
import io.ktor.http.*
import io.ktor.request.*
import io.ktor.response.*
import io.ktor.routing.*


fun Route.usuarioAnunciante() {
    val gson = Gson()
    val map = hashMapOf<String, String>()

    post(path = "/criar"){
        val anunciante = call.receive<UsuarioAnunciante>()
        val cadatrarAnunciante = UsuarioAnuncianteController(anunciante)
        val criadoAnunciante = cadatrarAnunciante.criar()

        if (criadoAnunciante){
            map["Mensagem"] = "Anunciante cadastrado com sucesso!"
            call.respond(HttpStatusCode.Created, gson.toJson(map))
        }else{
            map["Mensagem"] = "Não foi possível criar o anunciante."
            call.respond(HttpStatusCode.BadRequest, gson.toJson(map))
        }
    }
}