package api.base.dao

import api.base.model.Evento
import api.base.model.UsuarioComum
import com.mongodb.client.MongoCollection
import org.litote.kmongo.*

enum class DATABASE {
    PontosTuristicosEventos,
}

enum class COL {
    UsuarioComum,
    UsuarioAnunciante,
    ProximosEventos,
}

class UsuarioComumDAO {
    var connection: MongoDBConnection = MongoDBConnection()
    var col: MongoCollection<UsuarioComum> = connection.collection(COL.UsuarioComum)

    fun get(documento: String): UsuarioComum? {
        return col.findOne(UsuarioComum::documento eq documento)
    }

    fun update(documento: String, novoUsuario: UsuarioComum): Boolean{
        val ans = col.updateOne(
            novoUsuario::documento eq documento,
            set(
                UsuarioComum::nome setTo novoUsuario.nome,
                UsuarioComum::dataNasc setTo novoUsuario.dataNasc,
                UsuarioComum::eventosCadastrados setTo novoUsuario.eventosCadastrados,
                UsuarioComum::eventosInteresse setTo  novoUsuario.eventosInteresse

            )
        )
        return ans.wasAcknowledged()
    }

    fun delete(documento: String): Boolean {
        return col.deleteOne(UsuarioComum::documento eq documento).wasAcknowledged()
    }

}


fun main() {
    val evento = Evento(
            "Baile do Senado Federal",
            "Festa Oficial",
            "01-02-2020",
            "8h30",
            600f,
            "Senado Federal de Brasília"
    )
    val usuario = UsuarioComum(
            "Gabriel",
            "111.222.333.45",
            "01-02-2020",
            mutableListOf(evento),
            mutableListOf()
    )

//    val ans = ItemDAO().insertUsuarioComum(usuario)
//    println("Insert ok: $ans")
    val ans = UsuarioComumDAO().delete("111.222.333.45")
    println(ans)
}