package api.base.models.usuarios

import api.base.models.evento.Evento
import api.base.models.evento.Ingresso


data class UsuarioComum(
    override var nome: String,
    override var documento: String,
    var dataNasc: String? = null,
    var eventosCadastrados: MutableList<Evento>? = mutableListOf(),
    var eventosInteresse: MutableList<Evento>? = mutableListOf(),
    var meusIngressos: MutableList<Ingresso>? = mutableListOf()
): Usuario
