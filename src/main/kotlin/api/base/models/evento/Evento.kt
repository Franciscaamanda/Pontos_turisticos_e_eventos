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
    fun criarIngresso(ingresso: Ingresso){
        ingressos.add(ingresso)
    }
}
