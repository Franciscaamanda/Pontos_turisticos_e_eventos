import api.base.data.UsuarioAnunciante
import api.base.data.UsuarioComum
import api.base.usuario.Usuario
import io.ktor.application.*
import io.ktor.features.*
import io.ktor.gson.*
import io.ktor.request.*
import io.ktor.response.*
import io.ktor.routing.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import api.base.usuario.cadastro.Cadastro

val pessoa= Cadastro()

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

            }

            // Criação de perfis de usuários;
            route("/criar/usuario"){
                post("/comum"){
                    val novo= call.receive<UsuarioComum>()
                    pessoa.criarUsuario(novo.nome, novo.CPF, novo.dataNasc, novo.eventosCadastrados)
                    call.respondText("<h1>Usuário cadastrado com sucesso!!!</h1>",io.ktor.http.ContentType.Text.Html)
                }
                post("/anunciante"){
                    val anunciante = call.receive<UsuarioAnunciante>()
                    pessoa.criarUsuario(anunciante.nome,anunciante.CNPJ,anunciante.eventosProprietario)
                    call.respondText("<h1>Usuário Anunciante cadastrado com sucesso!!!</h1>",io.ktor.http.ContentType.Text.Html)
                }
            }

            // Update informações;
            route("/atualizar"){
                patch("/perfil"){
                    val atualizar= call.receive<Usuario>()
                    val novo= pessoa.atualizarComum(atualizar)
                    call.respondText("$novo",io.ktor.http.ContentType.Text.Html)
                }
                patch("/evento"){

                }
            }
        }
    }.start(wait = true)
}