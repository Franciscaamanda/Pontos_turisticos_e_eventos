package api.base.controllers.usuarios

import api.base.controllers.cadastro.CadastroUsuarios
import api.base.models.usuarios.UsuarioAnunciante
import api.base.repository.RepoUsuarioAnunciante


class UsuarioAnuncianteController(override val usuario: UsuarioAnunciante) : CadastroUsuarios {
    val UsuarioAnuncianteRepo = RepoUsuarioAnunciante()

    override fun criar(): Boolean {
        val novoAnunciante = usuario
        return UsuarioAnuncianteRepo.add(novoAnunciante)
    }

    override fun atualizar(): Boolean {
        return UsuarioAnuncianteRepo.update(usuario.documento, usuario)
    }

    override fun encontrar(): Any? {
        return UsuarioAnuncianteRepo.get(usuario.documento)
    }

    override fun deletar(): Boolean {
        return UsuarioAnuncianteRepo.delete(usuario.documento)
    }
    override fun listar(): MutableList<*>{
        return UsuarioAnuncianteRepo.list()
    }
}