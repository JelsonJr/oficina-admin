package br.com.oficina.oficinaadmin.extensions

import br.com.oficina.oficinaadmin.modelos.DadosCadastro
import br.com.oficina.oficinaadmin.modelos.DadosCadastroVeiculo
import br.com.oficina.oficinaadmin.modelos.Usuario
import br.com.oficina.oficinaadmin.modelos.Veiculo
import org.springframework.security.crypto.password.PasswordEncoder
import java.util.Locale

fun DadosCadastro.toUsuario(passwordEncoder: PasswordEncoder): Usuario {
    val telefone = this.telefone ?: ""

    return Usuario(
        nome = this.nome,
        email = this.email,
        cpf = this.cpf.replace("[.-]".toRegex(), ""),
        senha = passwordEncoder.encode(this.senha),
        telefone = telefone,
    )
}
fun DadosCadastro.toVeiculo(proprietario: Usuario): Veiculo {
    return Veiculo(
        placa = this.placa,
        modelo = this.modelo,
        ano = this.ano,
        proprietario = proprietario
    )
}

fun DadosCadastroVeiculo.toVeiculo(proprietario: Usuario): Veiculo {
    return Veiculo(
        proprietario = proprietario,
        ano = this.ano,
        modelo = this.modelo,
        placa = this.placa.uppercase(Locale.getDefault())
    )
}
