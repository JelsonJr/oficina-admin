package br.com.oficina.oficinaadmin.modelos

import jakarta.validation.constraints.*

data class DadosCadastroVeiculo (
    @field:NotBlank(message = "O campo da placa do veículo não pode estar em branco")
    @field:Size(min = 3, max = 7, message = "A placa deve ter entre 3 e 7 caracteres")
    val placa: String,

    @field:NotBlank(message = "O campo do modelo do veículo não pode estar em branco")
    val modelo: String,

    @field:NotNull(message = "O campo do ano do veículo não pode estar vazio")
    @field:Max(2024, message = "O ano do veículo não pode ser uma data futura")
    @field:Min(1886, message = "Você tem um carro anterior ao ano da invenção do mesmo? Acho que não!")
    val ano: Int
)