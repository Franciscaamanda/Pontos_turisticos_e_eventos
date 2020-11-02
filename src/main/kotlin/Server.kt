import api.base.evento.Auxiliar
import api.base.evento.Eventos
import api.base.model.UsuarioAnunciante
import api.base.model.UsuarioComum
import api.base.model.evento.Evento
import api.base.model.evento.ingresso.Ingresso
import io.ktor.application.*
import io.ktor.features.*
import io.ktor.gson.*
import io.ktor.http.*
import io.ktor.request.*
import io.ktor.response.*
import io.ktor.routing.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import api.base.usuario.cadastro.Cadastro
import com.google.gson.Gson
import org.litote.kmongo.json
import kotlin.reflect.typeOf

val cadastro = Cadastro()
var eventos = Eventos()


fun main(){
    embeddedServer(Netty, 8080) {
        routing {
            install(ContentNegotiation) {
                gson {
                    setPrettyPrinting()
                }
            }
            // Infomações gerais sobre a API;
            get("/info") {
                call.respondText(
                    "API que disponibiliza recursos de visualização e divulgação de eventos," +
                            " encontros culturais e pontos turísticos.")
            }

            // Listar todos próximos eventos cadastrados;
            get("/listar-eventos"){
                call.respond(eventos.listaeventos())
            }

            //Listar todos os eventos Grátis (Possuem pelo menos um tipo de ingresso grátis)
            get("/listar-eventos-grátis"){
            }

            //Criar novo evento;
            post("/criar-evento"){
                // Verificar se o usuário é anunciante;
                val novo = call.receive<Evento>()
                val isCreated = eventos.criarevento(novo)

                if(isCreated){
                    call.respond(HttpStatusCode.Created, "Novo evento criado.")
                }else{
                    call.respond(HttpStatusCode.BadRequest, "Erro ao criar o evento.")
                }
            }

            post("/buscar-evento"){
                val id = call.receive<Int>()
                val evento: Evento? = eventos.buscaevento(id)
                if (evento!=null){
                    call.respond(evento)
                }else{
                    call.respondText("Evento não encontrado!")
                }

            }

            post("/excluir-evento"){
                val id = call.receive<Int>()
                var deleted: Boolean = eventos.deletaevento(id)
                if (deleted){
                    call.respondText("Evento excluído com sucesso!")
                }else {
                    call.respondText("Ocorreu um erro ao excluir o evento! Evento id: $id não encontrado!")
                }
            }

            post("/editar-evento"){
                val dados = call.receive<Auxiliar>()
                val update = eventos.updateevento(dados.id , dados.evento)
                if (update){
                    call.respondText("Evento atualizado com sucesso!")
                }else{
                    call.respondText("Ocorreu um erro ao atualizar o evento")
                }

            }

//            get("/criar-ingresso"){
//                val id = call.receive<Int>()
//                val deleted = eventos.criarevento()
//                if (){
//                }
//
//            }

            //Criar novo usuário;
            post("/criar/usuario/comum"){
                val novo = call.receive<UsuarioComum>()
                val usuarioCriado = cadastro.criarUsuario(novo)
                if (usuarioCriado){
                    call.respond(HttpStatusCode.Created, "Usuário cadastrado com sucesso!")
                }else{
                    call.respond(HttpStatusCode.BadRequest, "Não foi possível criar o usuário.")
                }
            }

            //Criar usuário anunciante;
            post("/criar/usuario/anunciante"){
                val anunciante = call.receive<UsuarioAnunciante>()
                val usuarioAnunciante = cadastro.criarUsuario(anunciante)
                if (usuarioAnunciante){
                    call.respond(HttpStatusCode.Created, "Anunciante cadastrado com sucesso!")
                }else{
                    call.respond(HttpStatusCode.BadRequest, "Não foi possível criar o anunciante.")
                }
            }

            // Update informações;
            route("/atualizar"){
                patch("/perfil"){
                    val atualizar = call.receive<UsuarioComum>()
                    val novo = cadastro.atualizarComum(atualizar)

                    if(novo){
                        call.respond(HttpStatusCode.OK, "Perfil Atualizado com sucesso!!")
                    } else{
                        call.respond(HttpStatusCode.NotFound,"Usuário inexistente!")
                    }
                }

                patch("/evento"){

                }
            }
        }
    }.start(wait = true)
}

