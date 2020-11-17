package api.base.models.evento

data class Ingresso (
    val nomeEvento: String? = null,
    val quantidade: Int? = null,
    val descricao: String? = null,
    val preco: Double? = null,
    val dataInicio: String? = null,
    val dataFim: String? = null
)