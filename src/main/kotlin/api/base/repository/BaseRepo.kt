package api.base.repository

import api.base.models.usuarios.Usuario


interface BaseRepoUsuarios {
    fun insert(usuario: Usuario): Boolean?
    fun get(documento: String): Usuario?
    fun update(documento: String, novoUsuario: Usuario): Boolean?
    fun delete(documento: String): Boolean?
}

interface BaseRepoEventos {
    fun insert() {}
    fun get() {}
    fun update() {}
    fun delete() {}
}