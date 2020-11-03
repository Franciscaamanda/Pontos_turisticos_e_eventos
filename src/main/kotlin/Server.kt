import io.ktor.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import io.github.cdimascio.dotenv.dotenv
import api.base.main

import org.slf4j.LoggerFactory
import ch.qos.logback.classic.Level
import ch.qos.logback.classic.Logger


val loggerContext: Logger = LoggerFactory.getLogger(Logger.ROOT_LOGGER_NAME) as Logger
val mongoLogger: Unit = loggerContext.setLevel(Level.INFO)
val LOG: Logger = LoggerFactory.getLogger("Eventos - API") as Logger

val PORT = dotenv().get("PORT").toInt()


// Levanta um servidor e redireciona a aplicação para api.base.app.kt;
fun main(){
    embeddedServer(
        Netty,
        port = PORT,
        module = Application::main
    ).start(wait = true)
}
