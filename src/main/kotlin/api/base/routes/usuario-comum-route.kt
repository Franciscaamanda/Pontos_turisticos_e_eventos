package api.base.routes

import api.base.Cadastro
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
        val novo = call.receive<UsuarioComum>()
        val usuarioCriado = Cadastro.criarUsuario(novo)

        if (usuarioCriado){
            map["Mensagem"] = "Usuário cadastrado com sucesso!"
            call.respond(HttpStatusCode.Created, gson.toJson(map))
        }else{
            map["Mensagem"] = "Não foi possível criar o usuário."
            call.respond(HttpStatusCode.BadRequest, gson.toJson(map))
        }
    }

    patch(path = "/atualizar"){
        val atualizar = call.receive<UsuarioComum>()
        val novo = Cadastro.atualizarComum(atualizar)

        if(novo){
            map["Mensagem"] = "Perfil Atualizado com sucesso!!"
            call.respond(HttpStatusCode.OK, gson.toJson(map))
        } else{
            map["Mensagem"] = "Usuário inexistente!"
            call.respond(HttpStatusCode.NotFound, gson.toJson(map))
        }
    }
}