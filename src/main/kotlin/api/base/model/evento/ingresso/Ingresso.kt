package api.base.model.evento.ingresso


open class Ingresso(
        var evento: String,
        var quantidade: Int,
        var descricao: String,
        var preco: Double,
        var dataInicio: String,   //Data de inicio das vendas e fim das vendas
        var dataFim: String       //Ver se compensa mudar de String pra Date
){
    lateinit var documentoUsuario: String

    fun voucher(){
        this.preco = 0.0
    }
}