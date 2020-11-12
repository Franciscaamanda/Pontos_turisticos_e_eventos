package api.base.controllers.cadastro


interface ICadastro {
    fun criar(): Boolean
    fun atualizar(): Boolean
    fun encontar(): List<Any>
    fun deletar(): Boolean
}
