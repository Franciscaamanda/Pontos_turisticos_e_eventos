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
        return RepoUsuarioComum.update(usuario.documento, usuario)
    }

    override fun encontar(): Any? {
        return RepoUsuarioComum.get(usuario.documento)
    }

    override fun deletar(): Boolean {
        return RepoUsuarioComum.delete(usuario.documento)
    }

    override fun listar(): MutableList<*> {
        return RepoUsuarioComum.list()
    }
}