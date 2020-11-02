package api.base.model.evento

import api.base.evento.Eventos
import api.base.model.UsuarioAnunciante
import api.base.model.evento.ingresso.Ingresso
import org.litote.kmongo.eq
import org.litote.kmongo.findOne
import kotlin.reflect.full.memberProperties

data class Evento (
    val id: Int?,
    val nome: String?,
    val categoria: String?,
    val data: String?,
    val horario: String?,
    val endereco: String?,
    var tipo: String?
){
    var ingressos = mutableListOf<Ingresso>()
    val organizador: UsuarioAnunciante? = null

//    fun criaringresso(ingresso: Ingresso){
//        ingressos.add(ingresso)
//        val busca =  ingressos.filter{ it.tipo == "Grátis"}
//        if (busca != null) {
//            tipo = "Grátis"
//        }else{
//            tipo = "Pago"
//        }
//    }

}

/*
{
    "nome": "RolêAleatório2",
    "categoria": "Workshop",
    "data": "xx/xx/xxx",
    "horario": "yy:yy",
    "tipo": "Grátis"
    [
        {
            "nome": "Ingresso VIP",
            "quantidade": "50",
            "descricao": "acesso ao camarote etc",
            "preco": "0.0",
            "datinicio": "xx/xx/xxxx",
            "datfim": "xx+1/xx/xxx"
        }
    ]
}

 */

/*
{
    "id": "0",
    {
        "nome": "RolêAleatório2",
        "categoria": "Workshop",
        "data": "xx/xx/xxx",
        "horario": "yy:yy",
        "tipo": "Grátis"
    }
}
*/
