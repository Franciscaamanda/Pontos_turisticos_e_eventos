package api.base.usuario.cadastro

import api.base.data.Evento
import api.base.usuario.Usuario
import api.base.usuario.UsuarioAnunciante
import api.base.usuario.UsuarioComum

class Cadastro{
    private val usuarios= mutableListOf<Usuario>()

    fun criarUsuario(nome:String, CPF:String,dataNasc:String, eventosCadastrados:List<Evento>){
        val cadastro= UsuarioComum(nome.toString(), CPF.toString())
        cadastro.nome= nome
        cadastro.documento=CPF
        cadastro.eventos= eventosCadastrados
        cadastro.dataNasc= dataNasc
        usuarios.add(cadastro)
    }

    fun criarUsuario(nome: String,CNPJ:String, eventosProprietario:List<Evento>){
        val cadastro= UsuarioAnunciante(nome.toString(), CNPJ.toString())
        cadastro.nome=nome
        cadastro.documento=CNPJ
        cadastro.eventos=eventosProprietario
        usuarios.add(cadastro)
    }

    fun atualizarComum(perfil:Usuario):String{
        val pessoa= usuarios.find{it.nome==perfil.nome && it.documento==perfil.documento}
        return if(pessoa!=null){
            pessoa.eventos= perfil.eventos?.toMutableList()
            "Perfil Atualizado com sucesso!!"
        }else "Usuário inexistente!"
    }
}