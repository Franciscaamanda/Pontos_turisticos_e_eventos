package api.base.model

data class Evento (
    val nome: String,
    val categoria: String,
    val data: String,
    val horario: String,
    val valorEntrada: Float,
    val endereco: String,
) {}