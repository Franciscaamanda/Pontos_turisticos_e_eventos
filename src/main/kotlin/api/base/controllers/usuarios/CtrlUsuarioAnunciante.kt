package api.base.controllers.usuarios

import api.base.controllers.cadastro.ICadastroUsuarios
import api.base.models.evento.Evento
import api.base.models.usuarios.UsuarioAnunciante
import api.base.repository.RepoUsuarioAnunciante


class CtrlUsuarioAnunciante(override val usuario: UsuarioAnunciante) : ICadastroUsuarios {
    val RepoUsuarioAnunciante = RepoUsuarioAnunciante()

    fun adicionarEvento(evento: Evento) {
        usuario.eventosProprietario?.add(evento)
    }

    override fun criar(): Boolean {
        val novoAnunciante = usuario
        return RepoUsuarioAnunciante.add(novoAnunciante)
    }

    override fun atualizar(): Boolean {
        val novoPerfil = usuario
        val pessoa = RepoUsuarioAnunciante.get(novoPerfil.documento)

        return if (pessoa != null) {
            RepoUsuarioAnunciante.update(novoPerfil.documento, novoPerfil)
        } else false
    }

    override fun encontar(): List<Any> {
        TODO("Not yet implemented")
    }

    override fun deletar(): Boolean {
        TODO("Not yet implemented")
    }
}