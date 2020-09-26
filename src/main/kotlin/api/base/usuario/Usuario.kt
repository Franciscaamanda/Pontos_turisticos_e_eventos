package api.base.usuario

import api.base.data.DataSerialization
import api.base.data.Evento
import api.base.data.UsuarioAnunciante
import api.base.data.UsuarioComum
import org.litote.kmongo.MongoOperator

open class Usuario(nome:String, documento:String) {
    var nome:String?=null
    var documento:String?=null
    var eventos:List<Evento>?=null

}

