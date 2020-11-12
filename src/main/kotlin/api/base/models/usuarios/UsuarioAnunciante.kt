package api.base.models.usuarios

import api.base.models.evento.Evento


data class UsuarioAnunciante(
    override var nome: String,
    override var documento: String,
    val eventosProprietario: MutableList<Evento>? = mutableListOf()
): Usuario