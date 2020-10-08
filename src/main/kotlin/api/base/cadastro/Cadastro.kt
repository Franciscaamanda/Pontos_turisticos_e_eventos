package api.base.cadastro

import api.base.dao.UsuarioAnuncianteDAO
import api.base.dao.UsuarioComumDAO
import api.base.model.usuario.UsuarioComum
import api.base.model.usuario.UsuarioAnunciante


class Cadastro {
    val usuarioComumDAO = UsuarioComumDAO()
    val usuarioAnuncianteDAO = UsuarioAnuncianteDAO()

    fun criarUsuario(novo: UsuarioComum):Boolean {
        return usuarioComumDAO.insert(novo)
    }

    fun criarUsuario(novo: UsuarioAnunciante):Boolean {
        return usuarioAnuncianteDAO.insert(novo)
    }

    // Arrumar aqui
    fun atualizarComum(perfil: UsuarioComum): Boolean {
        val pessoa = usuarioComumDAO.get(perfil.documento)
        return if (pessoa != null) {
            usuarioComumDAO.update(perfil.documento, perfil)
        } else false
    }
}