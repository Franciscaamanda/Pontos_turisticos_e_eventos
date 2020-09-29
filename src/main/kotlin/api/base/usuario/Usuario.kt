package api.base.usuario

import api.base.dao.UsuarioComumDAO
import api.base.model.UsuarioAnunciante
import api.base.model.UsuarioComum
import api.base.model.evento.Evento

open class Usuario(nome: String, documento: String) {
    var nome:String?=null
    var documento:String?=null
    var eventos:List<Evento>?=null
//    private var usuarios = mutableListOf<UsuarioComum>()
//    private var anunciantes = mutableListOf<UsuarioAnunciante>()
//    private  var usuarioComumDAO = UsuarioComumDAO()
}

