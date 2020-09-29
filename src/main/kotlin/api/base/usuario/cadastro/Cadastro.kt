package api.base.usuario.cadastro

import api.base.dao.UsuarioAnuncianteDAO
import api.base.dao.UsuarioComumDAO
import api.base.model.evento.Evento
import api.base.usuario.Usuario
import api.base.usuario.UsuarioAnunciante
//import api.base.usuario.UsuarioComum
import api.base.model.UsuarioComum

class Cadastro {
    val usuarioComumDAO = UsuarioComumDAO()
    val usuarioAnuncianteDAO = UsuarioAnuncianteDAO()

//    fun criarUsuario(nome:String, CPF:String, dataNasc:String, eventosCadastrados:List<Evento>): Boolean{
//        val cadastro= UsuarioComum(nome.toString(), CPF.toString())
//        cadastro.nome= nome
//        cadastro.documento=CPF
//        cadastro.eventos= eventosCadastrados
//        cadastro.dataNasc= dataNasc
//        usuarios.add(cadastro)
//        return true
//    }

    fun criarUsuario(novo: UsuarioComum):Boolean {
        return usuarioComumDAO.insert(novo)
    }

    fun criarUsuario(novo: api.base.model.UsuarioAnunciante):Boolean {
        return usuarioAnuncianteDAO.insert(novo)
    }

    fun atualizarComum(perfil: UsuarioComum): Boolean {
        val pessoa = usuarioComumDAO.get(perfil.documento)
        return if (pessoa != null) {
            usuarioComumDAO.update(perfil.documento, perfil)
        } else false
    }
}