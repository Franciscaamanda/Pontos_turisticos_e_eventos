package api.base.controllers.cadastro

import api.base.models.usuarios.UsuarioAnunciante
import api.base.repository.UsuarioAnuncianteRepo
import api.base.repository.UsuarioComumRepo
import api.base.models.usuarios.UsuarioComum


class Cadastro {
    val UsuarioComumRepo = UsuarioComumRepo()
    val UsuarioAnuncianteRepo = UsuarioAnuncianteRepo()

    fun criarUsuario(novo: UsuarioComum):Boolean {
        return UsuarioComumRepo.insert(novo)
    }

    fun criarUsuario(novo: api.base.models.usuarios.UsuarioAnunciante):Boolean {
        return UsuarioAnuncianteRepo.insert(novo)
    }

    fun atualizarComum(perfil: UsuarioComum): Boolean {
        val pessoa = UsuarioComumRepo.get(perfil.documento)
        return if (pessoa != null) {
            UsuarioComumRepo.update(perfil.documento, perfil)
        } else false
    }

    fun atualizarAnunciante(perfil: UsuarioAnunciante): Boolean {
        val pessoa = UsuarioAnuncianteRepo.get(perfil.documento)
        return if (pessoa != null) {
            UsuarioAnuncianteRepo.update(perfil.documento, perfil)
        } else false
    }

    fun encontrarComum(perfil: UsuarioComum){}

    fun encontrarAnunciante(perfil: UsuarioAnunciante){}

    fun deletarComum(perfil: UsuarioComum): Boolean{
        val pessoa = UsuarioComumRepo.get(perfil.documento)
        return if (pessoa != null){
            UsuarioComumRepo.delete(perfil.documento)
        }else false
    }

    fun deletarAnunciante(perfil: UsuarioAnunciante): Boolean{
        val pessoa = UsuarioAnuncianteRepo.get(perfil.documento)
        return if (pessoa != null){
            UsuarioAnuncianteRepo.delete(perfil.documento)
        }else false
    }
}