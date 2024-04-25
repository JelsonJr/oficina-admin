package br.com.oficina.oficinaadmin.services.validations

import br.com.oficina.oficinaadmin.modelos.DadosCadastro

interface Validation {

    fun validar(dados: DadosCadastro)
}
