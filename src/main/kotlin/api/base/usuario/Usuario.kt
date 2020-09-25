package api.base.usuario

import api.base.data.DataSerialization
import api.base.data.Evento
import api.base.data.UsuarioAnunciante
import api.base.data.UsuarioComum

class Usuario{

    private var usuarios= mutableListOf<UsuarioComum>()
    private var anunciantes= mutableListOf<UsuarioAnunciante>()

    fun criarUsuario(nome:String,
                     CPF:String,
                     dataNasc:String,
                     eventosCadastrados:List<Evento>) {
        val usuario: DataSerialization = usuarios.filter { c ->
                    c.nome == nome &&
                    c.CPF == CPF &&
                    c.dataNasc == dataNasc &&
                    c.eventosCadastrados == eventosCadastrados} as DataSerialization
        usuario.usuarioComum(nome, CPF, dataNasc, eventosCadastrados)
    }
    fun criarUsuario(nome:String,
                     CNPJ:String,
                     eventosProprietario:List<Evento>){
        val anunciante: DataSerialization= anunciantes.filter {c-> c.nome== nome &&
                    c.CNPJ==CNPJ &&
                    c.eventosProprietario==eventosProprietario} as DataSerialization
        anunciante.usuarioAnunciante(nome, CNPJ, eventosProprietario)
    }
    fun atualizar(){

    }

}
