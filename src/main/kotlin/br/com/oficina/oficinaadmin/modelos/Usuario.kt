package br.com.oficina.oficinaadmin.modelos

import jakarta.persistence.*

@Entity
class Usuario(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val nome: String = "",
    val email: String = "",
    val cpf: String = "",
    val senha: String = "",
    val telefone: String? = null,

    @OneToMany(fetch = FetchType.EAGER)
    val veiculos: MutableList<Veiculo> = mutableListOf<Veiculo>()
) {

    override fun toString(): String {
        return "Usuario: $nome, $email, $telefone, $cpf, $veiculos"
    }
}
