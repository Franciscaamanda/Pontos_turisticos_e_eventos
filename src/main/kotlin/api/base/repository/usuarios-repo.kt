package api.base.repository

import LOG
import api.base.controllers.database.COL
import api.base.controllers.database.UsuarioAnuncianteConnection
import api.base.controllers.database.UsuarioComumConnection
import api.base.models.usuarios.UsuarioAnunciante
import api.base.models.usuarios.UsuarioComum
import api.base.models.usuarios.Usuario
import org.litote.kmongo.*


class UsuarioComumRepo: BaseRepoUsuarios {
    var connection = UsuarioComumConnection()
    var col = connection.getCollection(COL.UsuarioComum)

    override fun insert(usuario: Usuario): Boolean {
        return col.insertOne(usuario as UsuarioComum).wasAcknowledged()
    }

    override fun get(documento: String): UsuarioComum? {
        return col.findOne(UsuarioComum::documento eq documento)
    }

    override fun update(documento: String, novoUsuario: Usuario): Boolean{
        novoUsuario as UsuarioComum
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


class UsuarioAnuncianteRepo: BaseRepoUsuarios {
    var connection = UsuarioAnuncianteConnection()
    var col = connection.getCollection(COL.UsuarioAnunciante)

    override fun insert(usuario: Usuario): Boolean {
        return col.insertOne(usuario as UsuarioAnunciante).wasAcknowledged()
    }

    override fun get(documento: String): UsuarioAnunciante? {
        return col.findOne(UsuarioAnunciante::documento eq documento)
    }

    override fun update(documento: String, novoUsuario: Usuario): Boolean {
        novoUsuario as UsuarioAnunciante
        val ans = col.updateOne(UsuarioAnunciante::documento eq documento,
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
