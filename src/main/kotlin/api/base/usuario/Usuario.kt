package api.base.usuario

import api.base.dao.UsuarioComumDAO
import api.base.model.UsuarioAnunciante
import api.base.model.UsuarioComum

class Usuario{

    private var usuarios = mutableListOf<UsuarioComum>()
    private var anunciantes = mutableListOf<UsuarioAnunciante>()
    private  var usuarioComumDAO = UsuarioComumDAO()

    fun criarUsuario(novoUsuario: UsuarioComum): Boolean {
        val ansInset = usuarioComumDAO.insert(novoUsuario)
        return ansInset
    }

    fun criarUsuario(){

    }

    fun atualizar(){

    }

}
