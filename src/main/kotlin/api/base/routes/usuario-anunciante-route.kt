package api.base.routes


import LOG
import api.base.controllers.cadastro.Cadastro
import api.base.controllers.cadastro.CadastroUsuarios
//import api.base.controllers.database.COL
//import api.base.controllers.database.UsuarioAnuncianteConnection
//import api.base.controllers.usuarios.UsuarioAnuncianteController
import api.base.controllers.usuarios.CtrlUsuarioAnunciante

import api.base.models.usuarios.UsuarioAnunciante
import api.base.models.usuarios.UsuarioComum

import com.google.gson.Gson
import io.ktor.application.*
import io.ktor.http.*
import io.ktor.request.*
import io.ktor.response.*
import io.ktor.routing.*
import org.litote.kmongo.eq
import org.litote.kmongo.findOne


fun Route.usuarioAnunciante() {
    val gson = Gson()
    val map = hashMapOf<String, String>()

    post(path = "/criar"){
        val anunciante = call.receive<UsuarioAnunciante>()
        val cadatrarAnunciante = CtrlUsuarioAnunciante(anunciante)
        val criadoAnunciante = cadatrarAnunciante.criar()

        if (criadoAnunciante){
            map["Mensagem"] = "Anunciante cadastrado com sucesso!"
            call.respond(HttpStatusCode.Created, gson.toJson(map))
        }else{
            map["Mensagem"] = "Não foi possível criar o anunciante."
            call.respond(HttpStatusCode.BadRequest, gson.toJson(map))
        }
    }

    patch(path = "/atualizar"){
        val atualizar = call.receive<UsuarioAnunciante>()
        val pessoa = CtrlUsuarioAnunciante(atualizar)
        val novo = pessoa.atualizar()

        if(novo){
            map["Mensagem"] = "Perfil Atualizado com sucesso!!"
            call.respond(HttpStatusCode.OK, gson.toJson(map))
        } else{
            map["Mensagem"] = "Não foi possível atualizar informações de usuário!"
            call.respond(HttpStatusCode.NotFound, gson.toJson(map))
        }
    }

    delete(path = "/excluir"){
        val excluir = call.receive<UsuarioAnunciante>()
        val pessoa = CtrlUsuarioAnunciante(excluir)
        val usuario = pessoa.deletar()

        if(usuario){
            map["Mensagem"] = "Usuário deletado com sucesso!!"
            call.respond(HttpStatusCode.OK, gson.toJson(map))
        }else{
            map["Mensagem"] = "Usuário inexistente!"
            call.respond(HttpStatusCode.NotFound, gson.toJson(map))
        }
    }

    get (path= "/encontrar"){
        var usuario = call.receive<UsuarioAnunciante>()
        val pessoa = CtrlUsuarioAnunciante(usuario).encontar()
        if(pessoa != null){
            call.respond(HttpStatusCode.OK, gson.toJson(pessoa))
        }else{
            map["Mensagem"] = "Usuário inexistente!"
            call.respond(HttpStatusCode.NotFound, gson.toJson(map))
        }
    }
    get (path = "/listar" ){
        val anunciante = UsuarioAnunciante("","")
        val lista = CtrlUsuarioAnunciante(anunciante).listar()

        if(lista != null){
            call.respond(HttpStatusCode.OK, gson.toJson(lista))
            return@get
        }
        map["Mensagem"] = "Nenhum usuário no momento"
        call.respond(HttpStatusCode.NotFound, gson.toJson(map))
    }
}