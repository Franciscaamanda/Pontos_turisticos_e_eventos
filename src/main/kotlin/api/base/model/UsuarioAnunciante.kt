package api.base.model

import api.base.model.evento.Evento

data class UsuarioAnunciante(
        var nome: String,
        var documento: String,
) {
        var eventosProprietario: List<Evento> = mutableListOf()
}