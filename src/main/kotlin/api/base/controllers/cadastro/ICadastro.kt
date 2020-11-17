package api.base.controllers.cadastro


interface ICadastro {
    fun criar(): Boolean
    fun atualizar(): Boolean
    fun encontar(): Any?
    fun deletar(): Boolean
    fun listar(): MutableList<*>
}
