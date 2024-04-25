package br.com.oficina.oficinaadmin.repositorys

import br.com.oficina.oficinaadmin.modelos.Veiculo
import org.springframework.data.jpa.repository.JpaRepository

interface VeiculoRepository : JpaRepository<Veiculo, Long>{

}
