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

    override fun encontar(): List<Any> {
        TODO("Not yet implemented")
    }

    override fun deletar(): Boolean {
        val deletar = usuario
        val pessoa = UsuarioComumRepo.get(deletar.documento)

        return if(pessoa != null){
            UsuarioComumRepo.delete(deletar.documento)
        } else false
    }

    override fun listar(): MutableList<*> {
        TODO("Not yet implemented")
    }
}