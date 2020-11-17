package api.base.repository

import api.base.models.evento.Evento
import api.base.repository.database.COL
import api.base.repository.database.mongodb.IColEvento


class RepoEvento: IRepoEventos, IColEvento {
    private var col = getCollection(COL.ProximosEventos.name)

    override fun add(evento: Evento): Boolean {
        return col.insertOne(evento).wasAcknowledged()
    }

    override fun get() {
        super.get()
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

    override fun update() {
        super.update()
    }

    override fun delete() {
        super.delete()
    }
}