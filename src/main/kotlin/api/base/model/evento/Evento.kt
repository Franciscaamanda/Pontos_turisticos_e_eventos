package api.base.model.evento

import api.base.model.evento.ingresso.Ingresso

data class Evento (
    val nome: String,
    val categoria: String,
    val data: String,
    val horario: String,
    val endereco: String,
){
    lateinit var organizador: String
    var ingressos = mutableListOf<Ingresso>()
}