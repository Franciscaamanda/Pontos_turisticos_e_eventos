package api.base.models.evento

import api.base.models.usuarios.UsuarioAnunciante


data class Evento (
        val id: Int,
        val nome: String,
        var organizador: UsuarioAnunciante? = null,
        val categoria: String,
        val data: String,
        val horario: String,
        val endereco: String,
        val ingressosVendidos: MutableList<Ingresso>? = mutableListOf(),
)