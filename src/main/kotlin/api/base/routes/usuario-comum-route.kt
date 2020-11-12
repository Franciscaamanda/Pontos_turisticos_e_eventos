package api.base.routes

import api.base.controllers.usuarios.UsuarioComumController
import api.base.models.usuarios.UsuarioComum

import com.google.gson.Gson
import io.ktor.application.*
import io.ktor.http.*
import io.ktor.request.*
import io.ktor.response.*
import io.ktor.routing.*


fun Route.usuarioComum() {
    val gson = Gson()
    val map = hashMapOf<String, String>()

    post(path = "/criar"){
        val comum = call.receive<UsuarioComum>()
        val cadastrarComum = UsuarioComumController(comum)
        val criadoComum = cadastrarComum.criar()

        if (criadoComum){
            map["Mensagem"] = "Usuário cadastrado com sucesso!"
            call.respond(HttpStatusCode.Created, gson.toJson(map))
        }else{
            map["Mensagem"] = "Não foi possível criar o usuário."
            call.respond(HttpStatusCode.BadRequest, gson.toJson(map))
        }
    }

    patch(path = "/atualizar"){
        val dadosAtualizados = call.receive<UsuarioComum>()
        val perfilComum = UsuarioComumController(dadosAtualizados)
        val estaAtualizado = perfilComum.atualizar()

        if(estaAtualizado){
            map["Mensagem"] = "Perfil Atualizado com sucesso!!"
            call.respond(HttpStatusCode.OK, gson.toJson(map))
        } else{
            map["Mensagem"] = "Usuário inexistente!"
            call.respond(HttpStatusCode.NotFound, gson.toJson(map))
        }
    }

    delete(path = "/excluir"){
        val excluir = call.receive<UsuarioComum>()
        val pessoa = UsuarioComumController(excluir)
        val usuario = pessoa.deletar()

        if(usuario){
            map["Mensagem"] = "Usuário deletado com sucesso!!"
            call.respond(HttpStatusCode.OK, gson.toJson(map))
        }else{
            map["Mensagem"] = "Usuário inexistente!"
            call.respond(HttpStatusCode.NotFound, gson.toJson(map))
        }
    }
}