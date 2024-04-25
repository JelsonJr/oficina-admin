package br.com.oficina.oficinaadmin.services

import br.com.oficina.oficinaadmin.extensions.toVeiculo
import br.com.oficina.oficinaadmin.modelos.DadosCadastroVeiculo
import br.com.oficina.oficinaadmin.modelos.Veiculo
import br.com.oficina.oficinaadmin.repositorys.UsuarioRepository
import br.com.oficina.oficinaadmin.repositorys.VeiculoRepository
import org.springframework.stereotype.Service

@Service
class VeiculoService(
    private val usuarioRepository: UsuarioRepository,
    private val repository: VeiculoRepository
) {

    fun cadastrar(dadosCadastroVeiculo: DadosCadastroVeiculo, idUsuario: Long) {
        val proprietario = usuarioRepository.getReferenceById(idUsuario)
        val veiculo = dadosCadastroVeiculo.toVeiculo(proprietario)

        val veiculoCadastrado = repository.save(veiculo)

        proprietario.veiculos.add(veiculoCadastrado)
        usuarioRepository.save(proprietario)
    }

    fun getAll() :List<Veiculo> {
        return repository.findAll().toList()
    }

}
