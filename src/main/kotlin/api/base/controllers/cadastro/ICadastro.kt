package api.base.controllers.cadastro


interface ICadastro {
    fun criar(): Boolean
    fun atualizar(): Boolean
    fun encontrar(): Any?
    fun deletar(): Boolean
    fun listar(): MutableList<*>
}
