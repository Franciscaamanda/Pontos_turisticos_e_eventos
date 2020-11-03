package api.base

import api.base.controllers.evento.Eventos
import api.base.controllers.cadastro.Cadastro
import api.base.routes.eventos
import api.base.routes.index
import api.base.routes.usuarioComum
import api.base.routes.usuarioAnunciante
import com.google.gson.Gson

import io.ktor.application.*
import io.ktor.features.*
import io.ktor.gson.*
import io.ktor.routing.*


val Cadastro = Cadastro()
var Eventos = Eventos()


fun Application.main() {
    install(ContentNegotiation) {
        gson {
            setPrettyPrinting()
        }
    }

    routing {
        val gson = Gson()
        val map = hashMapOf<String, String>()

        route("/") {
            index()
        }

        route("/evento") {
            eventos()
        }

        route("/usuario-comum"){
            usuarioComum()
        }

        route("/usuario-anunciante") {
            usuarioAnunciante()
        }
    }
}