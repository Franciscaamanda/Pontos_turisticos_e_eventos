package api.base.controllers.eventos

import api.base.models.evento.Evento
import api.base.models.evento.Ingresso
import api.base.models.usuarios.UsuarioAnunciante
import api.base.controllers.cadastro.ICadastroEventos
import api.base.repository.RepoEvento


class CtrlEventos(override val evento: Evento): ICadastroEventos {
    var RepoEvento = RepoEvento()

    fun adicionarIngressoVendido(ingresso: Ingresso) {
        evento.ingressosVendidos?.add(ingresso)
    }

    fun adicionarOrganizador(usuarioAnunciante: UsuarioAnunciante) {
        evento.organizador = usuarioAnunciante
    }

    override fun criar(): Boolean{
        return RepoEvento.add(evento)
    }

    override fun atualizar(): Boolean {
        TODO("Not yet implemented")
    }

    override fun encontrar(): List<Any> {
        TODO("Not yet implemented")
    }

    override fun deletar(): Boolean {
        TODO("Not yet implemented")
    }

    override fun listar(): MutableList<*> {
        TODO("Not yet implemented")
    }
}