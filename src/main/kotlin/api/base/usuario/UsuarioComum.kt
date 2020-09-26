package api.base.usuario

import api.base.data.Evento
class UsuarioComum(nome: String, documento: String) :Usuario(nome, documento){
    var dataNasc:String?=null

}
