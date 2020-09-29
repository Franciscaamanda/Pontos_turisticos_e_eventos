import api.base.evento.Eventos
import api.base.model.UsuarioAnunciante
import api.base.model.UsuarioComum
import api.base.model.evento.Evento
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
                call.respond(eventos)
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