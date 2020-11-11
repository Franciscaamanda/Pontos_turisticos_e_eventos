package api.base.routes

import api.base.Cadastro
import api.base.models.usuarios.UsuarioAnunciante
import api.base.models.usuarios.UsuarioComum
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
        val usuarioAnunciante = Cadastro.criarUsuario(anunciante)

        if (usuarioAnunciante){
            map["Mensagem"] = "Anunciante cadastrado com sucesso!"
            call.respond(HttpStatusCode.Created, gson.toJson(map))
        }else{
            map["Mensagem"] = "Não foi possível criar o anunciante."
            call.respond(HttpStatusCode.BadRequest, gson.toJson(map))
        }
    }

    patch(path = "/atualizar"){
        val atualizar = call.receive<UsuarioAnunciante>()
        val novo = Cadastro.atualizarAnunciante(atualizar)

        if(novo){
            map["Mensagem"] = "Perfil Atualizado com sucesso!!"
            call.respond(HttpStatusCode.OK, gson.toJson(map))
        } else{
            map["Mensagem"] = "Usuário inexistente!"
            call.respond(HttpStatusCode.NotFound, gson.toJson(map))
        }
    }

    delete(path = "/excluir"){
        val excluir = call.receive<UsuarioAnunciante>()
        val usuario = Cadastro.deletarAnunciante(excluir)

        if(usuario){
            map["Mensagem"] = "Usuário deletado com sucesso!!"
            call.respond(HttpStatusCode.OK, gson.toJson(map))
        }else{
            map["Mensagem"] = "Usuário inexistente!"
            call.respond(HttpStatusCode.NotFound, gson.toJson(map))
        }
    }
}