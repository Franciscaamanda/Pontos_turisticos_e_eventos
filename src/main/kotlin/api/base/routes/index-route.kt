package api.base.routes

import LOG
import com.google.gson.Gson
import io.ktor.application.*
import io.ktor.response.*
import io.ktor.routing.*


fun Route.index() {
    val gson = Gson()
    val map = hashMapOf<String, String>()

    get(path = "/") {
        LOG.info("Acesso às informações no Index")

        map["Título"] = "Pontos Turísticos e Eventos - API"
        map["Info"] = "API que disponibiliza recursos de visualização e divulgação de eventos, " +
                "encontros culturais e pontos turísticos."
        call.respond(gson.toJson(map))
    }
}