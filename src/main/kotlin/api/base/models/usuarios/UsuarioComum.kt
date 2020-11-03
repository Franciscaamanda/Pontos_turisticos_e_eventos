package api.base.models.usuarios

import api.base.models.evento.Evento

data class UsuarioComum(
    override var nome: String,
    override var documento: String,
    var dataNasc: String,
): Usuario {
    var eventosCadastrados: List<Evento> = mutableListOf()
    var eventosInteresse: List<Evento> = mutableListOf()
}
