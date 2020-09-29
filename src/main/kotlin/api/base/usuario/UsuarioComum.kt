package api.base.usuario

class UsuarioComum(
        nome: String,
        documento: String,
) :Usuario(nome, documento){
    var dataNasc:String?=null
}
