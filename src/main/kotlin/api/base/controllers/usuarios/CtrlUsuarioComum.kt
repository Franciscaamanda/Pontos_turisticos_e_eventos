package api.base.controllers.usuarios

import api.base.controllers.cadastro.ICadastroUsuarios
import api.base.models.evento.Evento
import api.base.models.evento.Ingresso
import api.base.models.usuarios.UsuarioComum
import api.base.repository.RepoUsuarioComum


class CtrlUsuarioComum(override val usuario: UsuarioComum) : ICadastroUsuarios {
    val RepoUsuarioComum = RepoUsuarioComum()

    fun adicionarEvento(evento: Evento){
        usuario.eventosCadastrados?.add(evento)
    }

    fun adicionarEventoInteresse(evento: Evento){
        usuario.eventosInteresse?.add(evento)
    }

    fun adicionarIngresso(ingresso: Ingresso){
        usuario.meusIngressos?.add(ingresso)
    }

    override fun criar(): Boolean {
        val novoComum = usuario
        return RepoUsuarioComum.add(novoComum)
    }

    override fun atualizar(): Boolean {
        val novoPerfil = usuario
        val pessoa = RepoUsuarioComum.get(novoPerfil.documento)

        return if (pessoa != null) {
            RepoUsuarioComum.update(novoPerfil.documento, novoPerfil)
        } else false
    }

    override fun encontar(): List<Any> {
        TODO("Not yet implemented")
    }

    override fun deletar(): Boolean {
        TODO("Not yet implemented")
    }
}