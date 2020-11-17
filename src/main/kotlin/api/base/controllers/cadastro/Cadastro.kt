package api.base.controllers.cadastro


import api.base.models.usuarios.UsuarioAnunciante
import api.base.repository.RepoUsuarioAnunciante
import api.base.repository.RepoUsuarioComum
import api.base.models.usuarios.UsuarioComum

import api.base.models.evento.Evento
import api.base.models.usuarios.Usuario



interface Cadastro {
    fun criar(): Boolean
    fun atualizar(): Boolean
    fun encontar(): List<Any>
    fun deletar(): Boolean
    fun listar(): MutableList<*>
}


interface CadastroUsuarios: Cadastro {
    val usuario: Usuario
}
interface CadastroEventos: Cadastro {
    val evento: Evento
}

