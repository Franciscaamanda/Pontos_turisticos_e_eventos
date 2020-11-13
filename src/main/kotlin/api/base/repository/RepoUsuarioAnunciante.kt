package api.base.repository

import LOG
import org.litote.kmongo.*
import api.base.repository.database.COL
import api.base.models.usuarios.UsuarioAnunciante
import api.base.repository.database.mongodb.IColUsuarioAnunciante


class RepoUsuarioAnunciante: IRepoUsuarioAnunciante, IColUsuarioAnunciante {
    val col = getCollection(COL.UsuarioAnunciante.name)

    override fun add(usuario: UsuarioAnunciante): Boolean {
        return col.insertOne(usuario).wasAcknowledged()
    }

    override fun get(documento: String): UsuarioAnunciante? {
        return col.findOne(UsuarioAnunciante::documento eq documento)
    }

    override fun list(): MutableList<*> {
        return col.find().toMutableList()
    }

    override fun update(documento: String, novoUsuario: UsuarioAnunciante): Boolean {
        val ans = col.updateOne(novoUsuario::documento eq documento,
                set(
                        UsuarioAnunciante::nome setTo novoUsuario.nome,
                        UsuarioAnunciante::eventosProprietario setTo novoUsuario.eventosProprietario
                )
        )
        return ans.wasAcknowledged()
    }

    override fun delete(documento: String): Boolean {
        return col.deleteOne(UsuarioAnunciante::documento eq documento).wasAcknowledged()
    }
}
