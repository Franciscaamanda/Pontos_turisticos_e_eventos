package api.base.repository

import api.base.models.evento.Evento
import api.base.models.usuarios.UsuarioComum
import api.base.models.usuarios.UsuarioAnunciante


interface IRepoUsuarioComum {
    fun add(usuario: UsuarioComum): Boolean
    fun get(documento: String): Any?
    fun list(): MutableList<*>
    fun update(documento: String, novoUsuario: UsuarioComum): Boolean
    fun delete(documento: String): Boolean
}


interface IRepoUsuarioAnunciante {
    fun add(usuario: UsuarioAnunciante): Boolean
    fun get(documento: String): Any?
    fun list(): MutableList<*>
    fun update(documento: String, novoUsuario: UsuarioAnunciante): Boolean
    fun delete(documento: String): Boolean
}


interface IRepoEventos {
    fun add(evento: Evento): Boolean
    fun get() {}
    fun list(): MutableList<*>
    fun update() {}
    fun delete() {}
}
