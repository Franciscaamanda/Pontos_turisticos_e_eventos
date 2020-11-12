package api.base.controllers.cadastro

import api.base.models.evento.Evento


interface ICadastroEventos: ICadastro {
    val evento: Evento
}