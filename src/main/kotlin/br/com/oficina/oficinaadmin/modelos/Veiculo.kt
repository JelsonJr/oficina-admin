package br.com.oficina.oficinaadmin.modelos

import jakarta.persistence.*
import java.time.Year

@Entity
class Veiculo(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val placa: String = "",
    val modelo: String = "",
    val ano: Int = Year.now().value,

    @ManyToOne
    var proprietario: Usuario? = null
) {
    override fun toString(): String {
        return "Veiculo: $placa, $modelo, $ano, ${proprietario?.nome}"
    }
}