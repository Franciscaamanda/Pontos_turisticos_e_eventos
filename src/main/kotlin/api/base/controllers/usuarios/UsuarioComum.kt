package api.base.controllers.usuarios

import api.base.controllers.cadastro.CadastroUsuarios
import api.base.models.usuarios.UsuarioComum
import api.base.repository.RepoUsuarioComum



class UsuarioComumController(override val usuario: UsuarioComum) : CadastroUsuarios {
    val UsuarioComumRepo = RepoUsuarioComum()

    override fun criar(): Boolean {
        val novoComum = usuario
        return UsuarioComumRepo.add(novoComum)
    }

    override fun atualizar(): Boolean {
        return UsuarioComumRepo.update(usuario.documento, usuario)
    }

    override fun encontrar(): Any? {
        return UsuarioComumRepo.get(usuario.documento)
    }

    override fun deletar(): Boolean {
        return UsuarioComumRepo.delete(usuario.documento)
    }

    override fun listar(): MutableList<*> {
        return UsuarioComumRepo.list()
    }
}