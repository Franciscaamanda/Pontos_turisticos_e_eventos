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
        val novoPerfil = usuario
        val pessoa = UsuarioAnuncianteRepo.get(novoPerfil.documento)

        return if (pessoa != null) {
            UsuarioAnuncianteRepo.update(novoPerfil.documento, novoPerfil)
        } else false
    }

    override fun encontar(): List<Any> {
        TODO("Not yet implemented")
    }

    override fun deletar(): Boolean {
        TODO("Not yet implemented")
    }
}