package api.base.controllers.usuarios

import LOG
import api.base.controllers.cadastro.ICadastroUsuarios
import api.base.models.evento.Evento
import api.base.models.usuarios.UsuarioAnunciante
import api.base.repository.RepoUsuarioAnunciante


class CtrlUsuarioAnunciante (override val usuario: UsuarioAnunciante) : ICadastroUsuarios {
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
        val pessoa = novoPerfil.documento.let { RepoUsuarioAnunciante.get(it) }

        return if (pessoa != null) {
            RepoUsuarioAnunciante.update(novoPerfil.documento, novoPerfil)
        } else false
    }

    override fun encontrar(): UsuarioAnunciante? {
        return RepoUsuarioAnunciante.get(usuario.documento)
    }

    override fun deletar(): Boolean {
        val excluir = usuario
        val pessoa = excluir.documento.let { RepoUsuarioAnunciante.get(it) }

        return if (pessoa != null){
            RepoUsuarioAnunciante.delete(excluir.documento)
        }else false
    }

    override fun listar(): MutableList<*> {
        return RepoUsuarioAnunciante.list()
    }
}