package api.base.model

data class UsuarioComum(
        var nome: String,
        var documento: String,
        var dataNasc: String,
        var eventosCadastrados: List<Evento>,
        var eventosInteresse: List<Evento>,
) {}
