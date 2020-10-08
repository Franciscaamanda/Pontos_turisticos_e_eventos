package api.base.dao

import api.base.model.usuario.UsuarioAnunciante
import api.base.model.usuario.UsuarioComum
import api.base.model.evento.Evento
import com.mongodb.client.MongoCollection
import com.mongodb.client.MongoIterable
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

    fun getAll(){
        val result = col.find()
        val ans = result.forEach { evento: Evento ->
            Evento(evento.nome, evento.categoria, evento.data, evento.horario, evento.endereco)
        }
        return ans
//        return col.find().forEach{ evento: Evento -> Evento(evento.nome, evento.categoria, evento.data, evento.horario, evento.endereco)}
    }
}



fun main(){
    println(EventoDAO().getAll())
}