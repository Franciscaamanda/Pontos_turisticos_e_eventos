package api.base.controllers.cadastro

import api.base.models.usuarios.Usuario


interface ICadastroUsuarios: ICadastro {
    val usuario: Usuario
}