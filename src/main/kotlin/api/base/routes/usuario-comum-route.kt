package api.base.routes

import api.base.controllers.usuarios.CtrlUsuarioAnunciante
import api.base.controllers.usuarios.CtrlUsuarioComum
import api.base.models.usuarios.UsuarioAnunciante
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
        try {
            val comum = call.receive<UsuarioComum>()
            val cadastrarComum = CtrlUsuarioComum(comum)

            if (cadastrarComum.criar()){
                map["Mensagem"] = "Usuário cadastrado com sucesso!"
                call.respond(HttpStatusCode.Created, gson.toJson(map))
            }else{
                map["Mensagem"] = "Não foi possível criar o usuário."
                call.respond(HttpStatusCode.BadRequest, gson.toJson(map))
            }
        }catch (e:Exception){
            call.respond(HttpStatusCode.BadRequest, gson.toJson(e.message))
        }
    }

    patch(path = "/atualizar"){
        try {
            val dadosAtualizados = call.receive<UsuarioComum>()
            val perfilComum = CtrlUsuarioComum(dadosAtualizados)

            if(perfilComum.atualizar()){
                map["Mensagem"] = "Perfil Atualizado com sucesso!!"
                call.respond(HttpStatusCode.OK, gson.toJson(map))
            } else{
                map["Mensagem"] = "Usuário inexistente!"
                call.respond(HttpStatusCode.NotFound, gson.toJson(map))
            }
        }catch (e:Exception){
            map["Mensagem"] = "Não foi possível atualizar informações do usuário, "+e.message
            call.respond(HttpStatusCode.BadRequest, gson.toJson(map))
        }
    }

    delete(path = "/excluir"){
        try {
            val excluir = call.receive<UsuarioComum>()
            val pessoa = CtrlUsuarioComum(excluir)

            if(pessoa.deletar()){
                map["Mensagem"] = "Usuário deletado com sucesso!!"
                call.respond(HttpStatusCode.OK, gson.toJson(map))
            }else{
                map["Mensagem"] = "Usuário inexistente!"
                call.respond(HttpStatusCode.NotFound, gson.toJson(map))
            }
        }catch (e:Exception){
            map["Mensagem"] = "Não foi possível deletar o usuário, "+e.message
            call.respond(HttpStatusCode.BadRequest, gson.toJson(map))
        }
    }
    get (path= "/encontrar"){
        try {
            val usuario = call.receive<UsuarioComum>()
            val pessoa = CtrlUsuarioComum(usuario).encontrar()
            if(pessoa != null){
                call.respond(HttpStatusCode.OK, gson.toJson(pessoa))
            }else{
                map["Mensagem"] = "Usuário inexistente!"
                call.respond(HttpStatusCode.NotFound, gson.toJson(map))
            }
        }catch (e: Exception){
            map["Mensagem"] = "Não foi possível encontrar o usuário, "+e.message
            call.respond(HttpStatusCode.BadRequest, gson.toJson(map))
        }
    }

    get (path = "/listar" ){
        val comum = UsuarioComum("","")
        val lista = CtrlUsuarioComum(comum).listar()

        if(lista != null){
            call.respond(HttpStatusCode.OK, gson.toJson(lista))
            return@get
        }
        map["Mensagem"] = "Nenhum usuário no momento"
        call.respond(HttpStatusCode.NotFound, gson.toJson(map))
    }

}