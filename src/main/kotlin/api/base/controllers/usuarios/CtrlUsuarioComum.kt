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
        val pessoa = novoPerfil.documento.let { RepoUsuarioComum.get(it) }

        return if (pessoa != null) {
            RepoUsuarioComum.update(novoPerfil.documento, novoPerfil)
        } else false
    }

    override fun encontrar(): Any? {
        return RepoUsuarioComum.get(usuario.documento)
    }

    override fun deletar(): Boolean {
        val excluir = usuario
        val pessoa = excluir.documento.let { RepoUsuarioComum.get(it) }

        return if (pessoa != null){
            RepoUsuarioComum.delete(excluir.documento)
        }else false
    }

    override fun listar(): MutableList<*> {
        return RepoUsuarioComum.list()
    }
}