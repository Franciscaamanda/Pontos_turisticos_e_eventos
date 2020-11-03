package api.base.models.evento

import api.base.models.usuarios.UsuarioAnunciante

data class Evento (
    val nome: String,
    val categoria: String,
    val data: String,
    val horario: String,
    val endereco: String,
){
    var ingressos = mutableListOf<Ingresso>()
    val organizador: UsuarioAnunciante? = null
    fun criaringresso(ingresso: Ingresso){
        ingressos.add(ingresso)
    }
}

/*
{
    "nome": "RolêAleatório2",
    "categoria": "Workshop",
    "data": "xx/xx/xxx",
    "horario": "yy:yy",
    [
        {
            "nome": "Ingresso VIP",
            "quantidade": "50",
            "descricao": "acesso ao camarote etc",
            "preco": "200.0",
            "datinicio": "xx/xx/xxxx",
            "datfim": "xx+1/xx/xxx"
        }
    ]
}

 */