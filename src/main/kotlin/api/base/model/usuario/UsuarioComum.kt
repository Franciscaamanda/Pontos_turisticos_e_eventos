package api.base.model.usuario

import api.base.model.evento.Evento

data class UsuarioComum(
        var nome: String,
        var documento: String,
        var dataNasc: String,

) {
    var eventosCadastrados: List<Evento> = mutableListOf()
    var eventosInteresse: List<Evento> = mutableListOf()
}
