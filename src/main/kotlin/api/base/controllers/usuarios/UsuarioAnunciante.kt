package api.base.controllers.usuarios

import api.base.controllers.cadastro.CadastroUsuarios
import api.base.models.usuarios.UsuarioAnunciante
import api.base.repository.UsuarioAnuncianteRepo


class UsuarioAnuncianteController(override val usuario: UsuarioAnunciante) : CadastroUsuarios {
    val UsuarioAnuncianteRepo = UsuarioAnuncianteRepo()

    override fun criar(): Boolean {
        val novoAnunciante = usuario
        return UsuarioAnuncianteRepo.insert(novoAnunciante)
    }

    override fun atualizar(): Boolean {
        return UsuarioAnuncianteRepo.update(usuario.documento, usuario);
    }

    override fun encontar(): List<Any> {
        TODO("Not yet implemented")
    }

    override fun deletar(): Boolean {
        val pessoa = UsuarioAnuncianteRepo.get(usuario.documento)
        if (pessoa != null){
            return UsuarioAnuncianteRepo.delete(usuario.documento)
        }else return false
    }
}