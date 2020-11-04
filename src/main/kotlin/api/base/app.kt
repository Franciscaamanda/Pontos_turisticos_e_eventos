package api.base

import api.base.routes.eventos
import api.base.routes.index
import api.base.routes.usuarioComum
import api.base.routes.usuarioAnunciante

import io.ktor.application.*
import io.ktor.features.*
import io.ktor.gson.*
import io.ktor.routing.*




fun Application.main() {
    install(ContentNegotiation) {
        gson {
            setPrettyPrinting()
        }
    }

    routing {

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