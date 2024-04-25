package br.com.oficina.oficinaadmin.modelos

import jakarta.validation.constraints.*

data class DadosCadastro(
    @field:NotBlank(message = "O nome não pode estar em branco")
    @field:Size(min = 5, message = "O nome precisa ter ao menos 5 caracteres")
    val nome: String,

    @field:NotBlank(message = "O email não pode estar em branco")
    @field:Email(message = "Digite um formato válido para o email")
    val email: String,

    @field:NotBlank(message = "CPF não pode estar em branco")
    @field:Pattern(
        regexp = "^\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}$",
        message = "CPF deve estar no formato xxx.xxx.xxx-xx"
    )
    val cpf: String,

    @field:NotBlank(message = "A senha não pode estar em branco")
    @field:Size(min = 8, message = "A senha deve conter no mínimo 8 caracteres")
    val senha: String,

    @field:Size(max = 11, message = "O campo telefone só pode ter 11 caracteres")
    val telefone: String? = null,

    @field:NotBlank(message = "O campo da placa do veículo não pode estar em branco")
    @field:Pattern(regexp = "[A-Z]{3}\\d{4}", message = "Placa inválida")
    val placa: String,

    @field:NotBlank(message = "O campo do modelo do veículo não pode estar em branco")
    val modelo: String,

    @field:NotNull(message = "O campo do ano do veículo não pode estar vazio")
    @field:Max(2024, message = "O ano do veículo não pode ser uma data futura")
    @field:Min(1886, message = "Você tem um carro anterior ao ano da invenção do mesmo? Acho que não!")
    val ano: Int
)
