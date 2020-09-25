package api.base.model

data class UsuarioAnunciante(
        var nome: String,
        var documento: String,
        var eventosProprietario: List<Evento>,
) {}