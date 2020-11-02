package api.base.model.evento.ingresso

import java.util.*

open class Ingresso {
    var nome: String? = null
    val quantidade: Int? = null
    val descricao: String? = null
    val valor: Double? = null
    val datinicio: String? = null   //Data de inicio das vendas e fim das vendas
    val datfim: String? = null      //Ver se compensa mudar de String pra Date
    var tipo: String? = null

}