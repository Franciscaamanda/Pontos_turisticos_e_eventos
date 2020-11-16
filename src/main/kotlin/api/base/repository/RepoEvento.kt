package api.base.repository

import api.base.models.evento.Evento
import api.base.repository.database.COL
import api.base.repository.database.mongodb.IColEvento
import com.mongodb.client.MongoCollection
import org.litote.kmongo.eq
import org.litote.kmongo.findOne
import org.litote.kmongo.set
import org.litote.kmongo.setTo


class RepoEvento: IRepoEventos, IColEvento {
    private var col = getCollection(COL.ProximosEventos.name)

    override fun add(evento: Evento): Boolean {
        return col.insertOne(evento).wasAcknowledged()
    }

    override fun get(id: Int):Evento? {
        return col.findOne(Evento::id eq id)
    }

    override fun list(): MutableList<Evento> {
        val cursorEventos = col.find().iterator()
        val todosEventos = mutableListOf<Evento>()
        try {
            while (cursorEventos.hasNext()) {
                todosEventos.add(cursorEventos.next())
            }
        }catch (e: Exception) {
            return mutableListOf()
        }
        finally {
            cursorEventos.close()
        }
        return todosEventos
    }

    override fun update(id: Int, novoEvento: Evento): Boolean{
        return if(col.findOne( Evento::id eq id)!= null){
            col.updateOne(novoEvento::id eq id, set(
                Evento::nome setTo novoEvento.nome,
                Evento::categoria setTo novoEvento.categoria,
                Evento::data setTo novoEvento.data,
                Evento::horario setTo novoEvento.horario,
                Evento::endereco setTo novoEvento.horario,
            ))
            true
        }else {
            false
        }
    }

    override fun delete(id: Int):Boolean{
        return if(col.findOne( Evento::id eq id)!= null){
            col.deleteOne(Evento::id eq id)
            true
        }else {
            false
        }
    }
}