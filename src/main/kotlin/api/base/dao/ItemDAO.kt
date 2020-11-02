package api.base.dao

import api.base.evento.Eventos
import api.base.model.UsuarioAnunciante
import api.base.model.UsuarioComum
import api.base.model.evento.Evento
import api.base.model.evento.ingresso.Ingresso
import com.mongodb.client.MongoCollection
import org.litote.kmongo.*
import org.litote.kmongo.util.idValue

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
    var col: MongoCollection<UsuarioComum> = connection.collectionUsuarioComum(COL.UsuarioComum)

    fun insert(usuario: UsuarioComum): Boolean {
        return col.insertOne(usuario).wasAcknowledged()
    }

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

class UsuarioAnuncianteDAO {
    var connection: MongoDBConnection = MongoDBConnection()
    var col: MongoCollection<UsuarioAnunciante> = connection.collectionUsuarioAnunciante(COL.UsuarioAnunciante)

    fun insert(usuario: UsuarioAnunciante): Boolean {
        return col.insertOne(usuario).wasAcknowledged()
    }

    fun get(documento: String): UsuarioAnunciante? {
        return col.findOne(UsuarioAnunciante::documento eq documento)
    }
}


class EventoDAO {
    var connection: MongoDBConnection = MongoDBConnection()
    var col: MongoCollection<Evento> = connection.collectionEvento(COL.ProximosEventos)

    fun insert(evento: Evento): Boolean {
        return col.insertOne(evento).wasAcknowledged()
    }

    fun get(id: Int): Evento? {
        return col.findOne(Evento::id eq id)
    }

    fun getall():MongoCollection<Evento>{
        return col
    }

    fun update(id: Int, novoEvento: Evento): Boolean {
        return if(col.findOne( Evento::id eq id)!= null){
            col.updateOne(novoEvento::id eq id, set(
                    Evento::nome setTo novoEvento.nome,
                    Evento::categoria setTo novoEvento.categoria,
                    Evento::data setTo novoEvento.data,
                    Evento::horario setTo novoEvento.horario,
                    Evento::endereco setTo novoEvento.horario,
                    Evento::tipo setTo novoEvento.tipo
                )
            )
            true
        }else {
            false
        }
    }

    fun delete(id: Int):Boolean{
        return if(col.findOne( Evento::id eq id)!= null){
            col.deleteOne(Evento::id eq id)
            true
        }else {
            false
        }
    }


//    fun insertingresso(id: Int, ingressos: MutableList<Ingresso>, ingresso: Ingresso): Boolean{
//        val ans = col.updateOne(
//            Evento::id eq id,
//            if(ingresso.valor==0.0) {
//                set(
//                    Evento::ingressos setTo ingressos.add(ingresso),
//                    Evento::tipo setTo "Grátis"
//                )
//            }else{
//                set(
//                    Evento::ingressos setTo ingressos.add(ingresso)
//                )
//            }
//        )
//        return ans.wasAcknowledged()
//    }

//    fun getfree() {}

}


//fun main() {
//    val evento = Evento(
//            "Baile do Senado Federal",
//            "Festa Oficial",
//            "01-02-2020",
//            "8h30",
//            600f,
//            "Senado Federal de Brasília"
//    )
//    val usuario = UsuarioComum(
//            "Gabriel",
//            "111.222.333.45",
//            "01-02-2020",
//            mutableListOf(evento),
//            mutableListOf()
//    )
//
////    val ans = ItemDAO().insertUsuarioComum(usuario)
////    println("Insert ok: $ans")
//    val ans = UsuarioComumDAO().delete("111.222.333.45")
//    println(ans)
//}