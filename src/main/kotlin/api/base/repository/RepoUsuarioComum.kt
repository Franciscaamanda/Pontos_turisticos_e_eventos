package api.base.repository

import org.litote.kmongo.*
import api.base.repository.database.COL
import api.base.models.usuarios.UsuarioComum
import api.base.repository.database.mongodb.IColUsuarioComum


class RepoUsuarioComum: IRepoUsuarioComum, IColUsuarioComum {
    val col = getCollection(COL.UsuarioComum.name)

    override fun add(usuario: UsuarioComum): Boolean {
        return col.insertOne(usuario).wasAcknowledged()
    }

    override fun get(documento: String): Any? {
        return col.findOne(UsuarioComum::documento eq documento)
    }

    override fun list(): MutableList<*> {
        return col.find().toMutableList()
    }

    override fun update(documento: String, novoUsuario: UsuarioComum): Boolean{
        val ans = col.updateOne(novoUsuario::documento eq documento,
            set(
                UsuarioComum::nome setTo novoUsuario.nome,
                UsuarioComum::dataNasc setTo novoUsuario.dataNasc,
                UsuarioComum::eventosCadastrados setTo novoUsuario.eventosCadastrados,
                UsuarioComum::eventosInteresse setTo  novoUsuario.eventosInteresse
            )
        )
        return ans.wasAcknowledged()
    }

    override fun delete(documento: String): Boolean {
        return col.deleteOne(UsuarioComum::documento eq documento).wasAcknowledged()
    }

}
