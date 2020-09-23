package api.base.data

import com.fasterxml.jackson.databind.jsonschema.JsonSerializableSchema


class DataSerialization {
    fun usuarioComum(
        nome: String,
        CPF: String,
        dataNasc: String,
        eventosCadastrados: List<Evento>
    ): UsuarioComum {
        return UsuarioComum(nome, CPF, dataNasc, eventosCadastrados)
    }

    fun usuarioAnunciante(
           nome: String,
           CNPJ: String,
           eventosProprietario: List<Evento>
    ): UsuarioAnunciante {
        return UsuarioAnunciante(nome, CNPJ, eventosProprietario)
    }

    fun evento(
        nome: String,
        categoria: String,
        data: String,
        horario: String,
        entrada: Float,
        endereco: String
    ): Evento {
        return Evento(nome, categoria, data, horario, entrada, endereco)
    }
}


@JsonSerializableSchema
data class UsuarioComum(
    val nome: String,
    val CPF: String,
    val dataNasc: String,
    var eventosCadastrados: List<Evento>
)

@JsonSerializableSchema
data class UsuarioAnunciante(
        val nome: String,
        val CNPJ: String,
        var eventosProprietario: List<Evento>,
)

@JsonSerializableSchema
data class Evento(
    val nome: String,
    val categoria: String,
    val data: String,
    val horario: String,
    val valorEntrada: Float,
    val endereco: String,
)
